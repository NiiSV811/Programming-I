package ProgrammingI.co.edu.uptc.workshop.vehicles.exceptions;

public class CarNotFound extends Exception{
    public CarNotFound(String errorMessage){
        super(errorMessage);
        System.out.println(this.toString());
    }
}
