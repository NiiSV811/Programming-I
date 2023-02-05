package ProgrammingI.board.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View {
    public static void main(String[] args) {
        JFrame myWindow = new JFrame();
        myWindow.setTitle("Ajedrez (Copia Barata)");
        myWindow.setSize(615, 700);

        myWindow.setResizable(false);
        myWindow.setLayout(null);
        myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Border line = BorderFactory.createLineBorder(new Color(2, 144, 215 ),3);
        JPanel board = new JPanel();
        board.setLayout(new BorderLayout());
        board.setBounds(0,0,600,600);
        board.setBackground(new Color(113, 208, 249 ));
        board.setBorder(BorderFactory.createEmptyBorder());
        board.setOpaque(true);

       for(int i = 0; i < 4; i++){
           JPanel blankRow = new JPanel();
           blankRow.setBackground(new Color(49, 52, 51 ));
           blankRow.setOpaque(true);

           if(i < 2){
               blankRow.setPreferredSize(new Dimension(600,30));
           }else {
               blankRow.setPreferredSize(new Dimension(30,600));
           }

           switch (i){
               case 0 ->{board.add(blankRow, BorderLayout.NORTH);}
               case 1 ->{board.add(blankRow, BorderLayout.SOUTH);}
               case 2 ->{board.add(blankRow, BorderLayout.EAST);}
               case 3 ->{board.add(blankRow, BorderLayout.WEST);}
           }
       }

       JPanel squaresContainer = new JPanel();
       squaresContainer.setLayout(new GridLayout(8,8));
       squaresContainer.setPreferredSize(new Dimension(100,100));
       squaresContainer.setBackground(new Color(25, 43, 70 ));
       squaresContainer.setBorder(line);
       Color black = new Color(181, 141, 102 );
       Color white = new Color(243, 220, 180 );
       Color paint;
       for(int y = 0; y < 8; y++){
           for(int x = 0; x < 8; x++){
               JButton square = new JButton();
               if((y % 2 != 0 && x % 2 == 0 ) || (y % 2 == 0 && x % 2 != 0)){
                   paint = black;
               }else {
                   paint = white;
               }
               square.setBackground(paint);
               square.setBorder(BorderFactory.createEmptyBorder());
               squaresContainer.add(square);
           }
       }

       board.add(squaresContainer, BorderLayout.CENTER);


        JPanel bottom = new JPanel();
        bottom.setBounds(0,600,600,120);
        bottom.setBackground(new Color( 41, 47, 53 ));
        bottom.setBorder(BorderFactory.createEmptyBorder());
        bottom.setOpaque(true);


        myWindow.add(board);
        myWindow.add(bottom);
        myWindow.setVisible(true);
    }
}
