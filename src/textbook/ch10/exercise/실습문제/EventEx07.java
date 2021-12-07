package textbook.ch10.exercise.실습문제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class EventEx07 extends JFrame {
    private JLabel l = new JLabel("Love Java");

    public EventEx07() {
        setTitle("마우스 휠을 굴려 폰트 크기 조정하기");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(l);

        l.setFont(new Font("Arial", Font.PLAIN, 10));
        l.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getSource());
                int n = e.getWheelRotation();
                if (n < 0) {
                    Font f = l.getFont();
                    int size = f.getSize();
                    if (size > 5) {
                        l.setFont(new Font("Arial", Font.PLAIN, size - 5));
                    }
                } else {
                    Font f = l.getFont();
                    int size = f.getSize();
                    l.setFont(new Font("Arial", Font.PLAIN, size + 5));
                }
            }
        });

        setSize(300, 150);
        setVisible(true);

        l.setFocusable(true);
        l.requestFocus();
    }

    public static void main(String[] args) {
        new EventEx07();
    }
}
