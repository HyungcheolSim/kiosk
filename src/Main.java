public class Main {
    public static void main(String[] args){
        boolean isDataCreated=AddData.prestruct();
        if(!isDataCreated) {
            System.out.println("데이터가 정상적으로 생성되지 않았습니다.");
        }
        for(int i=0;i<20;i++){//그냥 20번 돌려~
            KioskApp.start();
        }

    }
}