package ProgrammingI.interfaces.relations.model;

import java.util.Collections;

public class Fraction implements Relationable, Comparable<Fraction> , Nameable {
    //Attributes
    private int numerator;
    private int denominator;
    //Constructors
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }
    public Fraction(){
        this.numerator = 0;
        this.denominator = 0;
    }
    //Set % Get
    public void setNumerator(int n){ this.numerator = n;}
    public void setDenominator(int d){this.denominator = d;}

    public int getNumerator(){return this.numerator;}
    public int getDenominator(){return this.denominator;}
    //Own Methods
    private int mcd() {
        int u = Math.abs(this.numerator); //valor absoluto del numerador
        int v = Math.abs(this.denominator); //valor absoluto del denominador
        if (v == 0) {
            return u;
        }
        int r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }

    private void simplify() {
        int n = this.mcd();
        this.numerator /= n;
        this.denominator/=  n;
    }

    private Fraction additiveInverse(Fraction a){
        return new Fraction((a.getNumerator() * (-1)), a.getDenominator());
    }
    private Fraction multiplyInverse(Fraction a){
        return new Fraction(a.getDenominator() , a.getNumerator());
    }

    //Add
    public Fraction add(Fraction a){
        Fraction result = new Fraction();
        int newNum = (a.getNumerator() * this.denominator) + (a.getDenominator() * this.numerator);
        int newDen = a.getDenominator() * this.denominator;
        result.setNumerator(newNum);
        result.setDenominator(newDen);
        result.simplify();

        return result;
    }
    //Substract
    public Fraction substract(Fraction a){
        Fraction inverse = this.additiveInverse(a);
        return this.add(inverse);
    }


    //Multiply
    public Fraction multiply(Fraction a){
        Fraction result = new Fraction();
        int newNum = a.getNumerator()  * this.numerator;
        int newDen = a.getDenominator() * this.denominator;

        result.setNumerator(newNum);
        result.setDenominator(newDen);
        result.simplify();

        return  result;
    }

    //Division
    public Fraction division(Fraction a){
        Fraction inverse = this.multiplyInverse(a);
        return this.multiply(inverse);
    }



    //Implements Methods
    @Override
    public String toString(){
        this.simplify();
        return this.numerator + " / " + this.denominator;
    }
    @Override
    public Boolean isBiggerThan(Relationable n){
        if(n == null){
            return false;
        }
        if(!(n instanceof Fraction)){
            return false;
        }
        Fraction tempFrac = (Fraction) n;
        this.simplify();
        tempFrac.simplify();

        double valueOfThis = this.numerator / (double) this.denominator;
        double valueOfTempFrac = tempFrac.getNumerator() / (double)tempFrac.getDenominator() ;

        return valueOfThis > valueOfTempFrac;
    }

    @Override
    public Boolean isEqualThan(Relationable n){
        if(n == null){
            return false;
        }
        if(!(n instanceof Fraction)){
            return false;
        }
        Fraction tempFrac = (Fraction) n;
        this.simplify();
        tempFrac.simplify();

        double valueOfThis = this.numerator / (double) this.denominator;
        double valueOfTempFrac = tempFrac.getNumerator() / (double)tempFrac.getDenominator() ;

        return valueOfThis == valueOfTempFrac;
    }

    @Override
    public Boolean isMinorThan(Relationable n){
        if(n == null){
            return false;
        }
        if(!(n instanceof Fraction)){
            return false;
        }
        Fraction tempFrac = (Fraction) n;
        this.simplify();
        tempFrac.simplify();

        double valueOfThis = this.numerator / (double) this.denominator;
        double valueOfTempFrac = tempFrac.getNumerator() / (double)tempFrac.getDenominator() ;

        return valueOfThis < valueOfTempFrac;
    }

    @Override
    public int compareTo(Fraction a){
        return this.isMinorThan(a) ? -1 : this.isEqualThan(a) ? 0 : 1;
    }

    @Override //Override when 2 interfaces have the same default method
    public String getClassName(){
        return Nameable.super.getClassName();
    }

}
