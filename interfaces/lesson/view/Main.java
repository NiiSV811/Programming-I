package ProgrammingI.interfaces.lesson.view;

import ProgrammingI.interfaces.lesson.model.*;

import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Human humano1 = new Human();
        Plant planta1 = new Plant();
        Growable serVivo = new Plant();
        Student classMate = new Student();

        System.out.println("Métodos de Estudiante");
        classMate.moveForward(1);
        classMate.moveBack(2);
        classMate.move(10);
        classMate.moveLeft(3);
        classMate.moveRight(4);
        classMate.moveUpside(5);
        classMate.moveDownside(6);

        System.out.println("Tambien puede usar los de la interfaz que implementa AbstracClass");
        classMate.growing(10);
        classMate.getFat(2);
        classMate.getSlim(3);
        classMate.died();

        System.out.println("Métodos de Human -> implementación de GrowAble");
        humano1.growing(10);
        humano1.getFat(2);
        humano1.getSlim(3);
        humano1.died();

        System.out.println("Métodos de Plant -> implementación GrowAble");
        planta1.growing(200);
        planta1.getFat(2);
        planta1.getSlim(1);

        System.out.println("Metodos de un Objeto GrowAble");
        serVivo.growing(1300);
        serVivo.getFat(3);
        serVivo.getSlim(32);
        serVivo.died();


    }
}
