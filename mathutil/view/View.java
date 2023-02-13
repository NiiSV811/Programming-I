package ProgrammingI.mathutil.view;

import ProgrammingI.mathutil.controller.NumArrayController;

import javax.swing.*;

public class View {
    public static void main(String[] args) {
        NumArrayController myController = new NumArrayController();
        String arrayIsFull = "El arreglo ya está lleno de números.";
        String status = "";
        String msg = "";
        String input1 = "";
        String input2 = "";

        while (!status.equals(arrayIsFull)){

           input1 = JOptionPane.showInputDialog(null, "Ingrese 2 valores a comparar: \n" + "Ingrese el primer valor: ");
           input2 = JOptionPane.showInputDialog(null, "Ingrese el valor 2 (escriba [ x ] para terminar) ");
            if(input2.equals("x")){
                break;
            }
           JOptionPane.showMessageDialog(null, myController.biggerThan(input1, input2));
           status = myController.AddNumArray(input1);
           JOptionPane.showMessageDialog(null, status);
           status = myController.AddNumArray(input2);
           JOptionPane.showMessageDialog(null, status);

        }

        JOptionPane.showMessageDialog(null, myController.getTheBiggestNumArray());

    }
}
