package ProgrammingI.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Checked {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("./text.txt");
        /* FileNotFoundException is a checked exception
           That means that JVM verify if FileNotFoundException is handle before run the program.

           We can Handle checked Exceptions using 'throws' word in method signature or using a
           try catch block -> Better practice.

          try{
            FileReader fileR = new FileReader("./text.txt");
          } catch( FileNotFoundException e ){
            e.printStackTrace();
          }

         */
    }
}
