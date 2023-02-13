package ProgrammingI.mathutil.controller;

import ProgrammingI.mathutil.model.MathUtil;

public class NumArrayController {
    private MathUtil myUtil;
    public NumArrayController(){
        this.myUtil = new MathUtil(4);
    }

    public String biggerThan(String num1, String num2){
        int castedNum1 = 0;
        int castedNum2 = 0;
        int tempResult = 0;
        String result = "";

        try {
            castedNum1 = Integer.parseInt(num1);
            castedNum2 = Integer.parseInt(num2);
            tempResult = this.myUtil.BiggerThan(castedNum1, castedNum2);
            result = Integer.toString(tempResult);
        }catch (NumberFormatException e){
            return "Datos no válidos para la comparación";
        }

        return "El número mayor entre " + num1 + " y " + num2 + " es: " + result;
    }


    public String AddNumArray(String num){
        int castedInt = 0;
        try {
            castedInt = Integer.parseInt(num);
            this.myUtil.addNumToNumArray(castedInt);
            return "El número " + num + " Se ha añadido exitosamente";
        }catch (NumberFormatException e){
            return "Número inválido para la conversión.";
        }catch (ArrayIndexOutOfBoundsException e){
            return "El arreglo ya está lleno de números.";
        }
    }

    public String getTheBiggestNumArray(){
        String result = "";
        int tempResult = 0;

        if(this.myUtil.getIterator() == 0){
            return "Arreglo vacío, no hay números. Vuelva mañana.";
        }

        tempResult = this.myUtil.biggestNumArray();
        result = Integer.toString(tempResult);

        return "El número mayor ingresado fue: " + result;
    }

}
