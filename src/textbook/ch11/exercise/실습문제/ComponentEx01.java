package textbook.ch11.exercise.실습문제;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComponentEx01 extends JFrame {
    private JButton textBtn;
    private JCheckBox nonActive, hide;

    public ComponentEx01() {
        setTitle("CheckBox Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        nonActive = new JCheckBox("버튼 비활성화");
        hide = new JCheckBox("버튼 감추기");
        textBtn = new JButton("text button");

        JPanel menus = new JPanel(new FlowLayout());
        nonActive.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    textBtn.setEnabled(false);
                else
                    textBtn.setEnabled(true);
            }
        });
        hide.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    textBtn.setVisible(false);
                else
                    textBtn.setVisible(true);
            }
        });
        menus.add(nonActive);
        menus.add(hide);
        c.add(menus, BorderLayout.NORTH);

        JPanel page = new JPanel(new FlowLayout());
        page.add(textBtn);
        c.add(page);

        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentEx01();
    }
}
