package ProgrammingI.stringutilities.controller;

import ProgrammingI.stringutilities.model.StringUtil;

public class StringController {
    private StringUtil stringUtility;
    public StringController(){this.stringUtility = new StringUtil();}

    public String checkOddWords(String input){
        String result = "";
        input = input.replace(" ", "");
        result = this.stringUtility.reversedOddStrings(input);
        return result.equals("") ? input + " no tiene un numero impar de caracteres, no se reversará" :  input + " tiene caracteres impares  y reversado es: " + result;
    }

    public String isPalindrome(String input){
        return input + (this.stringUtility.isPalindrome(input) ? " es palindromo" : " no es palindromo");
    }

    public String rhyme(String input){
        String rhymeOdds = "";
        String rhymeEven = "";
        String[] words = input.split(",");
        rhymeOdds  = this.stringUtility.checkRhymeOdds(words);
        rhymeEven  = this.stringUtility.checkRhymeEven(words);

        return "Las rimas de los versos pares son: \n" + rhymeEven + "\n" + "Las rimas de versos impares son: " + rhymeOdds;
    }
}
