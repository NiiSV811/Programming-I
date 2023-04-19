package ProgrammingI.co.edu.uptc.workshop.vehicles.controller;

import ProgrammingI.co.edu.uptc.workshop.vehicles.exceptions.CarNotFound;
import ProgrammingI.co.edu.uptc.workshop.vehicles.exceptions.InvalidVehicleArg;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.*;

public class InputController {
    private Vehicle vehicle;
    public InputController(){
        this.vehicle = null;
    }

    public void toAcelerate(double speed){
        this.vehicle.toAcelerate(speed);
    }
    public void toBrake(double speed){
        this.vehicle.toBrake(speed);
    }
    public void moveForward(double distance){
        this.vehicle.moveForward(distance);
    }
    public void moveBackward(double distance){
        this.vehicle.moveBackwarward(distance);
    }
    public void moveLeft(double distance){
        this.vehicle.moveLeft(distance);
    }
    public void moveRight(double distance){
        this.vehicle.moveRight(distance);
    }
    public void moveUp(double distance){
        this.vehicle.moveUp(distance);
    }
    public void moveDown(double distance){
        this.vehicle.moveDown(distance);
    }

    public void turnOff(){
        this.vehicle.toTurnOff();
    }
    public String selectVehicle(String[][] listVehicles, String plate) throws CarNotFound, InvalidVehicleArg {

        float fuelBar = 0;
        int doors = 0;
        int wheels = 0;
        String type = "";
        String vehiclePlate = "";
        String model = "";
        String[] vehicleToSelect = this.findVehicle(listVehicles, plate);
        try {
            if (vehicleToSelect == null) {
                throw new CarNotFound("Placa de vehiculo no encontrada");
            }
            if (vehicleToSelect[4].isEmpty()) {
                throw new InvalidVehicleArg("Tipo de vehiculo no encontrado");
            }
            if (!this.correctType(vehicleToSelect)) {
                throw new InvalidVehicleArg("Tipo de vehiculo no valido");
            }

            fuelBar = Float.parseFloat(vehicleToSelect[2].replaceAll(" ",""));
            doors = Integer.parseInt(vehicleToSelect[3].replaceAll(" ",""));
            wheels = Integer.parseInt(vehicleToSelect[4].replaceAll(" ",""));
            type = vehicleToSelect[5].replaceFirst(" ", "");
            vehiclePlate = vehicleToSelect[0].replaceAll(" ","");
            model = vehicleToSelect[1].replaceAll(" ", "");

            switch (type) {
                case "gasoline" -> {
                    this.vehicle = new GasolineCar(vehiclePlate, model,fuelBar, doors, wheels);
                }
                case "helix" -> {
                    this.vehicle = new RotatoryWings(vehiclePlate, model, fuelBar, doors, wheels);
                }
                case "plane" -> {
                    this.vehicle = new FixedWings(vehiclePlate, model,fuelBar, doors, wheels);
                }
                case "electric" ->{
                    this.vehicle = new ElectricalVehicle(vehiclePlate,model, fuelBar, doors, wheels);
                }
                case "disel"->{
                    this.vehicle = new DiselVehicle(vehiclePlate, model,fuelBar, doors, wheels);
                }
            }

        }catch(NumberFormatException e){
            throw new InvalidVehicleArg("Valores numericos no validos");
        }catch (IndexOutOfBoundsException e){
            throw new InvalidVehicleArg("Datos faltantes del vehiculo");
        } catch (CarNotFound | InvalidVehicleArg e){
            return null;
        }

        return null;
    }

    private String[] findVehicle(String[][] listVehicles, String plate){
        for (String[] vehicle : listVehicles){
            if(vehicle[0].equals(plate)) return vehicle;
        }
        return null;
    }

    private boolean correctType(String[] vehicle){
        String vehicleType = vehicle[4].replaceFirst(" ", "");
        return vehicleType.equals("gasoline") || vehicleType.equals("disel") || vehicleType.equals("electric")
                || vehicleType.equals("helix") || vehicleType.equals("plane");
    }
}
