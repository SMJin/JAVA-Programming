package textbook.ch10.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousClassListener extends JFrame {
    public AnonymousClassListener() {
        setTitle("Action 이벤트 리스너 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        c.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                if (b.getText().equals("Action"))
                    b.setText("액션");
                else
                    b.setText("Action");

                // AnonymousClassListener의 멤버나 JFrame의 멤버를 호출할 수 있음
                setTitle(b.getText());
                // 위 코드는 다음과 같이 코드를 작성해도 같은 코드이다.
                // AnonymousClassListener.this.setTitle(b.getText());
            }
        });

        setSize(350, 150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AnonymousClassListener();
    }
}
