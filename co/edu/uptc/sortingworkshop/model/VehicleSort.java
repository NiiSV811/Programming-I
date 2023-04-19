package ProgrammingI.co.edu.uptc.sortingworkshop.model;

import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;

public class VehicleSort {

    public VehicleSort(){}

    public boolean comparator(Vehicle firstVehicle, Vehicle secondVehicle,String compareMode){
        boolean comparison = false;
        switch (compareMode){
            case "placas" -> { comparison = firstVehicle.getPlate().compareToIgnoreCase(secondVehicle.getPlate()) > 0; }
            case "serie" -> { comparison = firstVehicle.getModel().compareToIgnoreCase(secondVehicle.getModel()) > 0; }
            case "puertas" -> { comparison = firstVehicle.getDoors() > secondVehicle.getDoors(); }
            case "ruedas" -> { comparison = firstVehicle.getWheels() > secondVehicle.getWheels(); }
            case "combustible" -> { comparison = firstVehicle.getFullFuel() > secondVehicle.getFullFuel(); }
        }
        return comparison;
    }

    public Vehicle[] vehicleBubbleSort(Vehicle[] vehicleArr, String comparatorMode){
        Vehicle[] vehiclesSorted = (Vehicle[]) vehicleArr.clone();
        int size = vehiclesSorted.length - 1;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size - i; j++){
                if( comparator(vehiclesSorted[j],vehiclesSorted[j+1],comparatorMode )){
                    Vehicle temp = vehiclesSorted[j+1];
                    vehiclesSorted[j+1] = vehiclesSorted[j];
                    vehiclesSorted[j] = temp;
                }
            }
        }

        return vehiclesSorted;
    }

    public Vehicle[] vehicleSelectionSort(Vehicle[] vehicles, String comparatorMode){
        Vehicle[] vehiclesSorted = vehicles.clone();
        int size = vehiclesSorted.length - 1;
        int minValue = 0;
        for(int i = 0; i < size; i++){
            minValue = i;
            for (int j = i+1; j <= size; j++ ){
                if( comparator(vehiclesSorted[minValue],vehiclesSorted[j], comparatorMode )){
                    minValue = j;
                }
            }
            Vehicle temp = vehiclesSorted[i];
            vehiclesSorted[i] = vehiclesSorted[minValue];
            vehiclesSorted[minValue] = temp;

        }

        return vehiclesSorted;
    }

    public Vehicle[] vehicleInsertionSort(Vehicle[] vehicles, String comparatorMode){
        Vehicle[] vehiclesSorted = vehicles.clone();
        int size = vehiclesSorted.length;
        int j = 0;
        for(int i = 1; i < size; i++){
            Vehicle keyVehicle = vehiclesSorted[i];
            j = i - 1;
            while (j >= 0 && comparator(vehiclesSorted[j],keyVehicle, comparatorMode)){
                vehiclesSorted[j+1] = vehiclesSorted[j];
                j--;
            }

            vehiclesSorted[j+1] = keyVehicle;
        }
        return vehiclesSorted;
    }


}
