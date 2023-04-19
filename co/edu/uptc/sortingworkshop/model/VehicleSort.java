package ProgrammingI.co.edu.uptc.sortingworkshop.model;

import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;

public class VehicleSort {

    public VehicleSort(){}



    public Vehicle[] vehicleBubbleSort(Vehicle[] vehicleArr){
        Vehicle[] vehiclesSorted = (Vehicle[]) vehicleArr.clone();
        int size = vehiclesSorted.length - 1;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size - i; j++){
                if( vehiclesSorted[j].getPlate().compareToIgnoreCase(vehiclesSorted[j+1].getPlate()) > 0){
                    Vehicle temp = vehiclesSorted[j+1];
                    vehiclesSorted[j+1] = vehiclesSorted[j];
                    vehiclesSorted[j] = temp;
                }
            }
        }

        return vehiclesSorted;
    }


}
