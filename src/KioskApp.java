import java.util.*;

public class KioskApp {

    public static void init() {
        Kiosk.init();
    }

    public static void start() {
        Scanner scan=new Scanner(System.in);
        //메인 메뉴 화면
        Kiosk.showCategoryList();
        //카테고리 선택
        Kiosk.selectCategory();

        //Kiosk.selectCategory(selectCat);
        //메인 흐름을 여기다 구현하고 기능들을 맞춰서 호출
        //앱이 어떤 역할을 하는지 알 수 있게
    }


}
