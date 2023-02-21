package ProgrammingI.mathutil.view;

import ProgrammingI.mathutil.controller.NumArrayController;
import ProgrammingI.mathutil.model.MathUtil;

import javax.swing.*;

public class View {
    public static void main(String[] args) {
        NumArrayController myController = new NumArrayController();
        String status = "";
        String input1 = "";
        String input2 = "";
        String result = "";
        String title = "Nino Maths";
        String arrayIsFull = "El arreglo ya está lleno de números.";
        String[] options = new String[]{"1. numeros mayores y menores", "2. veces en el array", "3. frecuencia de numeros", "4. Frecuencia array custom", "5. Salir"};
        int optionSelected = 0;

        optionSelected = JOptionPane.showOptionDialog(null, "Selecciona una operación: ", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );

        if(optionSelected == 4){
            return;
        }
        switch (optionSelected){
            case 0 ->{
                while (!status.equals(arrayIsFull)){
                    input1 = JOptionPane.showInputDialog(null, "Ingrese 2 valores a comparar: \n" + "Ingrese el primer valor: ");
                    input2 = JOptionPane.showInputDialog(null, "Ingrese el valor 2 (escriba [ x ] para terminar) ");
                    if(input2.equals("x")){
                        break;
                    }
                    status = myController.AddNumArray(input1, input2);
                    JOptionPane.showMessageDialog(null, status);
                }
                    result = "Los numeros ingresados fueron: \n" + myController.showArrayElements() + "\n"
                            + myController.getTheBiggestNumArray() + "\n" +
                            myController.getTheMinorNumArray();
            }
            case 1 ->{
                input1 = JOptionPane.showInputDialog(null, "Ingrese un numero para comprobar si está en el array");
                result = myController.showTimesNum(input1);
            }
            case 2 ->{
                result = myController.showTimesEachNum();
            }
            case 3 ->{
                input1 = JOptionPane.showInputDialog(null, "Ingresa una serie de numeros para contar su frecuencia, separados por comas");
                result = myController.showTimesEachNum(input1);
            }
        }

        JOptionPane.showMessageDialog(null, result);


    }


}
