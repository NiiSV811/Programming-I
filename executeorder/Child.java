package ProgrammingI.executeorder;

public class Child extends Super implements ChildInterface{
    static {
        System.out.println("Child class ->");
        System.out.println(AYB);
    }

    public Child(){
        System.out.println("This is Child Constructor");
    }
}
