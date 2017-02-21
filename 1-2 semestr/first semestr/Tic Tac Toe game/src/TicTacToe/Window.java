package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Window extends JFrame {// implements ActionListener {
    JButton buttons[] = new JButton[9];

       public Window() {
            super("Tic Tac Toe game");//��������� ����
            this.setSize(400, 400);//������ ����
            this.setLocationRelativeTo(null);//������������ ����
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);//�������� ��� ������� �� �������
            this.setResizable(false);//��������� �������� ������ ����

            JPanel myPanel = new JPanel();
            BorderLayout BLayout = new BorderLayout();
            myPanel.setLayout(BLayout);
            JPanel CentralPanel = new JPanel();
            CentralPanel.setSize(200, 200);
            GridLayout GLayout = new GridLayout(3, 3);
            CentralPanel.setLayout(GLayout);


            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = new JButton();
                buttons[i].addActionListener(new ButtonEventListener());
                CentralPanel.add(buttons[i]);
            }
            myPanel.add("Center", CentralPanel);
            setContentPane(myPanel);
        }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            buttons[new Random().nextInt(9)].setBackground(Color.cyan);
        }
    }
}

