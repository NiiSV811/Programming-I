package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public abstract class TerrestVehicle extends Vehicle{
    public TerrestVehicle(String plate, String series, double fuelBar,int doors, int wheels){
        super(plate, series,fuelBar, doors, wheels);
    }

    @Override
    public void moveUp(double distance){System.out.println("No puede ir arriba");}

    @Override
    public void moveDown(double distance){
        System.out.println("No puede ir abajo");
    }
}
