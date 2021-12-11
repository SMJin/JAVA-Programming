##### 먼저, 내부 클래스는 4가지로 나뉜다. 
- (1) 인스턴스 내부 클래스 
- (2) 정적(static) 내부 클래스 
- (3) 지역(local) 내부 클래스 
- (4) 익명(anonymous) 내부 클래스

# 변수 vs 내부 클래스 비교
#### 변수의 경우
```java
class ABC {
    int n1;                 // 인스턴스 변수
    static int n2;          // 정적 변수
    
    public void abc() {
        int i;              // 지역 변수
    }
}
```
#### 내부 클래스의 경우
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

# 인스턴스 내부 클래스 ([InstanceInnerClass.java](./InstanceInnerClass.java))
#### Console
```shell
외부 클래스 이용하여 내부 클래스 기능 호출
OutClass num = 10(외부 클래스의 인스턴스 변수)
OutClass sNum = 20(외부 클래스의 정적 변수)
내부 클래스의 인스턴스 변수 = 100
내부 클래스의 정적 변수(원래는 오류가 떠야함) = 200
내부 클래스의 정적 메소드 sTest()가 호출되었습니다.(원래는 오류가 떠야함)

Process finished with exit code 0
```
#### 다른 클래스에서 인스턴스 내부 클래스 생성하기
###### 그러나 내부 클래스를 생성하는 이유 자체가 그 클래스를 감싸고 있는 외부 클래스에서만 사용하기 위해서이기 때문에, 내부 클래스를 그 밖에 다른 클래스에서 생성해서 사용하는 것은 사실 맞지 않다.
```java
// 먼저 외부 클래스 먼저 선언 후,
OutClass outClass = new OutClass();
// 내부 클래스를 접근해준다. (이때 내부클래스는 private가 아님)
OutClass.InClass inClass = outClass.new InClass();
```

# 정적 내부 클래스 ([StaticInnerClass.java](./StaticInnerClass.java))
#### Console
```shell
외부 클래스를 생성하지 않고 바로 정적 내부 클래스 생성가능
OutClass02.InStaticClass sInClass = new OutClass02.InStaticClass();

정적 내부 클래스 일반 메서드 호출
sInClass.inTest();
외부 클래스의 인스턴스 변수(num)은 사용할 수 없다.
InStaticClass inNum = 100(내부 클래스의 인스턴스 변수 사용)
InStaticClass sInNum = 200(내부 클래스의 정적 변수 사용)
OutClass sNum = 20(외부 클래스의 정적 변수 사용)

정적 내부 클래스의 정적 메서드 호출
OutClass02.InStaticClass.sTest();
외부 클래스와 내부 클래스의 인스턴스 변수(각각 num, inNum)는 사용할 수 없다.
OutClass sNum = 20(외부 클래스의 정적 변수 사용)
InStaticClass sInNum = 200(내부 클래스의 정적 변수 사용)

Process finished with exit code 0
```
#### 표로 정리
| static inner class 메서드 |                 변수 유형                  |        사용 가능 여부         |
| :-------: | :-----------------------------------------------------: | :----------------------: |
| 일반 메서드 void inTest() |  외부 클래스의 인스턴스 변수(num)              | X |
|           |   외부 클래스의 정적 변수(sNum)                             | O |
|           |   정적 내부 클래스의 인스턴스 변수(inNum)                     | O  |
|           |     정적 내부 클래스의 정적 변수(sInNum)                     | O |
| 정적 메서드 static void sTest() |  외부 클래스의 인스턴스 변수(num)        | X |
|           |   외부 클래스의 정적 변수(sNum)                             | O |
|           |   정적 내부 클래스의 인스턴스 변수(inNum)                   | X |
|           |     정적 내부 클래스의 정적 변수(sInNum)                      | O |
#### 다른 클래스에서 정적 내부 클래스 사용하기
```java
// 외부 클래스 미리 생성하지 않고도 내부 클래스 자료형으로 바로 선언이 가능하다.
OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
// 다만, 정적 내부 클래스를 private로 선언했다면 사용할 수 없다.
OutClass.InStaticClass.sTest();
```
# 지역 내부 클래스 ([LocalInnerClass.java](./LocalInnerClass.java))
#### Console
```shell
지역 내부 클래스를 사용하려면 이 클래스를 직접 생성하는 것이 아니라 외부 클래스의 메서드(getRunnable(int))를 거친다.
Runnable runner = out.getRunnable(10);
runner.run();
지역 변수(num)는 상수로 바뀌므로 값을 변경할 수 없어 오류 발생
매개변수(i)도 지역 변수처럼 상수로 바뀌므로 값을 변경할 수 없어 오류 발생
i(출력은 가능)= 10
num(출력은 가능)= 100
localNum = 10
outNum = 100(외부 클래스 인스턴스 변수)
Outer.sNum = 200(외부 클래스 정적 변수)

Process finished with exit code 0
```
#### ☆★ 지역 내부 클래스에서 사용하는 메서드의 지역 변수는 모두 상수로 바뀐다. ☆★

# 익명 내부 클래스 ([AnonymousInnerClass.java](./AnonymousInnerClass.java))
#### Console
```shell
100
10
Runnable 이 구현된 익명 클래스 변수

Process finished with exit code 0
```