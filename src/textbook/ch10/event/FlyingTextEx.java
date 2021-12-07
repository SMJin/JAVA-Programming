package textbook.ch10.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlyingTextEx extends JFrame {
    private final int FLYING_UNIT = 10;
    private JLabel la = new JLabel("HELLO");

    public FlyingTextEx() {
        setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        // "HELLO" 레이블이 컨텐트팬상의 임의의 위치로 마음대로 움직이기 위해서 컨텐트팬의 배치관리자를 삭제한다.
        c.setLayout(null);
        c.addKeyListener(new MyKeyListener());
        la.setLocation(50, 50);
        la.setSize(100, 20);
        c.add(la);

        setSize(300, 300);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();

        // 컨텐트팬에 포커스를 잃은 경우 마우스를 클릭하면 포커스를 다시 얻게 함
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component comp = (Component) e.getSource();
                comp.setFocusable(true);
                comp.requestFocus();
            }
        });
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_UP:
                    la.setLocation(la.getX(), la.getY()-FLYING_UNIT); break;
                case KeyEvent.VK_DOWN:
                    la.setLocation(la.getX(), la.getY()+FLYING_UNIT); break;
                case KeyEvent.VK_LEFT:
                    la.setLocation(la.getX()-FLYING_UNIT, la.getY()); break;
                case KeyEvent.VK_RIGHT:
                    la.setLocation(la.getX()+FLYING_UNIT, la.getY()); break;
            }
        }
    }

    public static void main(String[] args) {
        new FlyingTextEx();
    }
}
