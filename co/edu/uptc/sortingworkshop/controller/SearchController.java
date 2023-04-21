package ProgrammingI.co.edu.uptc.sortingworkshop.controller;

import ProgrammingI.co.edu.uptc.sortingworkshop.exceptions.InvalidComparator;
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

    public String linearSearchTime(Vehicle[] vehicles, Vehicle vehicleToFind){
        long startTime = System.nanoTime();
        boolean findingResult = searcher.linearSearch(vehicles,vehicleToFind);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        if(findingResult){
            Vehicle[] vehicleToShow = new Vehicle[]{vehicleToFind};
            VehicleInput vehicleString = new VehicleInput(vehicleToShow);
            return "El vehículo que es buscado está en los registros \n" + "Tiempo de busqueda en : " + timeElapsed / 1000000  + " milisegundos";
        }
        return "El vehículo que es buscado no está en los registros \n" + "Tiempo de busqueda en : " + timeElapsed / 1000000  + " milisegundos";
    }

    public String linearSearch(Vehicle[] vehicles, String attributeToSearch, String comparatorMode) throws InvalidComparator{
        ArrayList<Vehicle> results = searcher.linearSearch(vehicles,attributeToSearch,comparatorMode);
        if(results == null){
            throw  new InvalidComparator("Comparador no válido para la búsqueda");
        }
        if (results.size() > 0){
            Vehicle[] arrayVehicle = results.toArray(new Vehicle[0]);
            VehicleInput vehicleArray = new VehicleInput(arrayVehicle);
            return "Los vehiculos encontrados con el atributo " + comparatorMode + " : " + attributeToSearch + " son : \n" + vehicleArray.getVehicles().length;
        }

        return "No hay vehiculos encontrados con el atributo " + comparatorMode + " : " + attributeToSearch;
    }

    public String linearSearchTime(Vehicle[] vehicles, String attributeToSearch, String comparatorMode) throws InvalidComparator{
        long startTime = System.nanoTime();
        ArrayList<Vehicle> results = searcher.linearSearch(vehicles,attributeToSearch,comparatorMode);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        if(results == null){
            throw  new InvalidComparator("Comparador no válido para la búsqueda");
        }
        if (results.size() > 0){
            Vehicle[] arrayVehicle = results.toArray(new Vehicle[0]);
            VehicleInput vehicleArray = new VehicleInput(arrayVehicle);
            return "Los vehiculos encontrados con el atributo " + comparatorMode + " : " + attributeToSearch + " son : \n" + vehicleArray.getVehicles().length + "\nTiempo de busqueda en : " + timeElapsed / 1000000 + " milisegundos";
        }

        return "No hay vehiculos encontrados con el atributo " + comparatorMode + " : " + attributeToSearch + "\nTiempo de busqueda en : " + timeElapsed / 1000000  + " milisegundos";
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

    public String binarySearchTime(Vehicle[] vehicles, Vehicle vehicleToFind, String comparator){
        Vehicle[] vehiclesCopy = vehicles.clone();
        sorter.vehicleQuickSort(vehiclesCopy,0,vehiclesCopy.length-1,comparator);
        long startTime = System.nanoTime();
        boolean findingResult = searcher.binarySearch(vehiclesCopy,vehicleToFind,vehiclesCopy.length-1,0, comparator);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        if(findingResult){
            Vehicle[] vehicleToShow = new Vehicle[]{vehicleToFind};
            VehicleInput vehicleString = new VehicleInput(vehicleToShow);
            return "El vehículo que es buscado está en los registros \n" +  "\nTiempo de busqueda en : " + timeElapsed / 1000000  + " milisegundos";

        }
        return "vehiculo no encontrado" + "\nTiempo de busqueda en : " + timeElapsed / 1000000  + " milisegundos";
    }
}
