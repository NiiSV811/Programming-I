package ProgrammingI.interfaces.relations.view;

import ProgrammingI.interfaces.relations.model.Fraction;
import ProgrammingI.interfaces.relations.model.Line;
import ProgrammingI.interfaces.relations.model.Relationable;

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

        Line myLn = new Line(new int[]{1,1});
        Line otherLn = new Line(new int[]{1,2});
        ArrayList <Line> lines = new ArrayList<Line>();
        lines.add(new Line(new int[]{9,2}));
        lines.add(myLn);
        lines.add(otherLn);
        lines.add(new Line(new int[]{2,8}));

        Collections.sort(lines);

        for (Line l : lines){
            System.out.println(l.toString());
        }

        Relationable r1 = new Fraction(2,3);
        Relationable r2 = new Line(new int[]{4,3}); //Create "Relationable" Objects like Lines or Fractions
        ArrayList <Relationable> setRelationable = new ArrayList < Relationable>();
        setRelationable.add(myFrac); // Can Add Fraction Objects
        setRelationable.add(myLn);   //Can Add Line Objects
        setRelationable.add(r1);
        setRelationable.add(r2);

        for(Relationable r : setRelationable) {
            System.out.println(r.getClassName());
        }

    }
}
