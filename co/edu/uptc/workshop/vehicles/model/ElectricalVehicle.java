package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public class ElectricalVehicle extends TerrestVehicle{
    public ElectricalVehicle(String plate, String series,double fuelBar,int doors, int wheels){
        super(plate, series,fuelBar, doors, wheels);
    }

    @Override
    public void toConsumeFuel(double fuel) {
        if(this.getFuelBar()-fuel >= 0){
            this.setFuelBar(this.getFuelBar()-fuel * BATTERY_PROPORTION);
        }
    }

    @Override
    public void toTurnOn() {
        System.out.println("Encendiendo vehiculo electrico...");
        System.out.println("Conectando batería a moteres");
        System.out.println("Listo! * No hace ruido *");
    }

    @Override
    public void toTurnOff() {
        System.out.println("Apagando vehiculo electrico...");
        System.out.println("Desconectando batería");
        System.out.println("* No hace ruido *");
    }

    @Override
    public void fuelLevel(){
        System.out.println("Porcentaje de bateria " + (this.getFuelBar()/this.getFullFuel())*100 + " %");
    }
}
