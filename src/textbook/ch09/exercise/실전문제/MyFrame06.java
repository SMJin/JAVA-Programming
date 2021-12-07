package textbook.ch09.exercise.실전문제;

import javax.swing.*;
import java.awt.*;

public class MyFrame06 extends JFrame {
    public MyFrame06() {
        setTitle("Random Labels");
        Container c = getContentPane();
        c.setLayout(null);

        for (int i=0; i<20; i++) {
            JLabel l = new JLabel();
            l.setSize(10, 10);
            l.setBackground(Color.BLUE);
            int x = (int)(Math.random()*250+50);
            int y = (int)(Math.random()*250+50);
            l.setLocation(x, y);
            l.setOpaque(true);
            c.add(l);
        }

        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame06();
    }
}
