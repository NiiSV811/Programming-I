package ProgrammingI.exceptions;

public class Unchecked {
    public static void main(String[] args) {
        int zeroDivision = 10 / 0;
        /*
            Divide by Zero is an unchecked exception, because, JVM does not
            verify it before run the program. Arithmetic Exception will be thrown
            in run time. We can handle it with a try-catch block.
         */


        int[] array = new int[4];
        int outBounds = array[5];

        /*
            The code in line 13 is another example of Unchecked Exception. -> ArrayOutOfBounds
            Because we are trying to use an index out of the array limits.

            There are another examples of Unchecked exceptions like:
            -NullPointerException
            -NumberFormatException
            -ClassNotFoundException
            -ClassCastException
         */
    }
}
