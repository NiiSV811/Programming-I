package ProgrammingI.co.edu.uptc.sortingworkshop.view;

import ProgrammingI.co.edu.uptc.workshop.vehicles.model.*;

public class VehicleInput {
    private Vehicle[] vehicles;
    private Integer size;
    public VehicleInput(int size){
        this.size = size;
        this.vehicles = new Vehicle[size];
    }
    public VehicleInput(){
        this.vehicles = new Vehicle[]{
                new GasolineCar("ABC 123", 600, 4, 4),
                new ElectricalVehicle("VBN 564", 1000, 4, 4),
                new FixedWings("BNMZ 8765", 6000, 2,8),
                new RotatoryWings("CVBS 5637", 4500, 2,8),
                new DiselVehicle("HJY 456", 1200, 2, 6),
                new GasolineCar("MNB 987", 1100, 4, 4),
                new ElectricalVehicle("JHG 875", 2000, 4, 4)
        };
    }

    public VehicleInput(Vehicle[] vehicles){
        this.vehicles = vehicles;
    }

    public void addNewVehicle(Vehicle vehicle,int index){
        this.vehicles[index] =  vehicle;
    }
    public Vehicle[] getVehicles(){return this.vehicles;}
    public Vehicle getVehicle(int index){
        return this.vehicles[index];
    }

    @Override
    public String toString(){
        String result = "{ \n";
        for (Vehicle vehicle : this.vehicles){
            result += vehicleToString(vehicle) + " \n";
        }
        result += "}";
        return result;
    }


    public String vehicleToString(Vehicle vehicle){
        return " [ Vehiculo "  + " : " + vehicle.getClass().getSimpleName() +" , placa : " + vehicle.getPlate() + " , número Puertas: " + vehicle.getDoors() +
                " ,  número ruedas: " + vehicle.getWheels() + " , maximo combustible: " + vehicle.getFullFuel() + " ]";
    }
}
