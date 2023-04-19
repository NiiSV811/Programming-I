package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public abstract class AirVehicle extends GasolineVehicle {
    public AirVehicle(String plate, double fuelBar,int doors, int wheels){
        super(plate, fuelBar, doors, wheels);
    }

    public abstract void toTakeOff(double distance);
}
