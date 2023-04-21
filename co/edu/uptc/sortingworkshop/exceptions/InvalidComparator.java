package ProgrammingI.co.edu.uptc.sortingworkshop.exceptions;

import javax.swing.*;

public class InvalidComparator extends Exception{
    public InvalidComparator(String errorMessage){
        super(errorMessage);
    }
}
