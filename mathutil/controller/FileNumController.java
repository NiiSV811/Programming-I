package ProgrammingI.mathutil.controller;

import ProgrammingI.mathutil.model.MathUtil;

public class FileNumController {
    private MathUtil myMathUtil;
    public FileNumController(){
        myMathUtil = new MathUtil();
    }

    private int[] stringToNumArray(String input){
        int[] arr;
        String[] inputArray;

        input = input.replace(" ", "");
        input = input.replace(".", "");
        inputArray = input.split(",");

        arr = new int[inputArray.length];

        for(int i = 0; i < inputArray.length; i++){
            try{
                arr[i] = Integer.parseInt(inputArray[i]);
            }catch (NumberFormatException e){
                return null;
            }
        }

        return arr;
    }

    public String getTheBigger(String input){
        int[] nums = this.stringToNumArray(input);
        int result = 0;
        if (nums == null){
            return "Datos no validos para la conversión";
        }

        result = myMathUtil.biggestNumArray(nums);

        return "El numero más grande encontrado en el archivo es: " + result;
    }

    public String getTheMinor(String input){
        int[] nums = this.stringToNumArray(input);
        int result = 0;
        if (nums == null){
            return "Datos no validos para la conversión";
        }

        result = myMathUtil.theMinorNumArray(nums);

        return "El numero más pequeño encontrado en el archivo es: " + result;
    }

}
