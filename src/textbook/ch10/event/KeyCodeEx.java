package textbook.ch10.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyCodeEx extends JFrame {
    private JLabel la = new JLabel();

    public KeyCodeEx() {
        setTitle("Key Code 예제 : F1키(초록), %키(노랑)");
        Container c = getContentPane();

        c.addKeyListener(new MyKeyListener());
        c.add(la);
        setSize(300, 150);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            Container contentPane = (Container) e.getSource();

            la.setText(KeyEvent.getKeyText(e.getKeyCode()) + "키가 입력되었음");

            // % 키는 유니코드 키이므로 getKeyChar() 메소드를 이용하여 리턴된 키의 문자 값과 '%' 문자를 비교한다.
            if (e.getKeyChar() == '%')
                contentPane.setBackground(Color.YELLOW);
            // <F1> 키는 유니코드 키가 아니므로 getKeyCode() 메소드를 이용하여 리턴된 키코드와 VK_F1 값을 비교한다.
            else if (e.getKeyCode() == KeyEvent.VK_F1)
                contentPane.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new KeyCodeEx();
    }
}
