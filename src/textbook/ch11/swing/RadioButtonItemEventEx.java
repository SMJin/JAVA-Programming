package textbook.ch11.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButtonItemEventEx extends JFrame {
    private JRadioButton[] radio = new JRadioButton[3];
    private String[] text = {"사과", "배", "체리"};
    private final String PWD = "src/textbook/ch11/swing/img/";
    private ImageIcon[] image = {
            setSize(new ImageIcon(PWD + "apple.jpg"), 100, 100),
            setSize(new ImageIcon(PWD + "pear.jpg"), 100, 100),
            setSize(new ImageIcon(PWD + "cherry.jpg"), 100, 100)};
    private JLabel imageLabel = new JLabel();

    public RadioButtonItemEventEx() {
        setTitle("라디오버튼 Item Event 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel radioPanel = new JPanel();
        radioPanel.setBackground(Color.GRAY);

        ButtonGroup g = new ButtonGroup();
        for (int i=0; i< radio.length; i++) {
            radio[i] = new JRadioButton(text[i]);
            g.add(radio[i]);
            radioPanel.add(radio[i]);
            radio[i].addItemListener(new MyItemListener());
        }

        radio[2].setSelected(true);
        c.add(radioPanel, BorderLayout.NORTH);
        c.add(imageLabel, BorderLayout.CENTER);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        setSize(250, 200);
        setVisible(true);
    }

    class MyItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.DESELECTED)
                return;
            if (radio[0].isSelected())
                imageLabel.setIcon(image[0]);
            else if (radio[1].isSelected())
                imageLabel.setIcon(image[1]);
            else
                imageLabel.setIcon(image[2]);
        }
    }

    public ImageIcon setSize(ImageIcon img, int width, int height) {
        Image tmp1 = img.getImage();
        Image tmp2 = tmp1.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(tmp2);
    }

    public static void main(String[] args) {
        new RadioButtonItemEventEx();
    }
}
