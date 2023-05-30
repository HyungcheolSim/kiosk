import java.util.ArrayList;
import java.util.List;

public class AddData {
    public static List<Category> categoryList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();
    public static List<Order> orderList = new ArrayList<>();

    //상품 카테고리
    public static final Category CAT_BURGER = new Category("Burgers", "직화구이 패티와 다양하고 매력적인 소스들, 부드러운 번으로 만든 최고의 가성비 버거");
    public static final Category CAT_BURGERPACK = new Category("Burger Pack", "더 저렴하게 푸짐한 세트를 즐기는 다양한 팩");
    public static final Category CAT_SALAD = new Category("Salad", "그날 그날 손질하고 소분해 준비한 신선하고 저렴한 샐러드");
    public static final Category CAT_SIDE = new Category("Side", "버거와 함께 혹은 사이드만이라도 괜찮아! 다채롭고 맛있는 사이드!");
    public static final Category CAT_BEVERAGE = new Category("Beverage", "버거를 더 맛있게 먹을 수 있게 해주는 음료");

    //버거 상품
    public static final Product NBB_AMAZING = new Product(CAT_BURGER.getCatName(), CAT_BURGER.getCatComment(), "NBB 어메이징", 5600, "더블 패티 & 더블 치즈, 어메이징한 크기의 NBB 어메이징 버거");
    public static final Product MEGA_BITE = new Product(CAT_BURGER.getCatName(), CAT_BURGER.getCatComment(), "메가바이트", 5000, "두툼한 직화 미트 패티에 바삭 해쉬브라운이 더해져 색다른ㄴ 식감과 풍성한 양의 버거");
    public static final Product NBB_SIGNATURE = new Product(CAT_BURGER.getCatName(), CAT_BURGER.getCatComment(), "NBB 시그니처", 4400, "직화 미트 패티에 진한 치즈를 얹어 깊은 맛을 선사하는 치즈버거");
    public static final Product NBB_ORIGINAL = new Product(CAT_BURGER.getCatName(), CAT_BURGER.getCatComment(), "NBB 오리지널", 3500, "직화 미트 패티에 신선한 양상추와 토마토, NBB 특제 소스를 더한 오리지널 버거");
    public static final Product BOLOGNESE_MEAT = new Product(CAT_BURGER.getCatName(), CAT_BURGER.getCatComment(), "볼로네제 미트", 6300, "두툼한 배티 위에 진한 볼로네제 미트소스로 고기 위에 고기를 더한 버거");
    public static final Product COLESLAW_CHICKEN = new Product(CAT_BURGER.getCatName(), CAT_BURGER.getCatComment(), "코울슬로 치킨", 4700, "아삭한 식감이 살아있는 달콤한 코울슬로와 바삭하게 튀긴 통가슴살 치킨 패티가 어우러진 버거");
    public static final Product MEAT_MANIA = new Product(CAT_BURGER.getCatName(), CAT_BURGER.getCatComment(), "미트마니아", 6100, "더블 패티와 더블 치즈, 고급스러운 트러플 핫 페퍼소스에 계란후라이까지 든든한 버거");


