package ProgrammingI.interfaces.lesson.model;

public class Plant implements Growable{
    public Plant(){}
    @Override
    public void growing(int time) {
        System.out.println("Planta ha crecido en " + time + " s.");
    }

    @Override
    public void getFat(int pounds) {
        System.out.println("Planta ha adquirido " + pounds+" lb de masa");
    }

    @Override
    public void getSlim(int pounds) {
        System.out.println("Planta ha perdido " + pounds + " lb de masa");
    }

    @Override
    public void died() {
        System.out.println("Oh no Planta se ha muerto :(");
    }
}
