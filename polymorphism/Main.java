package ProgrammingI.polymorphism;

public class Main {
    public static void main(String[] args) {
        Square sqr = new Square(4);
        System.out.println("Square Area is " + sqr.calcArea() + " u");
        System.out.println("Square Perimeter is " + sqr.caclPerimeter() + " u");
        sqr.fillColor("#ffffff");
        sqr.fillTexture("Wood");
    }
}
