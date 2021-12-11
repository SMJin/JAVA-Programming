# 스트림이란?
```java
/**
 * 기존의 배열 출력하는 코드
 */
int[] arr = {1, 2, 3, 4, 5};
for(int i=0; i<arr.length; i++) {
    System.out.println(arr[i]);
}
/**
 * 스트림을 사용하여 배열을 출력하는 코드
 */
int[] arr = {1, 2, 3, 4, 5};
Arrays.stream(arr).forEach(n -> System.out.println(n));
```
# 스트림 연산의 종류
- 스트림 생성 - (리스트).stream()
- 중간 연산 - filter(), map() 등
- 최종 연산 - forEach(), count(), sum(), reduce() 등
```java
sList.stream().filter(s -> s.length() >= 5).forEach(s -> System.out.println(s));
customerList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));
```

# 정수 배열에 스트림 사용 예제 ([IntArrayTest.java](./IntArrayTest.java))
#### Console
```shell
15
5

Process finished with exit code 0
```

# Collection에 스트림 사용 예제 ([ArrayListStreamTest.java](./ArrayListStreamTest.java))
```shell
Tomas Edward Jack 
Edward Jack Tomas 

Process finished with exit code 0
```

# 스트림 특징
- 컬렉션의 여러 자료 구조에 대해 일관성있게 동일한 연산을 수행한다.
- 한 번 생성하고 사용한 스트림은 재사용할 수 없다. (다른 기능 호출하려면 또 새로 스트림을 생성해야 함)
- 스트림 연산은 기존 자료를 변경하지 않는다.
- 스트림 연산은 중간 연산과 최종 연산이 있다.

# 사용자 정의 기능인 reduce() 연산
```java
// reduce 연산의 정의
T reduce(T identity, BinaryOperator<T> accumulator)
```
- T identity : 초깃값 의미
- BinaryOperator 인터페이스 : 두 매개변수로 람다식을 구현하며, 이 람다식이 각 요소가 수행해야 할 기능이 된다.
- 또, BinaryOperator는 함수형 인터페이스이므로 apply() 메서드를 반드시 구현해야 한다. 이 메서드는 두 개의 매개변수와 한 개의 반환 값을 가지는 데, 세 개 모두 같은 자료형이다.
```java
// 예시
Arrays.stream(arr).reduce(0, (a,b) -> a + b);
```