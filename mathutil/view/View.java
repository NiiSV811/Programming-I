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
           status = myController.AddNumArray(input1, input2);
           JOptionPane.showMessageDialog(null, status);

        }

        JOptionPane.showMessageDialog(null,"Los numeros ingresados fueron: \n" + myController.showArrayElements() + "\n"
                + myController.getTheBiggestNumArray() + "\n" +
                myController.getTheMinorNumArray());

    }
}
