package textbook.ch13.innerClass;

class Outer {
    int outNum = 100;
    static int sNum = 200;

    /**
     * 지역 내부 클래스는 외부 클래스의 메서드 안에서 선언되는 것이다.
     */
    Runnable getRunnable(int i) {
        int num = 100;          // 지역 변수

        class MyRunnable implements Runnable {      // 지역 내부 클래스
            int localNum = 10;                      // 지역 내부 클래스의 인스턴스 변수
            @Override
            public void run() {
                System.out.println("지역 변수(num)는 상수로 바뀌므로 값을 변경할 수 없어 오류 발생");
                // num = 200;
                System.out.println("매개변수(i)도 지역 변수처럼 상수로 바뀌므로 값을 변경할 수 없어 오류 발생");
                // i = 100;
                System.out.println("i(출력은 가능)= " + i);
                System.out.println("num(출력은 가능)= " + num);
                System.out.println("localNum = " + localNum);
                System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
                System.out.println("Outer.sNum = " + Outer.sNum + "(외부 클래스 정적 변수)");
            }
        }
        return new MyRunnable();
    }
}
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer out = new Outer();
        System.out.println("지역 내부 클래스를 사용하려면 이 클래스를 직접 생성하는 것이 아니라 외부 클래스의 메서드(getRunnable(int))를 거친다.");
        System.out.println("Runnable runner = out.getRunnable(10);");
        Runnable runner = out.getRunnable(10);
        System.out.println("runner.run();");
        runner.run();
    }
}
