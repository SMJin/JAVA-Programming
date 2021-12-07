package textbook.ch10.exercise.실습문제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventEx02 extends JFrame {
    public EventEx02() {
        setTitle("드래깅동안 YELLOW, 원래 배경은 GREEN");
        Container c = getContentPane();
        c.setBackground(Color.GREEN);
        c.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Component cmp = (Component) e.getSource();
                cmp.setBackground(Color.YELLOW);
            }
        });
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Component cmp = (Component) e.getSource();
                cmp.setBackground(Color.GREEN);
            }
        });

        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EventEx02();
    }
}
