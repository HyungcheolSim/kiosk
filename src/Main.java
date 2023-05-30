public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean IsDataCreated=AddData.Prestruct();
        if(!IsDataCreated) {
            System.out.println("데이터가 정상적으로 생성되지 않았습니다.");
        }
        boolean kioskEnded;
        do {
            kioskEnded = KioskApp.start();
            //kioskEnded=false;
        } while (kioskEnded);
    }
}