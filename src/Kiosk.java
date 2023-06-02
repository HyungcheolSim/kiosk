import java.util.*;

public class Kiosk {
    //public static Map<String, List<? extends Category>> dataMap;

    //Product Data
    public static Map<String, List<Product>> productMap;
    //Category Data
    public static List<Category> categoryList;
    //Order Data 를 받을 List
    public static List<Order> orderList = new ArrayList<>();

    //주문 시 총 금액
    private static double cost;
    //총 판매금액->이건 지역변수 넣을 수 있을 거같음
    private static double sales;
    //대기번호
    private static int waiting;
    //총 판매 목록을 담을 List
    static List<Order> wholeSaleList = new ArrayList<>();

    public static void init() {
        productMap = new HashMap<>();
        categoryList = Arrays.asList(
                new Category("Burgers", "직화구이 패티와 다양하고 매력적인 소스들, 부드러운 번으로 만든 최고의 가성비 버거"),
                new Category("Burger Pack", "더 저렴하게 푸짐한 세트를 즐기는 다양한 팩"),
                new Category("Salad", "그날 그날 손질하고 소분해 준비한 신선하고 저렴한 샐러드"),
                new Category("Side", "버거와 함께 혹은 사이드만이라도 괜찮아! 다채롭고 맛있는 사이드!"),
                new Category("Beverage", "버거를 더 맛있게 먹을 수 있게 해주는 음료"));

        List<Product> burgerList = Arrays.asList(
                new Product("NBB 어메이징", "더블 패티 & 더블 치즈, 어메이징한 크기의 NBB 어메이징 버거", 5.6),
                new Product("메가바이트", "두툼한 직화 미트 패티에 바삭 해쉬브라운이 더해져 색다른ㄴ 식감과 풍성한 양의 버거", 5.0),
                new Product("NBB 시그니처", "직화 미트 패티에 진한 치즈를 얹어 깊은 맛을 선사하는 치즈버거", 4.4),
                new Product("NBB 오리지널", "직화 미트 패티에 신선한 양상추와 토마토, NBB 특제 소스를 더한 오리지널 버거", 3.5),
                new Product("볼로네제 미트", "두툼한 배티 위에 진한 볼로네제 미트소스로 고기 위에 고기를 더한 버거", 6.3),
                new Product("코울슬로 치킨", "아삭한 식감이 살아있는 달콤한 코울슬로와 바삭하게 튀긴 통가슴살 치킨 패티가 어우러진 버거", 4.7),
                new Product("미트마니아", "더블 패티와 더블 치즈, 고급스러운 트러플 핫 페퍼소스에 계란후라이까지 든든한 버거", 6.1)
        );
        List<Product> burgerPackList = Arrays.asList(
                new Product("시그니처 파티팩", "NBB 시그니처, 메가바이트, 코울슬로 치킨, NBB 치킨너겟 5조각, 감자튀김 l, 탄산음료 3잔", 19.3),
                new Product("시그니처 투게더팩", "NBB 시그니처, 코울슬로 치킨, 크런치 윙 2조각, 감자튀김L, 탄산음료 2잔", 14.9)
        );
        List<Product> saladList = Arrays.asList(
                new Product("상하이 포크 샐러드", "아삭하고 신선한 채소에 든든한 상하이포크 튀김과 이탈리안 드레싱으로 만든 샐러드", 4.5),
                new Product("치킨시저 샐러드", "아삭하고 신선한 채소에 든든한 치킨텐더와 갈릭시저 드레싱으로 만든 샐러드", 4.5),
                new Product("그린 샐러드", "아삭하고 신선한 채소에 이탈리안 드레싱으로 한끼 식사로 손색없는 샐러드", 3.5));
        List<Product> sideList = Arrays.asList(
                new Product("감자튀김", "포슬포슬한 감자의 질감이 그대로 살아있는 고급 프랜치 프라이", 1.8),
                new Product("페퍼로니 치아바타", "치아바타에 풍미 가득한 페퍼로니와 그릴 치즈로 든든한 오븐 샌드위치", 4.9),
                new Product("NBB 치킨너겟", "닭다리 모양으로 먹는 재미를 더한 바삭한 치킨 너겟", 1.8),
                new Product("슈가버터 프라이", "달콤한 버터 시럽을 뿌린 감자튀김과 진한 그라나파다노 치즈 토밍의 만남", 2.9),
                new Product("어니언 도넛", "촉촉함과 바삭함을 동시에 느낄 수 있는 NBB만의 어니언 도넛", 2.9));
        List<Product> beverageList = Arrays.asList(
                new Product("브랜드 콜라", "NBB에서만 만나볼 수 있는 브랜드 콜라", 1.8),
                new Product("브랜드 사이다", "NBB에서만 만나볼 수 있는 브랜드 사이다", 1.8),
                new Product("오랜지 주스", "신선한 오랜지 주스", 3.3),
                new Product("아메리카노", "야무진 아메리카노", 2.9),
                new Product("노라벨 생수", "비닐 라벨이 없어 분리배출이 편한 친환경 노라벨 생수", 1.4),
                new Product("펩시제로슈가", "요즘 인기 최고의 제로 콜라", 1.8)
        );
        productMap.put("Burgers", burgerList);
        productMap.put("BurgerPacks", burgerPackList);
        productMap.put("Salads", saladList);
        productMap.put("Sides", sideList);
        productMap.put("Beverage", beverageList);

    }

