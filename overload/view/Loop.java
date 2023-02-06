package ProgrammingI.overload.view;

import ProgrammingI.overload.controller.CycleController;
import ProgrammingI.overload.controller.LoopController;
import ProgrammingI.overload.model.Recursion;

import javax.swing.*;

public class Loop {
    public static void main(String[] args) {
        LoopController forController = new LoopController();
        CycleController whilesController = new CycleController();
        Recursion myRecursion = new Recursion();


        int limit = 10;
        String msg = " Los números de 0 a 4 son: ";
        String msgLimit = "Los números de 0 a " + limit + " son:";

        JOptionPane.showMessageDialog(null, msg + myRecursion.recursionStringNumbers(4), "Recursion", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, msgLimit + myRecursion.recursionStringNumbers(0, limit), "Recursion (limit)", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,   msg + forController.forStringNums()," For " , JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,  msgLimit + forController.forStringNums(limit)," For ( limit ) " , JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null, msg + whilesController.whileStringNums()," While " , JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, msgLimit + whilesController.whileStringNums(limit), " While ( limit ) " , JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null, msg + whilesController.doWhileStringNums(), "Do While" , JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, msgLimit + whilesController.doWhileStringNums(limit), "Do While ( limit )" , JOptionPane.PLAIN_MESSAGE);


    }
}
