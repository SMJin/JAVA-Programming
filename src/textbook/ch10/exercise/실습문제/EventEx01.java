package textbook.ch10.exercise.실습문제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventEx01 extends JFrame {
    private JLabel l = new JLabel();

    public EventEx01() {
        setTitle("마우스 올리기 내리기 실습");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                l.setText("Love Java");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                l.setText("사랑해");
            }
        });

        c.add(l);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EventEx01();
    }
}
