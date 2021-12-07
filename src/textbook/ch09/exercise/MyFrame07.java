package textbook.ch09.exercise;

import javax.swing.*;
import java.awt.*;

public class MyFrame07 extends JFrame {
    public MyFrame07() {
        setTitle("계산기 프레임");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel input = new JPanel(new FlowLayout());
        input.setBackground(Color.GRAY);
        input.add(new JLabel("수식입력"));
        JTextField text = new JTextField(15);
        input.add(text);
        c.add(input, BorderLayout.NORTH);

        JPanel btns = new JPanel(new GridLayout(4, 4, 2, 2));
        for(int i=0; i<10; i++) {
            btns.add(new JButton(Integer.toString(i)));
        }
        btns.add(new JButton("CE"));
        btns.add(new JButton("계산"));

        JButton plus = new JButton("+");
        plus.setBackground(Color.CYAN);
        btns.add(plus);

        JButton minus = new JButton("-");
        minus.setBackground(Color.CYAN);
        btns.add(minus);

        JButton multiple = new JButton("*");
        multiple.setBackground(Color.CYAN);
        btns.add(multiple);

        JButton divide = new JButton("/");
        divide.setBackground(Color.CYAN);
        btns.add(divide);

        c.add(btns, BorderLayout.CENTER);

        JPanel output = new JPanel(new FlowLayout());
        output.setBackground(Color.YELLOW);
        output.add(new JLabel("계산 결과"));
        output.add(new JTextField(15));
        c.add(output, BorderLayout.SOUTH);

        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame07();
    }
}
