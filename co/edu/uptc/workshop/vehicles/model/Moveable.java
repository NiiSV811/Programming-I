package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public interface Moveable {

    float MIN_TAKE_OFF_VERTICAL = 5;
    float MIN_TAKE_OFF_HORIZONTAL = 2;
    void moveForward(double distance);
    void moveBackwarward(double distance);
    void moveLeft(double distance);
    void moveRight(double distance);
    void moveUp(double distance);
    void moveDown(double distance);
}
