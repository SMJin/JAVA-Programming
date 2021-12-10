package textbook.ch11.swing;

import javax.swing.*;
import java.awt.*;

public class ButtonEx extends JFrame {
    public ButtonEx() {
        setTitle("이미지 버튼 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        String pwd = "src/textbook/ch11/swing/img/";
        ImageIcon normalIcon = new ImageIcon(pwd + "telephone.gif");
        ImageIcon rolloverIcon = new ImageIcon(pwd + "normalIcon.gif");
        ImageIcon pressedIcon = new ImageIcon(pwd + "beauty.jpg");

        JButton btn = new JButton("call~~", normalIcon);
        btn.setRolloverIcon(rolloverIcon);
        btn.setPressedIcon(pressedIcon);
        c.add(btn);

        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonEx();
    }
}
