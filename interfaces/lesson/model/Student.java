package ProgrammingI.interfaces.lesson.model;

public class Student extends MyAbstractClass{
    public Student(){}
    @Override
    public boolean moveForward(int distance){
        System.out.println("Estudiante se ha movido adelante"  + distance);
        return true;
    }
    @Override
    public boolean moveLeft(int distance) {
        System.out.println("Estudiante se ha movido hacia la izquierda"  + distance);
        return true;
    }

    @Override
    public boolean moveRight(int distance){
        System.out.println("Estudiante se ha movido hacia la derecha" + distance);
        return true;
    }

    @Override
    public boolean moveBack(int distance){
        System.out.println("Estudiante se ha movido hacia atrás" + distance);
        return true;
    }
    @Override
    public boolean moveUpside(int distance) {
        System.out.println("Estudiante se ha movido hacia arriba"  + distance);
        return false;
    }

    @Override
    public boolean moveDownside(int distance) {
        System.out.println("Estudiante se ha movido hacia abajo"  + distance);
        return false;
    }

    @Override
    public void growing(int time) {
        System.out.println("Estudiante ha crecido " + time +" s");
    }

    @Override
    public void getFat(int pounds) {
        System.out.println("El estudiante ha engordado por estudiar demasiado");
    }

    @Override
    public void getSlim(int pounds) {
        System.out.println("El estudiante ha adelgazado por no comer y estar estudiando");
    }

}
