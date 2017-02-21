package TicTacToe;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Window extends JFrame {
    Window() {
        super("Tic-Tac Toe game");//заголовок окна; конструктор унаследован у суперкласса JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);//действие при нажании на крестик
        setSize(400, 400); //размер окна
        setResizable(false); //запрещает изменять размер окна
        JPanel myPanel = new JPanel();//создается панель
        setLocation(400, 150);//месторасположение окна на экране

        //FlowLayout myLayout = new FlowLayout(); //менеджер последовательности размещений
        myPanel.setLayout(null);//установка произвольного расположения кнопок

        JButton OnePlayer = new JButton("One player");//создание кнопки
        myPanel.add(OnePlayer);//добавление кнопки на панель
        OnePlayer.setSize(200, 30);//размер кнопки
        OnePlayer.setLocation(100, 100);//расположение кнопки
        JButton TwoPlayers = new JButton("Two players");//создание кнопки
        myPanel.add(TwoPlayers);//добавление кнопки
        TwoPlayers.setSize(200, 30);//размер кнопки
        TwoPlayers.setLocation(100, 150);//расположение кнопки
        setContentPane(myPanel);
    }

}