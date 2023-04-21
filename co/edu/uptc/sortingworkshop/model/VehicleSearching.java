package ProgrammingI.co.edu.uptc.sortingworkshop.model;

import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;

public class VehicleSearching {

    public VehicleSearching(){}

    public boolean comparatorGreaterThan(Vehicle firstVehicle, Vehicle secondVehicle,String compareMode){
        boolean comparison = false;
        switch (compareMode){
            case "placas" -> { comparison = firstVehicle.getPlate().compareToIgnoreCase(secondVehicle.getPlate()) > 0; }
            case "modelo" -> { comparison = firstVehicle.getModel().compareToIgnoreCase(secondVehicle.getModel()) > 0; }
            case "puertas" -> { comparison = firstVehicle.getDoors() > secondVehicle.getDoors(); }
            case "ruedas" -> { comparison = firstVehicle.getWheels() > secondVehicle.getWheels(); }
            case "combustible" -> { comparison = firstVehicle.getFullFuel() > secondVehicle.getFullFuel(); }
        }
        return comparison;
    }
    public boolean comparator(Vehicle firstVehicle, Vehicle secondVehicle, String compareMode){
        boolean comparison = false;
        switch (compareMode){
            case "placas" -> { comparison = firstVehicle.getPlate().compareToIgnoreCase(secondVehicle.getPlate()) == 0; }
            case "modelo" -> { comparison = firstVehicle.getModel().compareToIgnoreCase(secondVehicle.getModel()) == 0; }
            case "puertas" -> { comparison = firstVehicle.getDoors() == secondVehicle.getDoors(); }
            case "ruedas" -> { comparison = firstVehicle.getWheels() == secondVehicle.getWheels(); }
            case "combustible" -> { comparison = firstVehicle.getFullFuel() == secondVehicle.getFullFuel(); }
        }
        return comparison;
    }

    public Boolean comparator(Vehicle firstVehicle,String findingValue, String compareMode){
        Boolean comparison = false;
        try{

            switch (compareMode){
                case "placas" -> { comparison = firstVehicle.getPlate().compareToIgnoreCase(findingValue) == 0; }
                case "modelo" -> { comparison = firstVehicle.getModel().compareToIgnoreCase(findingValue) == 0; }
                case "puertas" -> { comparison = firstVehicle.getDoors() == Integer.parseInt(findingValue);}
                case "ruedas" -> { comparison = firstVehicle.getWheels() == Integer.parseInt(findingValue); }
                case "combustible" -> { comparison = firstVehicle.getFullFuel() == Double.parseDouble(findingValue); }
            }
        }catch (NumberFormatException e){
            return null;
        }
        return comparison;
    }
    public boolean comparator(Vehicle firstVehicle, Vehicle secondVehicle){
        String[] attributes = new String[]{"placas", "modelo", "puertas", "ruedas", "combustible"};
        for(int att = 0; att < attributes.length; att++){
            if( ! comparator(firstVehicle, secondVehicle, attributes[att])) return false;
        }
        return true;
    }

    public boolean linearSearch(Vehicle[] vehicles, Vehicle vehicleToFind){
        for (Vehicle vh : vehicles){
            if( comparator(vehicleToFind, vh)) return  true;
        }

        return false;
    }

    public ArrayList<Vehicle> linearSearch(Vehicle[] vehicles, String findingValue, String compareMode){
        ArrayList<Vehicle> vehiclesFound = new ArrayList<>();
        for (Vehicle vh : vehicles){
            try {
                if(comparator(vh, findingValue, compareMode)){
                    vehiclesFound.add(vh);
                }
            }catch (NullPointerException e){
                return null;
            }
        }

        return vehiclesFound;
    }

    public Boolean binarySearch(Vehicle[] vehicles, Vehicle vehicleToFind, int top, int bot, String compareMode){
        int mid = 0;
        if(top >= bot){
            mid = ((top - bot)/2) + bot;
            if(comparator(vehicleToFind, vehicles[mid])){
                return true;
            }
            if(comparatorGreaterThan(vehicles[mid],vehicleToFind,compareMode)) return binarySearch(vehicles, vehicleToFind, mid-1, bot, compareMode);
            if(comparatorGreaterThan(vehicleToFind, vehicles[mid], compareMode)) return binarySearch(vehicles, vehicleToFind, top, mid+1, compareMode);
        }

        return false;
    }
}
