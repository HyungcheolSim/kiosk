import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KioskApp.init();
        while (true) {
            KioskApp.start();
            Scanner scan = new Scanner(System.in);
            System.out.println("종료하고 싶으시면 exit 을 입력해주세요");
            System.out.println("다시 시작하고 싶으시면 exit 제외한 문자를 입력해주세요");
            String exit = scan.next().toLowerCase();
            if (exit.equals("exit")) {
                System.out.println("키오스크 시스템이 종료됩니다. Goodbye");
                break;
            }
        }
    }
}