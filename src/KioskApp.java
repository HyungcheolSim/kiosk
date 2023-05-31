
public class KioskApp {

    public static void start(){
        //메인 메뉴 화면
        Kiosk.showCategoryList();
        //메인 화면 기능->상품화면->나머지기능 쭈루룩
        Kiosk.selectCategory();
        //메인 흐름을 여기다 구현하고 기능들을 맞춰서 호출
        //앱이 어떤 역할을 하는지 알 수 있게
    }
}