    //메인 메뉴판
    public static void showCategoryList() {
        System.out.println("===================================================================================");
        System.out.println("\"노브랜드 버거는 최적의 식자재와 요리방법을 찾아 버거를 중심으로 다양하고 맛있는 새로운 웨스턴 스낵을 제공하는 캐주얼 버거하우스입니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ NoBrandBurger MENU ]");
        int i = 1;
        for (Category cat : categoryList) {
            System.out.printf("%d. %-12s | %s\n", i, cat.getName(), cat.getDescription());
            i++;
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.printf("%d. %-12s | 주문내역을 확인 후 주문합니다.\n", i, "Order");
        System.out.printf("%d. %-12s | 진행중인 주문을 취소합니다.\n", i + 1, "Cancel");
        System.out.println();
    }

    //상품 메뉴판
    public static void showProductsList(String keyName, int selectCat) {
        System.out.println("\"노브랜드 버거는 최적의 식자재와 요리방법을 찾아 버거를 중심으로 다양하고 맛있는 새로운 웨스턴 스낵을 제공하는 캐주얼 버거하우스입니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ " + keyName + " MENU ]");
        int j = 1;
        for (Product product : productMap.get(keyName)) {
            //줄
            //System.out.println(j + ". " + product.getName() + "\t| W " + product.getPrice() + " | " + product.getDescription());
            System.out.printf("%d. %-12s | W %3.1f | %s\n", j, product.getName(), product.getPrice(), product.getDescription());
            j++;
        }
        selectProduct(productMap.get(keyName), selectCat);
    }

    //상품에 옵션을 선택한 후 장바구니에 추가할 수 있게 세분화
    //single(기본) Set
    public static void showProductOption(Product product) {
        Scanner scan = new Scanner(System.in);
        System.out.println(product.getName());
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        System.out.println("1. Single(W " + product.getPrice() + ")\t\t\t\t 2. Set(W " + String.format("%.1f", 1.3 * product.getPrice()) + ")");

        int op = scan.nextInt();
        if (op == 2) {
            product.setOptionSet();
        } else if (op != 1) {
            System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
            showProductOption(product);
        }
    }
    //상품 메뉴 선택
    public static void selectProduct(List<Product> catProduct, int selectCat) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        if (num <= catProduct.size()) {
            System.out.println();
            for (int i = 0; i < catProduct.size(); i++) {
                Product pd = new Product(catProduct.get(num - 1));
                if (i == num - 1) {
                    //음료류가 아닐 떄만 옵션 선택->카테고리 선택한 int 가 1,3,4일 때만
                    if (selectCat == 1 || selectCat == 3 || selectCat == 4) {
                        showProductOption(pd);
                    }
                    //상품 주문-> 주문목록 추가
                    addOrder(pd);
                }
            }
        } else {
            System.out.println("화면을 잘 읽어주세요. 선택지는 1,2,3,4,5,6,7 입니다.");
            selectProduct(catProduct, selectCat);
        }
    }

