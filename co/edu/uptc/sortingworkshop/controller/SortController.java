package ProgrammingI.co.edu.uptc.sortingworkshop.controller;

import ProgrammingI.co.edu.uptc.sorting.Sorting;
import ProgrammingI.co.edu.uptc.sortingworkshop.model.VehicleSort;
import ProgrammingI.co.edu.uptc.sortingworkshop.view.VehicleInput;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;

public class SortController {
    private VehicleSort sorter;
    private static final String BUBBLE = "bubble";
    private static final String SELECTION = "selection";
    private static final String INSERTION = "insertion";
    private static final String MERGE = "merge";
    private static final String QUICK = "quick";
    private static final String SHELL = "shell";
    public SortController(){
        this.sorter = new VehicleSort();
    }


    public String sort(Vehicle[] vehicles, String method, String comparator){
        Vehicle[] vehiclesCopy = vehicles.clone();
        switch (method){
            case BUBBLE -> { sorter.vehicleBubbleSort(vehiclesCopy, comparator);}
            case SELECTION -> { sorter.vehicleSelectionSort(vehiclesCopy, comparator);}
            case INSERTION -> { sorter.vehicleInsertionSort(vehiclesCopy, comparator);}
            case MERGE -> { sorter.vehicleMergeSort(vehiclesCopy, 0, vehiclesCopy.length-1, comparator);}
            case QUICK -> { sorter.vehicleQuickSort(vehiclesCopy, 0, vehiclesCopy.length-1, comparator);}
            case SHELL -> { sorter.vehicleShellSort(vehiclesCopy, comparator);}
            default -> { return "Método de ordenamiento no válido";}
        }

        VehicleInput arr = new VehicleInput(vehiclesCopy);
        return arr.toString();
    }

}
