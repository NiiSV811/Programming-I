package ProgrammingI.co.edu.uptc.sortingworkshop.controller;

import ProgrammingI.co.edu.uptc.sorting.Sorting;
import ProgrammingI.co.edu.uptc.sortingworkshop.model.VehicleSort;
import ProgrammingI.co.edu.uptc.sortingworkshop.view.VehicleInput;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;

public class SortController {
    private VehicleSort sorter;
    public SortController(){
        this.sorter = new VehicleSort();
    }

    public String bubbleSort(Vehicle[] vehicles, String comparator){
        Vehicle[] sortedArr = sorter.vehicleBubbleSort(vehicles, comparator);
        VehicleInput arr = new VehicleInput(sortedArr);
        return arr.toString();
    }

    public String selectionSort(Vehicle[] vehicles, String comparator){
        Vehicle[] sortedArr = sorter.vehicleSelectionSort(vehicles, comparator);
        VehicleInput arr = new VehicleInput(sortedArr);
        return arr.toString();
    }

    public String insertionSort(Vehicle[] vehicles, String comparator){
        Vehicle[] sortedArr = sorter.vehicleInsertionSort(vehicles, comparator);
        VehicleInput arr = new VehicleInput(sortedArr);
        return arr.toString();
    }
}
