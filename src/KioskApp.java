
public class KioskApp {

    public static boolean start() throws InterruptedException {
        //메인 메뉴 화면
        Kiosk.showMain();
        //메인 화면 기능->상품화면->나머지기능 쭈루룩
        Kiosk.selectMain();
 
        return true;
    }
}
