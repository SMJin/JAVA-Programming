package textbook.ch09.exercise.실전문제;

import javax.swing.*;
import java.awt.*;

public class MyFrame08 extends JFrame {
    public MyFrame08() {
        setTitle("여러 개의 패널을 가진 프레임");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel menus = new JPanel(new FlowLayout());
        menus.setBackground(Color.GRAY);
        menus.add(new JButton("열기"));
        menus.add(new JButton("닫기"));
        menus.add(new JButton("나가기"));
        c.add(menus, BorderLayout.NORTH);

        JPanel page = new JPanel(null);
        page.add(new JLabel("*"));
        for (int i=0; i<10; i++) {
            JLabel l = new JLabel("*");
            l.setOpaque(true);
            l.setForeground(Color.RED);
            int x = (int)(Math.random()*290 + 1);
            int y = (int)(Math.random()*180 + 20);
            l.setSize(10, 10);
            l.setLocation(x, y);
            page.add(l);
        }
        c.add(page, BorderLayout.CENTER);

        JPanel input = new JPanel(new FlowLayout());
        input.setBackground(Color.YELLOW);
        input.add(new JButton("Word Input"));
        input.add(new JTextField(15));
        c.add(input, BorderLayout.SOUTH);

        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame08();
    }
}
