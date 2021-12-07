package textbook.ch10.exercise.실습문제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventEx06 extends JFrame {
    private JLabel l = new JLabel("c");

    public EventEx06() {
        setTitle("클릭 연습 용 응용프로그램");
        Container c = getContentPane();
        c.setLayout(null);
        l.setSize(10, 10);
        l.setLocation(100, 100);
        l.setOpaque(true);
        c.add(l);

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                l.setLocation(x, y);
            }
        });

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EventEx06();
    }
}
