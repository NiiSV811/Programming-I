package ProgrammingI.stringutilities.view;

import ProgrammingI.stringutilities.controller.StringController;
import ProgrammingI.stringutilities.model.StringUtil;

import javax.swing.*;

public class View {
    public static void main(String[] args) {
        StringController mySC = new StringController();
        String input = "";

        input  = JOptionPane.showInputDialog(null, "Ingrese palabra para comprobar si es impar y reversarla");
        JOptionPane.showMessageDialog(null, mySC.checkOddWords(input));

        input = JOptionPane.showInputDialog(null, "Ingrese palabra para comprobar si es capicua");
        JOptionPane.showMessageDialog(null, mySC.isPalindrome(input));

        input = JOptionPane.showInputDialog(null, "Ingrese palabras separadas por comas para verificar si riman");
        JOptionPane.showMessageDialog(null, mySC.rhyme(input));

    }
}
