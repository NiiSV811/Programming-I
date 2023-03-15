package ProgrammingI.exceptions;

public class ExceptionClass {
    public static void main(String[] args) {
        /*
        An Exception is an unexpected event in the code. An Exception is different an error.
        An error is beyond handling an unexpected event, an error is more related with JVM problems
        like memory Leaks, Stack Overflow, infinite recursive functions, and so on.

        Exceptions can be handling with a try-catch block and like all the things in java, Exception is a class
        in fact, a  subclass from Throwable. There is the Throwable tree:

        THROWABLE
        |------Error -> (Problems with JVM or the environment.)
        |------Exception -> (unexpected cases with logic and others.)

        There are three types of Exceptions:
        |--- Checked exceptions -> Needs to be handled or Java doesn't compile ...  It will happen in compile time.
        |--- Unchecked exceptions -> No need to be handled... It will happen in runtime.
        |----Custom exceptions -> Exceptions that can be created for specific situations.

         A throwable object will stop the program... It can be handle if throwable is an Exception.

         */

        try {
            // Lines of code that could be thrown an exception
        }catch (Exception e){
            //Lines of code that will be executed if an Exception is thrown.
            e.printStackTrace(); // Print where the exception was thrown.
        }

        /*
        A way to handle Exceptions is using a try-catch block.
         */

        /*
        Custom Exceptions:
        Create your own Exception and customize like you want.
         */

        try{
            int age = parseAge("10000");
        }catch (AgeException e){
            System.out.println(e.toString());
        }
    }

    public static int parseAge(String input) throws AgeException{
        int age = 0;
        try {
            age = Integer.parseInt(input);
            if(age < 0){
                throw new AgeException("Edad invalida, menor a 0");
            }
            if(age > 150){
                throw new AgeException("Edad invalida, mayor a 150");
            }
        }catch (NumberFormatException e){
            throw new AgeException("Información no valida para conversion");
        }

        return age;
    }


}
