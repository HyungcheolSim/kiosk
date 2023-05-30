import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class Kiosk {
    public static int cost;
    public static int waiting;
    //TODO static 풀기
    static Scanner scan = new Scanner(System.in);
    public static void showMain() {
        System.out.println("\"노브랜드 버거는 최적의 식자재와 요리방법을 찾아 버거를 중심으로 다양하고 맛있는 새로운 웨스턴 스낵을 제공하는 캐주얼 버거하우스입니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ NoBrandBurger MENU ]");
        int i = 1;
        for (Category cat : AddData.categoryList) {
            System.out.println(i + ". " + cat.getCatName() + "\t\t|" + cat.getCatComment());
            i++;
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println((i) + ". " + "\t\t|" + "주문내역을 확인 후 주문합니다.");
        System.out.println((i + 1) + ". " + "\t\t|" + "진행중인 주문을 취소합니다.");
        System.out.println();
    }

    public static void showProductsList(Category cat) {
        System.out.println("\"노브랜드 버거는 최적의 식자재와 요리방법을 찾아 버거를 중심으로 다양하고 맛있는 새로운 웨스턴 스낵을 제공하는 캐주얼 버거하우스입니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ " + cat.getCatName() + " MENU ]");
        List<Product> catProduct=new ArrayList<>();
        int j = 1;
        for (Product product : AddData.productList) {
            if (Objects.equals(product.getCatName(), cat.getCatName())) {
                System.out.println(j + ". " + product.getPdName() + "\t| W " + product.getPrice() / 1000.0 + " | " + product.getPdComment());
                catProduct.add(product);
                j++;
            }
        }
        //selectProduct();

        int num = scan.nextInt();
        System.out.println();
        for (int i = 0; i < catProduct.size(); i++) {
            if (i == num - 1) {
                System.out.println(catProduct.get(num - 1).getPdName());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인\t\t\t\t 2. 취소");
                int confirm=scan.nextInt();
                if(confirm==1){
                    System.out.println("\""+catProduct.get(num-1).getPdName()+" 가 장바구니에 추가되었습니다.");
                    AddData.orderList.add(new Order(catProduct.get(num-1)));
                    System.out.println();
                }
            }
        }
    }


    public static void showOrderList() throws InterruptedException {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println();
        System.out.println(" [ Orders ]");
        for (Order order : AddData.orderList) {
            System.out.println(order.getPdName() + "\t| W " + order.getPrice() + " | " + order.getPdComment());
            cost += order.getPrice();
        }
        System.out.println("[ Total ]");
        System.out.println("W " + cost);
        System.out.println("1. 주문\t\t\t\t 2. 메뉴판");
        int decision=scan.nextInt();
        if(decision==1){
            System.out.println("주문이 완료되었습니다.");
            System.out.println("대기 번호는 [ "+ ++waiting+" ] 번 입니다.");
            System.out.println("3초후 메뉴판으로 돌아갑니다.");
            cost=0;
            AddData.orderList.clear();
            Thread.sleep(3000);
        }
    }

    public static void selectMain() throws InterruptedException {
        int select=scan.nextInt();
        // 상품 화면 출력
        switch (select) {
            case 1 -> showProductsList(AddData.CAT_BURGER);
            case 2 -> showProductsList(AddData.CAT_BURGERPACK);
            case 3 -> showProductsList(AddData.CAT_SALAD);
            case 4 -> showProductsList(AddData.CAT_SIDE);
            case 5 -> showProductsList(AddData.CAT_BEVERAGE);
            case 6 -> showOrderList();
            case 7 -> {
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                if(scan.nextInt()==1){
                    System.out.println("진행하던 주문이 취소되었습니다.");
                    cost=0;
                    AddData.orderList.clear();
                }
                showMain();
            }
        }
    }

}
