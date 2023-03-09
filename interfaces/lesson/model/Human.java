package ProgrammingI.interfaces.lesson.model;

public class Human implements Growable{
    public Human(){}
    @Override
    public void growing(int time) {
        System.out.println("El humano ha crecido en " + time + " s");
    }

    @Override
    public void getFat(int pounds) {
        System.out.println("El humano ha engordado " + pounds + " lb");
    }

    @Override
    public void getSlim(int pounds) {
        System.out.println("El humano ha adelgazado, perdiendo " + pounds + " lb");
    }

    @Override
    public void died() {
        System.out.println("El humano se murió");
    }
}
