package textbook.ch09.exercise.실습문제;

import javax.swing.*;
import java.awt.*;

public class MyFrame03 extends JFrame {
    public MyFrame03() {
        setTitle("Ten Color Buttons Frame");
        Container c = getContentPane();
        c.setLayout(new GridLayout(1, 10));

        for(int i=0; i<10; i++) {
            c.add(new JButton(Integer.toString(i)));
        }

        setSize(500, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame03();
    }
}
