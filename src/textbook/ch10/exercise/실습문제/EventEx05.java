package textbook.ch10.exercise.실습문제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventEx05 extends JFrame {
    private JLabel l = new JLabel("Love Java");

    public EventEx05() {
        setTitle("+,- 키로 폰트 크기 조절");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(l);

        l.setFont(new Font("Arial", Font.PLAIN, 10));
        l.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '+') {
                    Font f = l.getFont();
                    int size = f.getSize();
                    l.setFont(new Font("Arial", Font.PLAIN, size + 5));
                } else if (e.getKeyCode() == KeyEvent.VK_MINUS) {
                    Font f = l.getFont();
                    int size = f.getSize();
                    if (size > 5) {
                        l.setFont(new Font("Arial", Font.PLAIN, size - 5));
                    }
                }
            }
        });

        setSize(300, 150);
        setVisible(true);

        l.setFocusable(true);
        l.requestFocus();
    }

    public static void main(String[] args) {
        new EventEx05();
    }
}
