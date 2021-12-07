package textbook.ch09.exercise;

import javax.swing.*;
import java.awt.*;

public class MyFrame05 extends JFrame {
    public MyFrame05() {
        setTitle("4x4 Color Frame");
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,4));

        for (int i=0; i<16; i++) {
            JLabel l = new JLabel(Integer.toString(i));
            l.setOpaque(true);
            int r = (int)(Math.random()*256);
            int g = (int)(Math.random()*256);
            int b = (int)(Math.random()*256);
            l.setBackground(new Color(r, g, b));
            c.add(l);
        }

        setSize(400, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame05();
    }
}
