public class KioskApp {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.init();
        boolean run = true;

        while (true) {
            kiosk.showCategoryList();
            //카테고리 선택
            run=kiosk.selectCategory();
            if(!run)
                break;
            //메인 흐름을 여기다 구현하고 기능들을 맞춰서 호출
            //앱이 어떤 역할을 하는지 알 수 있게
        }
        System.out.println("키오스크가 종료되었습니다. Goodbye");
    }
}
