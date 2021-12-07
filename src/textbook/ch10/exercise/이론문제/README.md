# Chapter 10 Exercise 이론문제
### 자바의 이벤트 처리

# 01
##### AWT 나 스윙 응용프로그램은 GUI 기반 응용프로그램이다.

# 02
##### MouseEvent 객체는 이벤트 소스, 마우스가 클릭된 화면의 좌표, 클릭된 마우스 버튼의 번호 등을 제공하지만, 마우스의 드래깅 길이 정보는 제공하지 않는다.

# 03
```java
JButton btn = new JButton("Hello");
btn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click");
    }
});}
```

# 04
```java
JButton btn = new JButton("Hello");
btn.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }
});
```

# 05
### (1) ActionListener 는 어댑터형이 없다. (메소드가 어짜피 하나기 때문)
```java
class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click");
    }
}
```
### (2) 어댑터형으로 선언해야 특정 메소드만 선택할 수 있다. 그냥 리스너로 상속하면 모든 메소드를 다 불러와야함.
```java
class MyMouseListener extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
    }    
}
```

### (3) Key 이벤트에 대해서는 KeyEvent 로 받아와야 한다.
```java
class MyKeyListener extends KeyAdapter {
    public void KeyTyped(KeyEvent e) {
        System.out.println("Key Pressed");
    }
}
```

# 06
###### 다음 Action 이벤트 리스너 코드가 있다.
```java
class MyActionListener implements ActionListener {
    private String msg;
    public MyActionListener(String msg) {
        this.msg = msg;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(msg);
    }
}
```
###### "Hello" 버튼에 다음과 같이 리스너를 등록하고, 버튼을 클릭하면 실행 결과는 무엇인가?
```java
JButton btn = new JButton("Hello");
btn.addActionListener(new MyActionListener("1"));
btn.addActionListener(new MyActionListener("2"));
btn.addActionListener(new MyActionListener("3"));
```
##### 1 2 3 이 순서대로 출력된다.

# 07
##### ItemListener 에는 어댑터 클래스가 없다.

# 08
##### component 에 포커스를 강제하는 코드는 component.requestFocus(); 이다.

# 09
##### 유니코드인 키에는 a, 9, %, @, ;, ~ 등이 있다. 
##### 그 외에 유니코드가 아닌 키로는 \<Alt>, \<Tab>, \<Delete>, \<Shift>, \<Help> 등이 있다.

# 10
###### a 키가 눌러졌는지 판별하는 코드
```java
public void keyPressed(KeyEvent e) {
    if (e.getKeyChar() == 'a') {
        System.exit(0);
    }
}
```
###### \<ALT> 키가 눌러졌는지 판별하는 코드
```java
public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == VK_ALT) {
        System.exit(0);
    }
}
```

# 11
##### 키 a를 입력하면 keyPressed() -> keyTyped() -> keyReleased() 순으로 키 이벤트가 발생한다.
##### 키 \<Esc>를 입력하면 keyPressed() -> keyReleased() 순으로만 키 이벤트가 발생한다.

# 12
##### (1) 1 (2) 11 (3) 결과는 같다

# 13
##### component.repaint(); 는 프로그램에서 컴포넌트의 모양, 텍스트, 크기, 색 등을 변경하는 경우, 변경한 사항들이 스크린에 바로 나타나지 않을 때 사용하는 메소드이다.
##### component.revalidate(); 는 컨테이너의 배치 관리자에게 자식 컴포넌트의 배치를 다시 하도록 지시하는 메소드이다.