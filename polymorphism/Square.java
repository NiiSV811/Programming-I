package ProgrammingI.polymorphism;

import java.util.SortedMap;

public class Square implements Figurable, Paintable{
    private double side;
    public Square(double side){
        this.side = side;
    }

    public double getSide(){ return  this.side; }
    public void setSide(double side){ this.side = side; }

    @Override
    public double caclPerimeter() {
        return this.side * 4;
    }

    @Override
    public double calcArea() {
        return Math.pow(this.side, 2);
    }

    // Paintable Methods

    @Override
    public void fillColor(String color) {
        System.out.println("This square is painted with "  + color);
    }

    @Override
    public void fillTexture(String texture) {
        System.out.println("This square is filled up with " + texture + " texture");

    }
}
