package textbook.ch09.exercise.실전문제;

import javax.swing.*;
import java.awt.*;

public class MyFrame02 extends JFrame {
    public MyFrame02() {
        setTitle("BorderLayout Practice");
        Container c = getContentPane();
        c.setLayout(new BorderLayout(5, 7));

        JButton north = new JButton("North");
        c.add(north, BorderLayout.NORTH);
        JButton west = new JButton("West");
        c.add(west, BorderLayout.WEST);
        JButton center = new JButton("Center");
        c.add(center, BorderLayout.CENTER);
        JButton east = new JButton("East");
        c.add(east, BorderLayout.EAST);
        JButton south = new JButton("South");
        c.add(south, BorderLayout.SOUTH);

        setSize(400, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame02();
    }
}
