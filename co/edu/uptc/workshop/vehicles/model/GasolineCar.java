package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public class GasolineCar extends GasolineVehicle {
    public GasolineCar(String plate, double fuelBar,int doors, int wheels){
        super(plate, fuelBar, doors, wheels);
    }

    @Override
    public void toConsumeFuel(double fuel) {
        if(this.getFuelBar()-fuel >= 0){
            this.setFuelBar(this.getFuelBar()-fuel* GASOLINE_PROPORTION);
        }
    }

    @Override
    public void toTurnOn() {
        System.out.println("Encendiendo vehiculo a gasolina...");
        System.out.println("Creando chispa... a traves de bujías");
        System.out.println("Empezando combustion en 4T");
        this.toConsumeFuel(this.getFullFuel());

        System.out.println("Listo, vehiculo a gasolina listo y consumiendo");

    }

    @Override
    public void toTurnOff() {
        System.out.println("Apagando vehiculo a gasolina...");
        System.out.println("Terminando combustion");
        System.out.println("Deteniendo cigueñal");
        System.out.println("* hace ruidito *");
    }


    @Override
    public void moveUp(double distance) {
        System.out.println("Los carros no vuelan");
    }

    @Override
    public void moveDown(double distance) {
        System.out.println("Los carros no se mueven hacia abajo");
    }
}
