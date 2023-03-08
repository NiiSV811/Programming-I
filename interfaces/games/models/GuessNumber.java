package ProgrammingI.interfaces.games.models;

import ProgrammingI.interfaces.games.models.interfaces.Game;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber implements Game{
    int theNumber;
    int attempts;
    Random randGen;
    Scanner input;

    public GuessNumber(){
        this.theNumber = 0;
        this.attempts = 0;
        randGen = new Random();
        input = new Scanner(System.in);
    }

    public int getTheNumber() {
        return theNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setTheNumber(int theNumber) {
        this.theNumber = theNumber;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    @Override
    public void start() {
        System.out.println("Adivina el numero de 1 hasta 20");
        System.out.println("Generando número mágico ...");
        this.setTheNumber(randGen.nextInt(20) + 1);
    }

    @Override
    public void play() {
        int tempAttempts = 0;
        int inputNumber = 0;
        String msg = "";
        do {
            System.out.println("Intenta adivinar el numero");
            msg = "";
            inputNumber = this.input.nextInt();
            if(inputNumber < this.getTheNumber()){
                msg = "Estas por debajo";
            }
            if (inputNumber > this.getTheNumber()){
                msg = "Estas por encima";
            }
            if(inputNumber > 20 || inputNumber < 0){
                msg = "El numero esta entre 1 y 20";
            }else {
                tempAttempts++;
            }
            System.out.println(msg);
        }while (inputNumber != this.getTheNumber());
        this.setAttempts(tempAttempts);
    }

    @Override
    public void finish() {
        System.out.println("Has Ganado en " + this.getAttempts() + " intentos" );
    }
}
