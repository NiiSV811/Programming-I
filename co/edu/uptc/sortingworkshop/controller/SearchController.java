package ProgrammingI.co.edu.uptc.sortingworkshop.controller;

import ProgrammingI.co.edu.uptc.sortingworkshop.model.VehicleSearching;
import ProgrammingI.co.edu.uptc.sortingworkshop.model.VehicleSort;
import ProgrammingI.co.edu.uptc.sortingworkshop.view.VehicleInput;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;

import java.util.ArrayList;

public class SearchController {
    private VehicleSearching searcher;
    private VehicleSort sorter;
    public SearchController(){
        this.searcher = new VehicleSearching();
        this.sorter = new VehicleSort();
    }

    public String linearSearch(Vehicle[] vehicles, Vehicle vehicleToFind){
        boolean findingResult = searcher.linearSearch(vehicles,vehicleToFind);
        if(findingResult){
            Vehicle[] vehicleToShow = new Vehicle[]{vehicleToFind};
            VehicleInput vehicleString = new VehicleInput(vehicleToShow);
            return "El vehículo que es buscado está en los registros \n" + vehicleString.toString();
        }
        return "El vehículo que es buscado no está en los registros";
    }

    public String linearSearch(Vehicle[] vehicles, String attributeToSearch, String comparatorMode){
        ArrayList<Vehicle> results = searcher.linearSearch(vehicles,attributeToSearch,comparatorMode);
        if(results == null){
            throw  new IllegalArgumentException("Input no valido");
        }
        if (results.size() > 0){
            Vehicle[] arrayVehicle = results.toArray(new Vehicle[0]);
            VehicleInput vehicleArray = new VehicleInput(arrayVehicle);
            return "Los vehiculos encontrados con el atributo " + comparatorMode + " : " + attributeToSearch + " son : \n" + vehicleArray.toString();
        }

        return "No hay vehiculos encontrados con el atributo " + comparatorMode + " : " + attributeToSearch;
    }

    public String binarySearch(Vehicle[] vehicles, Vehicle vehicleToFind, String comparator){
        Vehicle[] vehiclesCopy = vehicles.clone();
        sorter.vehicleQuickSort(vehiclesCopy,0,vehiclesCopy.length-1,comparator);
        boolean findingResult = searcher.binarySearch(vehiclesCopy,vehicleToFind,vehiclesCopy.length-1,0, comparator);
        if(findingResult){
            Vehicle[] vehicleToShow = new Vehicle[]{vehicleToFind};
            VehicleInput vehicleString = new VehicleInput(vehicleToShow);
            return "El vehículo que es buscado está en los registros \n" + vehicleString.toString();

        }
        return "vehiculo no encontrado";
    }
}
