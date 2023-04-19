package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public abstract class AirVehicle extends GasolineVehicle {
    public AirVehicle(String plate,String series, double fuelBar,int doors, int wheels){
        super(plate, series,fuelBar, doors, wheels);
    }

    public abstract void toTakeOff(double distance);
}
