import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Kiosk {
    public static int cost;
    public static int sales;
    public static int waiting;

    public static List<Order> wholeSaleList=new ArrayList<>();
    //TODO static 풀기
    static Scanner scan = new Scanner(System.in);

    //메인 메뉴판
    public static void showCategoryList() {
        System.out.println("\"노브랜드 버거는 최적의 식자재와 요리방법을 찾아 버거를 중심으로 다양하고 맛있는 새로운 웨스턴 스낵을 제공하는 캐주얼 버거하우스입니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ NoBrandBurger MENU ]");
        int i = 1;
        for (Category cat : AddData.categoryList) {
            System.out.printf("%d. %-12s | %s\n",i,cat.getCatName(),cat.getCatComment());
            i++;
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.printf("%d. %-12s | 주문내역을 확인 후 주문합니다.\n",i,"Order");
        System.out.printf("%d. %-12s | 진행중인 주문을 취소합니다.\n",i+1,"Cancel");
        System.out.println();
    }

    //상품 메뉴판
    public static void showProductsList(String categoryName) {
        System.out.println("\"노브랜드 버거는 최적의 식자재와 요리방법을 찾아 버거를 중심으로 다양하고 맛있는 새로운 웨스턴 스낵을 제공하는 캐주얼 버거하우스입니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ " + categoryName + " MENU ]");
        List<Product> catProduct = new ArrayList<>();
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

    //상품에 옵션을 선택한 후 장바구니에 추가할 수 있게 세분화
    //single(기본) Set
    private static void showProductOption(Product product) {
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        System.out.println("1. Single(W "+ product.getPrice()+")\t\t\t\t 2. Set(W "+ (int)(1.3*product.getPrice())+")");
        int op=scan.nextInt();
        if(op!=1){
            product.setOptionSet();
        }
    }

    //상품 메뉴 선택
    private static void selectProduct(List<Product> catProduct) {
        int num = scan.nextInt();
        System.out.println();
        for (int i = 0; i < catProduct.size(); i++) {
            Product pd=new Product(catProduct.get(num-1));
            if (i == num - 1) {
                //음료류가 아닐 떄만 옵션 선택
                if(!Objects.equals(pd.getCatName(),AddData.CAT_BEVERAGE.getCatName())){
                    showProductOption(pd);
                }
                System.out.println(pd.getPdName());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인\t\t\t\t 2. 취소");
                //상품 주문-> 주문목록 추가
                addOrder(pd);
            }
        }
    }

    //장바구니 추가
    private static void addOrder(Product product) {
        int confirm = scan.nextInt();
        if (confirm == 1) {
            System.out.println("\"" +   product.getPdName() + " 가 장바구니에 추가되었습니다.");
            //만약 주문하려는 상품이 이미 있으면 카운트만++ 없으면 추가 ->stream 으로 더 잘 짤 수 있을 것 같다.
            boolean ex = false;
            for (Order o : AddData.orderList) {
                if (Objects.equals(o.getPdName(), product.getPdName())) {
                    ex = true;
                    o.setCount(o.getCount() + 1);
                }
            }
            if (!ex)
                AddData.orderList.add(new Order(product));

            System.out.println();
        }
    }

    //장바구니 보기
    private static void showOrderList() throws InterruptedException {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println();
        System.out.println(" [ Orders ]");
        for (Order order : AddData.orderList) {
            System.out.printf("%-20s | W %-5d | %-2d개 | %s\n",order.getPdName(),order.getPrice(),order.getCount(),order.getPdComment());
            cost += order.getPrice() * order.getCount();
        }
        System.out.println("[ Total ]");
        System.out.println("W " + cost);
        System.out.println("1. 주문\t\t\t\t 2. 메뉴판");
        orderFinish();

    }

    //주문 확정
    private static void orderFinish() throws InterruptedException {
        int decision = scan.nextInt();
        if (decision == 1) {
            if (!AddData.orderList.isEmpty()) {
                System.out.println("주문이 완료되었습니다.");
                System.out.println("대기 번호는 [ " + ++waiting + " ] 번 입니다.");
                System.out.println("3초후 메뉴판으로 돌아갑니다.");
                sales+=cost;
                cost = 0;
                wholeSaleList.addAll(AddData.orderList);
                AddData.orderList.clear();
                Thread.sleep(3000);
            } else {
                System.out.println("장바구니가 비었습니다! 먼저 상품을 장바구니에 담아주세요!");
            }
        }
    }

    //메인 메뉴 선택
    public static void selectCategory() throws InterruptedException {
        int choice = scan.nextInt();
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
            case 0 -> showSales();
        }
    }
private static void showSales(){
    System.out.println("[ 총 판매금액 현황 ]");
    System.out.println("현재까지 총 판매된 금액은 [ W "+sales+" ] 입니다");
    System.out.println();
    System.out.println("[ 총 판매상품 목록 현황 ]");
    System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
    for (Order o : wholeSaleList) {
        System.out.printf(" - %-20s | W %-7d\n",o.getPdName(),o.getPrice());
    }
    System.out.println("1. 돌아가기");
    if(scan.nextInt()==1){
        showCategoryList();
    }else
        showSales();
}
    //입력받은 게 1이면 주문 취소, 장바구니 초기화, 메뉴판 출력
    private static void cancelOrder() {
        if (scan.nextInt() == 1) {
            System.out.println("진행하던 주문이 취소되었습니다.");
            cost = 0;
            AddData.orderList.clear();
        }
        //메인 메뉴판
        showCategoryList();
    }

}
