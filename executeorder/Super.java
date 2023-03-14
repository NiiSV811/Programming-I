package ProgrammingI.executeorder;

public class Super implements SuperInterface {
    static{
        System.out.println("Super Static -> ");
        System.out.println(NUM);
    }

    public Super(){
        System.out.println("This is Super Constructor");
    }
}
