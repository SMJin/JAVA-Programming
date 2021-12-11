package textbook.ch13.innerClass;

/**
 * (원래대로라면) 인스턴스 내부 클래스는 외부 클래스가 선언이 된 이후에야 정적 변수나 메소드를 사용할 수 있다.
 * 그런 경우에, 내부 클래스가 외부 클래스 생성과 무관하게 사용할 수 있어야 한다면,
 * 그 때 사용했던 것이 바로 정적(static) 내부 클래스이다.
 */
class OutClass02 {
    private int num = 10;
    private static int sNum = 20;

    static class InStaticClass {    // 정적 내부 클래스
        int inNum = 100;            // 정적 내부 클래스의 인스턴스 변수
        static int sInNum = 200;    // 정적 내부 클래스의 정적 변수

        void inTest() {
            System.out.println("외부 클래스의 인스턴스 변수(num)은 사용할 수 없다.");
            // num += 10;
            System.out.println("InStaticClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수 사용)");
            System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
        }

        static void sTest() {
            System.out.println("외부 클래스와 내부 클래스의 인스턴스 변수(각각 num, inNum)는 사용할 수 없다.");
            // num += 10;
            // inNum += 10;
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
            System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
        }
    }
}

public class StaticInnerClass {
    public static void main(String[] args) {
        System.out.println("외부 클래스를 생성하지 않고 바로 정적 내부 클래스 생성가능");
        System.out.println("OutClass02.InStaticClass sInClass = new OutClass02.InStaticClass();");
        OutClass02.InStaticClass sInClass = new OutClass02.InStaticClass();

        System.out.println("\n정적 내부 클래스 일반 메서드 호출");
        System.out.println("sInClass.inTest();");
        sInClass.inTest();

        System.out.println("\n정적 내부 클래스의 정적 메서드 호출");
        System.out.println("OutClass02.InStaticClass.sTest();");
        OutClass02.InStaticClass.sTest();
    }
}
