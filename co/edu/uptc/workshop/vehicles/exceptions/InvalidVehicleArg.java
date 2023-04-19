package ProgrammingI.co.edu.uptc.workshop.vehicles.exceptions;

public class InvalidVehicleArg extends Exception{
    public InvalidVehicleArg(String errorMessage){
        super(errorMessage);
        System.out.println(errorMessage);
        System.exit(0);
    }
}
