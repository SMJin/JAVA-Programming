# Chapter 11 Exercise 이론문제
### 기본적인 스윙 컴포넌트와 활용

# 01
##### 컴포넌트는 자신의 배경색과 모양, 활성 혹은 비활성 등의 상태, 위치 및 크기, 컨테이너를 위한 메소드(부모/자식 컴포넌트 등)등이 제공된다.

# 02
##### JLabel은 이미지나 텍스트를 출력한다.

# 03
```java
ImageIcon icon = new ImageIcon("java.jpg");
JLabel label = new JLabel();
label.add(icon);
```

# 04
```java
c.setVisible(false);
c.setFont(new Font("고딕", Font.PLAIN, 20));
c.addComponentListener(null);
```

# 05
##### 슬라이드바를 클릭한 경우에는 Item 이벤트가 발생하지 않는다. Item 이벤트는 체크박스나 라디오버튼의 선택 상태가 바뀔 때 발생하는 이벤트이기 때문이다.

# 07
```java
b.setIcon(new ImageIcon("plain.jpg"));
b.setRolloverIcon("over.jpg");
``` 

# 08
```java
class MyItemListener implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED)
            System.out.println("선택되었습니다");
        else
            System.out.println("해제되었습니다");
    }
}
```

# 10
##### 버튼들을 ButtonGroup 으로 묶으면 해당 그룹의 버튼 중 하나만 선택된다.