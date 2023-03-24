package ProgrammingI.co.edu.uptc.workshop.vehicles.controller;

import ProgrammingI.co.edu.uptc.workshop.vehicles.exceptions.CarNotFound;
import ProgrammingI.co.edu.uptc.workshop.vehicles.exceptions.InvalidVehicleArg;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.DiselVehicle;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.ElectricalVehicle;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.GasolineCar;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;

public class InputController {

    public InputController(){}
    public Vehicle selectVehicle(String[][] listVehicles, String plate) throws CarNotFound, InvalidVehicleArg {

        float fuelBar = 0;
        int doors = 0;
        int wheels = 0;
        String type = "";
        String vehiclePlate = "";
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

            fuelBar = Float.parseFloat(vehicleToSelect[1].replaceAll(" ",""));
            doors = Integer.parseInt(vehicleToSelect[2].replaceAll(" ",""));
            wheels = Integer.parseInt(vehicleToSelect[3].replaceAll(" ",""));
            type = vehicleToSelect[4].replaceFirst(" ", "");
            vehiclePlate = vehicleToSelect[0].replaceAll(" ","");

            switch (type) {
                case "gasoline" -> {
                    return new GasolineCar(vehiclePlate, fuelBar, doors, wheels);
                }

                case "disel" -> {
                    return new DiselVehicle(vehiclePlate, fuelBar, doors, wheels);
                }
                case "electric" -> {
                    return new ElectricalVehicle(vehiclePlate, fuelBar, doors, wheels);
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
        return vehicleType.equals("gasoline") || vehicleType.equals("disel") || vehicleType.equals("electric");
    }
}
