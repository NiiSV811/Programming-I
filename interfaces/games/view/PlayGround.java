package ProgrammingI.interfaces.games.view;

import ProgrammingI.interfaces.games.models.DiceGame;
import ProgrammingI.interfaces.games.models.GuessNumber;
import ProgrammingI.interfaces.games.models.interfaces.Game;

import java.util.Scanner;

public class PlayGround {
    public static void main(String[] args) {
        Game myGame = null;
        Scanner input = new Scanner(System.in);
        int option;
        boolean exit = false;

        System.out.println("Ingrese juego a jugar:  \n1. Dados\n2. Adivina el numero\n3. Salir");
        option = input.nextInt();

        switch (option){
            case 1 ->{ myGame = new DiceGame();}
            case 2 ->{ myGame = new GuessNumber();}
            default -> { exit = true;}
        }
        if (!exit){
        myGame.start();
        myGame.play();
        myGame.finish();
        }
        System.out.println("Gracias por jugar");
    }
}
