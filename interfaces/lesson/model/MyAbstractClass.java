package ProgrammingI.interfaces.lesson.model;

public abstract class MyAbstractClass implements Growable {
    public MyAbstractClass(){}

    public abstract boolean  moveForward(int distance);
    public abstract boolean moveLeft(int distance);
    public abstract boolean moveRight(int distance);
    public abstract boolean moveBack(int distance);

    public abstract boolean moveUpside(int distance);
    public abstract boolean moveDownside(int distance);

    public boolean move(int distance){
        System.out.println("Se ha movido a " + distance + "m");
        return true;
    }

    public void Greet(){
        System.out.println("Hola...");
    }
    public void died(){
        System.out.println("Clase abstracta ha muerto");
    }
}
