package textbook.ch10.exercise.실습문제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventEx04 extends JFrame {
    private JLabel l = new JLabel("Love Java");

    public EventEx04() {
        setTitle("Left 키로 문자열 이동");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(l);
        l.addKeyListener(new MyKeyListener());

        setSize(300, 150);
        setVisible(true);

        l.setFocusable(true);
        l.requestFocus();
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                String str = l.getText();
                l.setText(str.substring(1) + str.substring(0,1));
            }
        }
    }

    public static void main(String[] args) {
        new EventEx04();
    }
}
