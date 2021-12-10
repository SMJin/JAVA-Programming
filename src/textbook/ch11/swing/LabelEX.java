package textbook.ch11.swing;

import javax.swing.*;
import java.awt.*;

public class LabelEX extends JFrame {
    public LabelEX() {
        setTitle("레이블 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel textLabel = new JLabel("사랑합니다");
        String pwd = "src/textbook/ch11/swing/img/";

        ImageIcon beauty = new ImageIcon(pwd + "beauty.jpg");
        beauty = setSize(beauty, 250, 250);
        JLabel imageLabel = new JLabel(beauty);

        ImageIcon normalIcon = new ImageIcon(pwd + "normalIcon.gif");
        JLabel normalLabel = new JLabel(normalIcon);

        ImageIcon telephone = new ImageIcon(pwd + "telephone.gif");
        JLabel telephoneLabel = new JLabel("보고싶으면 전화하세요", telephone, SwingConstants.CENTER);

        c.add(textLabel);
        c.add(imageLabel);
        c.add(normalLabel);
        c.add(telephoneLabel);

        setSize(300, 720);
        setVisible(true);
    }

    public ImageIcon setSize(ImageIcon img, int width, int height) {
        Image tmp1 = img.getImage();
        Image tmp2 = tmp1.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(tmp2);
    }

    public static void main(String[] args) {
        new LabelEX();
    }
}
