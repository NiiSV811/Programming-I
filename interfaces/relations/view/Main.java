package ProgrammingI.interfaces.relations.view;

import ProgrammingI.interfaces.relations.model.Fraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Fraction myFrac = new Fraction(3 ,2);
        Fraction otherFrac = new Fraction(1, 4);
        Fraction sum = myFrac.add(otherFrac);
        Fraction substract = myFrac.substract(otherFrac);
        Fraction multiply = myFrac.multiply(otherFrac);
        Fraction division = myFrac.division(otherFrac);

        System.out.println( myFrac.toString() + " + " + otherFrac.toString() + " = " + sum.toString());
        System.out.println( myFrac.toString() + " - " + otherFrac.toString() + " = " + substract.toString());
        System.out.println( myFrac.toString() + " * " + otherFrac.toString() + " = " + multiply.toString());
        System.out.println( myFrac.toString() + " / " + otherFrac.toString() + " = " + division.toString());

        //
        ArrayList <Fraction> setOfFractions = new ArrayList<Fraction>();
        setOfFractions.add(new Fraction(1, 4));
        setOfFractions.add(new Fraction(1, 5));
        setOfFractions.add(new Fraction(1, 2));
        setOfFractions.add(new Fraction( 1, 6));
        setOfFractions.add(new Fraction(1, 3));

        Collections.sort(setOfFractions);
        System.out.println("Fracciones ordenas así: ");
        for(Fraction f : setOfFractions){
            System.out.println(f + "  ");
        }

    }
}
