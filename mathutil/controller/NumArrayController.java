package ProgrammingI.mathutil.controller;

import ProgrammingI.mathutil.model.MathUtil;

public class NumArrayController {
    private MathUtil myUtil;
    public NumArrayController(){
        this.myUtil = new MathUtil(3);
    }

    /*public String biggerThan(String num1, String num2){
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

     */


    public String AddNumArray(String num1, String num2){
        int castedNum1 = 0;
        int castedNum2 = 0;
        int result = 0;
        try {
            castedNum1 = Integer.parseInt(num1);
            castedNum2 = Integer.parseInt(num2);
            result = this.myUtil.addBiggerToNumArray(castedNum1,castedNum2);
            return "El número mayor es: " + result + " Y se ha añadido exitosamente";
        }catch (NumberFormatException e){
            return "Número inválido para la conversión.";
        }catch (ArrayIndexOutOfBoundsException e){
            return "El arreglo ya está lleno de números.";
        }
    }

    public String showArrayElements(){
        int[] tempArr = this.myUtil.getNumArray();
        String result = "[ ";

        for (int i = 0; i < this.myUtil.getIterator(); i++){
            result += ", " + tempArr[i] + " ";
        }
        result = result.replaceFirst("," , "") + "]";
        return result;
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

    public String getTheMinorNumArray(){
        String result = "";
        int tempResult = 0;

        if(this.myUtil.getIterator() == 0){
            return "Arreglo vacío, no hay números. Vuelva mañana.";
        }

        tempResult = this.myUtil.theMinorNumArray();
        result = Integer.toString(tempResult);

        return "El número menor ingresado fue: " + result;
    }


}
