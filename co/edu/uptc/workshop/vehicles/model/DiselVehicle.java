package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public class DiselVehicle extends TerrestVehicle {

    public DiselVehicle(String plate, String series, double fuelBar,int doors, int wheels){
        super(plate,series, fuelBar, doors, wheels);
    }

    @Override
    public void toConsumeFuel(double fuel) {
        if(this.getFuelBar()-fuel >= 0){
            this.setFuelBar(this.getFuelBar()-fuel* DISEL_PROPORTION);
        }
    }

    @Override
    public void toTurnOn() {
        System.out.println("Encendiendo vehiculo a disel...");
        System.out.println("Usando alternador para crear prersion y arrancar motor");
        System.out.println("Empezando combustion");
        this.toConsumeFuel(this.getFullFuel());
    }

    @Override
    public void toTurnOff() {
        System.out.println("Apagando vehiculo a disel...");
        System.out.println("Terminando combustion");
        System.out.println("Deteniendo cigueñal");
        System.out.println("* hace ruido fuerte *");
    }
}
