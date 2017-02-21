package TicTacToe;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Window extends JFrame {
    Window() {
        super("Tic-Tac Toe game");//��������� ����; ����������� ����������� � ����������� JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);//�������� ��� ������� �� �������
        setSize(400, 400); //������ ����
        setResizable(false); //��������� �������� ������ ����
        JPanel myPanel = new JPanel();//��������� ������
        setLocation(400, 150);//����������������� ���� �� ������

        //FlowLayout myLayout = new FlowLayout(); //�������� ������������������ ����������
        myPanel.setLayout(null);//��������� ������������� ������������ ������

        JButton OnePlayer = new JButton("One player");//�������� ������
        myPanel.add(OnePlayer);//���������� ������ �� ������
        OnePlayer.setSize(200, 30);//������ ������
        OnePlayer.setLocation(100, 100);//������������ ������
        JButton TwoPlayers = new JButton("Two players");//�������� ������
        myPanel.add(TwoPlayers);//���������� ������
        TwoPlayers.setSize(200, 30);//������ ������
        TwoPlayers.setLocation(100, 150);//������������ ������
        setContentPane(myPanel);
    }

}