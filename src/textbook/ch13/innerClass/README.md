##### 먼저, 내부 클래스는 4가지로 나뉜다. 
- (1) 인스턴스 내부 클래스 
- (2) 정적(static) 내부 클래스 
- (3) 지역(local) 내부 클래스 
- (4) 익명(anonymous) 내부 클래스

# 변수 vs 내부 클래스 비교
### 변수의 경우
```java
class ABC {
    int n1;                 // 인스턴스 변수
    static int n2;          // 정적 변수
    
    public void abc() {
        int i;              // 지역 변수
    }
}
```
### 내부 클래스의 경우
```java
class ABC {                 // 외부 클래스
    class In {              // 인스턴스 내부 클래스
        static class Sin {  // 정적 내부 클래스
        }
    }
    public void abc() {
        class Local {       // 지역 내부 클래스
        }
    }
}
```

# 인스턴스 내부 클래스
### Java Code
```java
package textbook.ch13.innerClass;

class OutClass {        // 외부 클래스
    private int num = 10;           // 외부 클래스 private 변수
    private static int sNum = 20;   // 외부 클래스 정적 변수

    private InClass inClass;

    /**
    * 외부 클래스의 디폴트 생성자.
    * 외부 클래스가 생성된 이후에 내부 클래스 생성이 가능하다.
    * */
    public OutClass() {
        inClass = new InClass();
    }

    /**
     * 원래는,
     * 인스턴스 내부 클래스는 외부 클래스를 생성한 이후에 사용해야 하기 때문에
     * 클래스의 생성과 상관없이 사용할 수 있는 정적 변수는 인스턴스 내부 클래스에서 선언할 수 없었다.
     * 마찬가지 이유로 정적 메소드도 인스턴스 내부 클래스에서 선언할 수 없었다.
     *
     * 그러나,
     * 자바 버전이 업그레이드 되면서 내부 클래스에서도 정적 변수나 메소드를 선언할 수 있게 된 것같다.
     * 왜냐면 교재에서는 실행이 되지 않을 것이라고 나와있는데, 오류가 뜨지 않는다....
     */
    class InClass {         // 인스턴스 내부 클래스
        int inNum = 100;            // 내부 클래스의 인스턴스 변수
        static int sInNum = 200;    // 내부 클래스의 정적 변수

        void inTest() {
            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수)");

            System.out.println("내부 클래스의 인스턴스 변수 = " + inNum);
            System.out.println("내부 클래스의 정적 변수(원래는 오류가 떠야함) = " + sInNum);
            sTest();
        }

        static void sTest() {
            System.out.println("내부 클래스의 정적 메소드 sTest()가 호출되었습니다.(원래는 오류가 떠야함)");
        }
    }

    public void usingClass() {
        inClass.inTest();
    }
}

public class InnerTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        System.out.println("외부 클래스 이용하여 내부 클래스 기능 호출");
        outClass.usingClass();
    }
}
```
### Console
```shell
외부 클래스 이용하여 내부 클래스 기능 호출
OutClass num = 10(외부 클래스의 인스턴스 변수)
OutClass sNum = 20(외부 클래스의 정적 변수)
내부 클래스의 인스턴스 변수 = 100
내부 클래스의 정적 변수(원래는 오류가 떠야함) = 200
내부 클래스의 정적 메소드 sTest()가 호출되었습니다.(원래는 오류가 떠야함)

Process finished with exit code 0
```
###### 내부 클래스를 private로 선언하지 않았다면 외부 클래스가 아닌 다른 클래스에서도 다음처럼 내부 클래스를 생성할 수 있다. 그러나 내부 클래스를 생성하는 이유 자체가 그 클래스를 감싸고 있는 외부 클래스에서만 사용하기 위해서이기 때문에, 내부 클래스를 그 밖에 다른 클래스에서 생성해서 사용하는 것은 사실 맞지 않다.
```java
// 먼저 외부 클래스 먼저 선언 후,
OutClass outClass = new OutClass();
// 내부 클래스를 접근해준다. (이때 내부클래스는 private가 아님)
OutClass.InClass inClass = outClass.new InClass();
```