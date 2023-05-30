import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Kiosk {
    public static int cost;
    public static int waiting;
    //TODO static 풀기
     static Scanner scan=new Scanner(System.in);
    //메인 메뉴판
    public static void showCategoryList() {
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
    //상품 메뉴판
    public static void showProductsList(String categoryName) {
        System.out.println("\"노브랜드 버거는 최적의 식자재와 요리방법을 찾아 버거를 중심으로 다양하고 맛있는 새로운 웨스턴 스낵을 제공하는 캐주얼 버거하우스입니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ " + categoryName + " MENU ]");
        List<Product> catProduct=new ArrayList<>();
        int j = 1;
        for (Product product : AddData.productList) {
            if (Objects.equals(product.getCatName(), categoryName)) {
                System.out.println(j + ". " + product.getPdName() + "\t| W " + product.getPrice() + " | " + product.getPdComment());
                catProduct.add(product);
                j++;
            }
        }
        //상품 메뉴 선택 호출
        selectProduct(catProduct);
    }
    //상품 메뉴 선택 
    public static void selectProduct(List<Product> catProduct){
        int num = scan.nextInt();
        System.out.println();
        for (int i = 0; i < catProduct.size(); i++) {
            if (i == num - 1) {
                System.out.println(catProduct.get(num - 1).getPdName());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인\t\t\t\t 2. 취소");
                //상품 주문-> 주문목록 추가
                addOrder(catProduct,num);
            }
        }
    }
    //장바구니 추가
    private static void addOrder(List<Product> catProduct,int num) {
        int confirm=scan.nextInt();
        if(confirm==1){
            System.out.println("\""+catProduct.get(num-1).getPdName()+" 가 장바구니에 추가되었습니다.");
            AddData.orderList.add(new Order(catProduct.get(num-1)));
            System.out.println();
        }
    }

    //장바구니 보기
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
        orderFinish();

    }
    //주문 확정
    private static void orderFinish() throws InterruptedException{
        int decision=scan.nextInt();
        if(decision==1){
            if(!AddData.orderList.isEmpty()) {
                System.out.println("주문이 완료되었습니다.");
                System.out.println("대기 번호는 [ " + ++waiting + " ] 번 입니다.");
                System.out.println("3초후 메뉴판으로 돌아갑니다.");
                cost = 0;
                AddData.orderList.clear();
                Thread.sleep(3000);
            }else{
                System.out.println("장바구니가 비었습니다! 먼저 상품을 장바구니에 담아주세요!");
            }
        }
    }

    //메인 메뉴 선택
    public static void selectCategory() throws InterruptedException {
        int choice=scan.nextInt();
        switch (choice) {
            case 1 -> showProductsList(AddData.CAT_BURGER.getCatName());
            case 2 -> showProductsList(AddData.CAT_BURGERPACK.getCatName());
            case 3 -> showProductsList(AddData.CAT_SALAD.getCatName());
            case 4 -> showProductsList(AddData.CAT_SIDE.getCatName());
            case 5 -> showProductsList(AddData.CAT_BEVERAGE.getCatName());
            case 6 -> showOrderList();
            case 7 -> {
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인\t\t\t\t 2. 취소");
                //주문 취소
                cancelOrder();

            }
        }
    }
//입력받은 게 1이면 주문 취소, 장바구니 초기화, 메뉴판 출력
    public static void cancelOrder(){
        if(scan.nextInt()==1){
            System.out.println("진행하던 주문이 취소되었습니다.");
            cost=0;
            AddData.orderList.clear();
        }
        //메인 메뉴판
        showCategoryList();
    }

}
