package ProgrammingI.interfaces.games.models;

import ProgrammingI.interfaces.games.models.interfaces.Game;

import java.util.Random;
import java.util.Scanner;

public class DiceGame implements Game {
    int dice1;
    int dice2;
    Scanner input;
    Random randGen;
    String player1;
    String player2;

    public DiceGame(){
        input = new Scanner(System.in);
        randGen = new Random();
        dice1 = 0;
        dice2 = 0;
    }

    public void setDice1(int dice1) {
        this.dice1 = dice1;
    }

    public void setDice2(int dice2) {
        this.dice2 = dice2;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    @Override
    public void start() {
        System.out.println("Jugador 1 -> :");
        this.setPlayer1(input.nextLine());

        System.out.println("Jugador 2 ->");
        this.setPlayer2(input.nextLine());
    }

    @Override
    public void play() {
        this.setDice1(randGen.nextInt(28) + 1);
        this.setDice2(randGen.nextInt(28) + 1);

        System.out.println(this.getPlayer1() + " obtuvo  : " + this.getDice1());
        System.out.println(this.getPlayer2() + " obtuvo  : " + this.getDice2());
    }

    @Override
    public void finish() {
        String result = this.getDice1() > this.getDice2() ? this.getPlayer1() + " Ha ganado" :
                this.getDice1() == this.getDice2() ? "Empate entre " + this.getPlayer1() + "  y  " + this.getPlayer2() :  this.getPlayer2() + " Ha ganado";

        System.out.println(result);
    }
}
