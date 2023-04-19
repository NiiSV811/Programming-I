package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public class FixedWings extends AirVehicle{
    public FixedWings(String plate, String series,double fuelBar,int doors, int wheels){
        super(plate, series,fuelBar, doors, wheels);
    }

    @Override
    public void toTakeOff(double distance) {
        super.moveForward(distance);
        super.moveUp(distance);
    }

    public void toTakeOff() {
        super.moveForward(MIN_TAKE_OFF_HORIZONTAL);
        super.moveUp(MIN_TAKE_OFF_VERTICAL);
    }


    @Override
    public void toConsumeFuel(double fuel) {
        if(this.getFuelBar()-fuel >= 0){
            this.setFuelBar(this.getFuelBar()-fuel* GASOLINE_AIR_PROPORTION);
        }
    }

    @Override
    public void toTurnOn() {
        System.out.println("Prendiendo turbinas");
        System.out.println("Comenzando movimiento horizontal");
        System.out.println("Ascendiendo");
        this.toConsumeFuel(this.getFullFuel());
        toTakeOff();
    }

    @Override
    public void toTurnOff() {
        System.out.println("Descendiendo");
        System.out.println("Deteniendo turbinas");
        System.out.println("Apagando motores");
    }
}