    //장바구니 추가
    public static void addOrder(Product product) {
        System.out.println(product.getName());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t\t\t\t 2. 취소");
        Scanner scan = new Scanner(System.in);
        int confirm = scan.nextInt();
        if (confirm == 1) {
            System.out.println("\"" + product.getName() + " 가 장바구니에 추가되었습니다.\"");
            //만약 주문하려는 상품이 이미 있으면 카운트만++ 없으면 추가 ->stream 으로 더 잘 짤 수 있을 것 같다.
            boolean ex = false;
            for (Order o : orderList) {
                if (Objects.equals(o.getName(), product.getName())) {
                    ex = true;
                    o.setCount(o.getCount() + 1);
                }
            }
            if (!ex)
                orderList.add(new Order(product));

            System.out.println();
        }else if(confirm==2){
            System.out.println("주문을 취소하셨습니다.");
        }else{
            System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
            addOrder(product);
        }
        //showCategoryList();
    }

    //장바구니 보기
    public static void showOrderList() {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println();
        System.out.println(" [ Orders ]");
        for (Order order : orderList) {
            System.out.printf("%-15s | W %3.1f | %-2d개 | %s\n", order.getName(), order.getPrice(), order.getCount(), order.getDescription());
            cost += order.getPrice() * order.getCount();
        }
        System.out.println("[ Total ]");
        System.out.printf("W %2.1f \n", cost);
        System.out.println("1. 주문\t\t\t\t 2. 메뉴판");
        orderFinish();

    }

    //주문 확정
    public static void orderFinish() {
        Scanner scan = new Scanner(System.in);
        int decision = scan.nextInt();
        if (decision == 1) {
            if (!orderList.isEmpty()) {
                System.out.println("주문이 완료되었습니다.");
                System.out.println("대기 번호는 [ " + ++waiting + " ] 번 입니다.");
                System.out.println("3초후 메뉴판으로 돌아갑니다.");
                sales += cost;
                wholeSaleList.addAll(orderList);
                orderList.clear();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            } else {

                System.out.println("장바구니가 비었습니다! 먼저 상품을 장바구니에 담아주세요!");
            }
        } else if(decision==2){
            System.out.println("카테고리 메뉴판으로 이동합니다.");

        }else{
            System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요.");
            cost = 0;
            showOrderList();
        }
        cost = 0;

    }

    //메인 메뉴 선택
    public static void selectCategory() {
        Scanner scan = new Scanner(System.in);
        int selectCat = scan.nextInt();
        switch (selectCat) {
            case 1 -> showProductsList("Burgers", selectCat);
            case 2 -> showProductsList("BurgerPacks", selectCat);
            case 3 -> showProductsList("Salads", selectCat);
            case 4 -> showProductsList("Sides", selectCat);
            case 5 -> showProductsList("Beverage", selectCat);
            case 6 -> showOrderList();
            //주문 취소
            case 7 -> {
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인\t\t\t\t 2. 취소");
                cancelOrder();
            }
            case 0 -> showSales();
            default -> System.out.println("잘못된 번호를 입력하셨습니다. 정확한 번호를 입력해주세요.");
        }
    }

    public static void showSales() {
        Scanner scan = new Scanner(System.in);
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ W  %-3.1f  ] 입니다\n", sales);
        System.out.println();
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        for (Order o : wholeSaleList) {
            System.out.printf(" - %-15s | W %3.1f\n", o.getName(), o.getPrice());
        }
        System.out.println("1. 돌아가기");
        if (scan.nextInt() == 1) {
            System.out.println("메인을 돌아갑니다.");
        } else
            showSales();
    }

    //입력받은 게 1이면 주문 취소, 장바구니 초기화, 메뉴판 출력
    public static void cancelOrder() {
        Scanner scan = new Scanner(System.in);
        int cancel=scan.nextInt();
        if (cancel == 1) {
            System.out.println("진행하던 주문이 취소되었습니다.");
            cost = 0;
            orderList.clear();
        }else if(cancel==2){
            System.out.println("주문 취소를 취소했습니다. 메인 화면으로 갑니다.");
        }else{
            System.out.println("잘못 입력하셨습니다 .메인 화면으로 갑니다.");
        }
        //메인 메뉴판-> 실행의 끝이라 알아서 메인으로 감
        //showCategoryList();
    }
}