    //버거 팩 상품
    public static final Product SIGNATURE_PARTYPACK = new Product(CAT_BURGERPACK.getCatName(), CAT_BURGER.getCatComment(), "시그니처 파티팩", 19300, "NBB 시그니처, 메가바이트, 코울슬로 치킨, NBB 치킨너겟 5조각, 감자튀김 l, 탄산음료 3잔");
    public static final Product SIGNATURE_TOGETHERPACK = new Product(CAT_BURGERPACK.getCatName(), CAT_BURGER.getCatComment(), "시그니처 투게더팩", 14900, "NBB 시그니처, 코울슬로 치킨, 크런치 윙 2조각, 감자튀김L, 탄산음료 2잔");
    //샐러드
    public static final Product SANGHAI_PORK_SALAD = new Product(CAT_SALAD.getCatName(), CAT_SALAD.getCatComment(), "상하이 포크 샐러드", 4500, "아삭하고 신선한 채소에 든든한 상하이포크 튀김과 이탈리안 드레싱으로 만든 샐러드");
    public static final Product CHICKEN_CAESAR_SALAD = new Product(CAT_SALAD.getCatName(), CAT_SALAD.getCatComment(), "치킨시저 샐러드", 4500, "아삭하고 신선한 채소에 든든한 치킨텐더와 갈릭시저 드레싱으로 만든 샐러드");
    public static final Product GREEN_SALAD = new Product(CAT_SALAD.getCatName(), CAT_SALAD.getCatComment(), "그린 샐러드", 3400, "아삭하고 신선한 채소에 이탈리안 드레싱으로 한끼 식사로 손색없는 샐러드");
    //사이드
    public static final Product FRENCH_FRIES = new Product(CAT_SIDE.getCatName(), CAT_SIDE.getCatComment(), "감자튀김", 1800, "포슬포슬한 감자의 질감이 그대로 살아있는 고급 프랜치 프라이");
    public static final Product PEPPERONI_CIABATTA = new Product(CAT_SIDE.getCatName(), CAT_SIDE.getCatComment(), "페퍼로니 치아바타", 4900, "치아바타에 풍미 가득한 페퍼로니와 그릴 치즈로 든든한 오븐 샌드위치");
    public static final Product CHICKEN_NUGGET = new Product(CAT_SIDE.getCatName(), CAT_SIDE.getCatComment(), "NBB 치킨너겟", 1800, "닭다리 모양으로 먹는 재미를 더한 바삭한 치킨 너겟");
    public static final Product SUGAR_BUTTER_FRIES = new Product(CAT_SIDE.getCatName(), CAT_SIDE.getCatComment(), "슈가버터 프라이", 2900, "달콤한 버터 시럽을 뿌린 감자튀김과 진한 그라나파다노 치즈 토밍의 만남");
    public static final Product ONION_DOUGHNUT = new Product(CAT_SIDE.getCatName(), CAT_SIDE.getCatComment(), "어니언 도넛", 2900, "촉촉함과 바삭함을 동시에 느낄 수 있는 NBB만의 어니언 도넛");
    //음료
    public static final Product NB_COLA = new Product(CAT_BEVERAGE.getCatName(), CAT_SIDE.getCatComment(), "브랜드 콜라", 1800, "NBB에서만 만나볼 수 있는 브랜드 콜라");
    public static final Product NB_CIDAR = new Product(CAT_BEVERAGE.getCatName(), CAT_SIDE.getCatComment(), "브랜드 사이다", 1800, "NBB에서만 만나볼 수 있는 브랜드 사이다");
    public static final Product ORANGE_JUICE = new Product(CAT_BEVERAGE.getCatName(), CAT_SIDE.getCatComment(),"오랜지 주스",3300,"신선한 오랜지 주스");
    public static final Product AMERICANO = new Product(CAT_BEVERAGE.getCatName(), CAT_SIDE.getCatComment(),"아메리카노",2900,"야무진 아메리카노");
    public static final Product MINERAL_WATER = new Product(CAT_BEVERAGE.getCatName(), CAT_SIDE.getCatComment(),"노라벨 생수",1400,"비닐 라벨이 없어 분리배출이 편한 친환경 노라벨 생수");
    public static final Product PEPSIZERO = new Product(CAT_BEVERAGE.getCatName(), CAT_SIDE.getCatComment(),"펩시제로슈가",1800,"요즘 인기 최고의 제로 콜라");

    public static boolean Prestruct() {
        categoryList.add(CAT_BURGER);
        categoryList.add(CAT_BURGERPACK);
        categoryList.add(CAT_SALAD);
        categoryList.add(CAT_SIDE);
        categoryList.add(CAT_BEVERAGE);
        System.out.println("category 구성 완료");

        productList.add(NBB_AMAZING);
        productList.add(MEGA_BITE);
        productList.add(NBB_ORIGINAL);
        productList.add(NBB_SIGNATURE);
        productList.add(BOLOGNESE_MEAT);
        productList.add(COLESLAW_CHICKEN);
        productList.add(MEAT_MANIA);

        productList.add(SIGNATURE_PARTYPACK);
        productList.add(SIGNATURE_TOGETHERPACK);

        productList.add(SANGHAI_PORK_SALAD);
        productList.add(CHICKEN_CAESAR_SALAD);
        productList.add(GREEN_SALAD);

        productList.add(FRENCH_FRIES);
        productList.add(SUGAR_BUTTER_FRIES);
        productList.add(PEPPERONI_CIABATTA);
        productList.add(CHICKEN_NUGGET);
        productList.add(ONION_DOUGHNUT);

        productList.add(NB_COLA);
        productList.add(NB_CIDAR);
        productList.add(MINERAL_WATER);
        productList.add(AMERICANO);
        productList.add(ORANGE_JUICE);
        productList.add(PEPSIZERO);
        System.out.println("product 구성 완료");
        System.out.println();
        System.out.println();
        return true;
    }

}
