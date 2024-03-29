package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public  abstract class Vehicle implements Turneable, Consumible, Moveable {
    private int doors;
    private int wheels;
    private double speed;
    private String plate;
    private String model;
    private double fuelBar;
    private double fullFuel;

    public Vehicle(String plate,String model, double fullFuel,int doors, int wheels){
        this.plate = plate;
        this.model = model;
        this.fullFuel = fullFuel;
        this.fuelBar = fullFuel;
        this.doors = doors;
        this.wheels = wheels;
        this.speed = 0;

        //printPlate();
        //toTurnOn();
        //fuelLevel();
    }

    public String getPlate() {
        return plate;
    }
    public String getModel() {
        return model;
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return wheels;
    }

    public double getSpeed() {
        return speed;
    }

    public double getFuelBar() {
        return fuelBar;
    }

    public double getFullFuel() {
        return fullFuel;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setFuelBar(double fuelBar) {
        this.fuelBar = fuelBar;
    }

    public void toAcelerate(double speedUp){
        toConsumeFuel(2);
        fuelLevel();
        this.speed+= speedUp;
    }

    public void toBrake(double speedDown){
        this.speed -= speedDown;

    }

    public void printPlate(){
        System.out.println("Vehiculo de placas ( " + this.plate + " )");
    }

    public void fuelLevel(){
        System.out.println("Porcentaje de combustible " + (this.fuelBar/this.fullFuel)*100 + " %");
    }


    @Override
    public void moveForward(double distance) {
        System.out.println("vehiculo viajando a " + distance + " (m) hacia adelante");
    }

    @Override
    public void moveBackwarward(double distance) {
        System.out.println("vehiculo viajando a " + distance + " (m) hacia atrás");
    }

    @Override
    public void moveLeft(double distance) {
        System.out.println("vehiculo viajando a " + distance + " (m) a la izquierda");
    }

    @Override
    public void moveRight(double distance) {
        System.out.println("vehiculo viajando a " + distance + " (m) a la derecha");
    }
    @Override
    public void moveUp(double distance) {

        System.out.println("vehiculo viajando a " + distance + " (m) hacia arriba");
    }
    @Override
    public void moveDown(double distance) {
        System.out.println("vehiculo viajando a " + distance + " (m)  hacia abajo");
    }

    @Override
    public void toRefillFuel() {
        System.out.println("Llenando combustible");
        this.setFuelBar(this.getFullFuel());
    }
}
