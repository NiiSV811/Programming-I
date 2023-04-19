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

    public String bubbleSortByPlate(Vehicle[] vehicles){
        Vehicle[] sortedArr = sorter.vehicleBubbleSort(vehicles);
        VehicleInput arr = new VehicleInput(sortedArr);
        return arr.toString();
    }
}
