package ProgrammingI.board.view;

import javax.swing.*;
import java.awt.*;

public class buttons {
    public static void main(String[] args) {

        JFrame myWindow = new JFrame();
        myWindow.setTitle("Prueba Botones");
        myWindow.setSize(500, 500);
        myWindow.setResizable(false);
        myWindow.setLayout(new BorderLayout());
        myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       JPanel panel = new JPanel();
       panel.setPreferredSize(new Dimension(200,200));
       panel.setBackground(new Color(74, 247, 200 ));
       myWindow.add(panel, BorderLayout.CENTER);
        myWindow.setVisible(true);
    }
}
