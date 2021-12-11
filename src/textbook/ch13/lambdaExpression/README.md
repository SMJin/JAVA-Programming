# 람다식이란?
```java
/**
 * 원래의 함수
 */
int add(int x, int y) {
    return x + y;
}
/**
 * 람다식을 활용한 익명 함수
 */
(int x, int y) -> {return x + y;}
```
# 기본 문법
```java
// 매개 변수가 하나라면 괄호 생략 가능
str -> {System.out.println(str);}
// 구현 부분이 한 문장인 경우 중괄호 생략 가능
str -> System.out.println(str);
// 구현 부분이 return문 하나인 경우, 중괄호와 return 모두 생략 가능
(x, y) -> x + y
str -> str.length()
```
# 람다식 사용 방법
#### (1) 인터페이스를 만든다. (함수형 인터페이스)
```java
public interface MyNumber {
    int getMax(int num1, int num2);
}
```
#### (2) 인터페이스에 람다식으로 구현할 메서드를 선언한다.
```java
public class TestMyNumber {
    public static void main(String[] args) {
        // 람다식을 인터페이스형 max 변수에 대입
        MyNumber max = (x, y) -> (x >= y) ? x : y;
        // 인터페이스형 변수로 메서드 호출
        System.out.println(max.getMax(10, 20));
    }
}
```
# 함수형 인터페이스를 선언하는 이유
- 자바는 객체 지향 언이이다. 따라서 함수형 언어에서는 함수만 따로 호출할 수 있지만, 자바에서는 참조 변수 없이 메서드를 호출할 수 없기에 람다식을 구현하기 위해서는 함수형 인터페이스를 만들고, 인터페이스에 람다식으로 구현할 메서드를 선언하는 것이다.
- 따라서 람다식은 이름이 없는 익명 함수로 구현하기 때문에, 오직 하나의 메서드만 선언한 인터페이스를 구현할 수 있다.
- @FunctionalInterface 애노테이션 은 함수형 인터페이스라는 의미이고, 반드시 써야하는 것은 아니지만 함수형 인터페이스 식별에 도움을 준다.
# 람다식은 익명객체를 사용한다.
###### 따라서 외부 메서드의 지역 변수를 변경 할 수없다. (익명 내부 클래스와 비슷)