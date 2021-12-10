package textbook.ch11.swing;

import javax.swing.*;
import java.awt.*;

public class CheckBoxEX extends JFrame {
    public CheckBoxEX() {
        setTitle("체크박스 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        String pwd = "src/textbook/ch11/swing/img/";
        ImageIcon cherryIcon = new ImageIcon(pwd + "cherry.jpg");
        cherryIcon = setSize(cherryIcon, 50, 50);
        ImageIcon selectedCherryIcon = new ImageIcon(pwd + "cherry.jpg");
        selectedCherryIcon = setSize(selectedCherryIcon, 50, 50);

        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배", true);
        JCheckBox cherry = new JCheckBox("체리", cherryIcon);

        cherry.setBorderPainted(true);
        cherry.setSelectedIcon(selectedCherryIcon);

        c.add(apple);
        c.add(pear);
        c.add(cherry);

        setSize(250,150);
        setVisible(true);
    }

    public ImageIcon setSize(ImageIcon img, int width, int height) {
        Image tmp1 = img.getImage();
        Image tmp2 = tmp1.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(tmp2);
    }

    public static void main(String[] args) {
        new CheckBoxEX();
    }
}
