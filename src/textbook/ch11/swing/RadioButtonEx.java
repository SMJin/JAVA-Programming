package textbook.ch11.swing;

import javax.swing.*;
import java.awt.*;

public class RadioButtonEx extends JFrame {
    public RadioButtonEx() {
        setTitle("라디오버튼 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        String pwd = "src/textbook/ch11/swing/img/";
        ImageIcon cherryIcon = new ImageIcon(pwd + "cherry.jpg");
        cherryIcon = setSize(cherryIcon, 50, 50);
        ImageIcon selectedCherryIcon = new ImageIcon(pwd + "cherry.jpg");
        selectedCherryIcon = setSize(selectedCherryIcon, 50, 50);

        ButtonGroup g = new ButtonGroup();

        JRadioButton apple = new JRadioButton("사과");
        JRadioButton pear = new JRadioButton("배", true);
        JRadioButton cherry = new JRadioButton("체리", cherryIcon);

        cherry.setBorderPainted(true);
        cherry.setSelectedIcon(selectedCherryIcon);

        g.add(apple);
        g.add(pear);
        g.add(cherry);

        c.add(apple);
        c.add(pear);
        c.add(cherry);

        setSize(250, 150);
        setVisible(true);
    }

    public ImageIcon setSize(ImageIcon img, int width, int height) {
        Image tmp1 = img.getImage();
        Image tmp2 = tmp1.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(tmp2);
    }

    public static void main(String[] args) {
        new RadioButtonEx();
    }
}
