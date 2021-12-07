package textbook.ch10.exercise.실습문제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventEx03 extends JFrame {
    private JLabel l = new JLabel("Love Java");

    public EventEx03() {
        setTitle("Left 키로 문자열 교체");
        Container c = getContentPane();
        c.addKeyListener(new MyKeyListener());
        c.setLayout(new FlowLayout());
        c.add(l);

        setSize(300, 150);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (l.getText() == "Love Java")
                    l.setText("avaJ evoL");
                else
                    l.setText("Love Java");
            }

        }
    }

    public static void main(String[] args) {
        new EventEx03();
    }
}
