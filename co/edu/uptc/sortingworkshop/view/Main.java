package ProgrammingI.co.edu.uptc.sortingworkshop.view;

import ProgrammingI.co.edu.uptc.sortingworkshop.controller.SearchController;
import ProgrammingI.co.edu.uptc.sortingworkshop.controller.SortController;
import ProgrammingI.co.edu.uptc.sortingworkshop.exceptions.InvalidComparator;
import ProgrammingI.co.edu.uptc.sortingworkshop.exceptions.InvalidVehicleType;
import ProgrammingI.co.edu.uptc.workshop.vehicles.exceptions.InvalidVehicleArg;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.*;

import javax.swing.*;
import java.util.Random;

public class Main {

    private static final String BUBBLE = "bubble";
    private static final String SELECTION = "selection";
    private static final String INSERTION = "insertion";
    private static final String MERGE = "merge";
    private static final String QUICK = "quick";
    private static final String SHELL = "shell";
    private static final String LINEAL = "lineal";
    private static final String BINARY = "binary";
    private static Random randUtil = new Random();

    public static void main(String[] args){
        SortController sortController = new SortController();
        SearchController searchController = new SearchController();
        try{

            VehicleInput vehicles = defaultOrCustomVehicleArray();
            Vehicle[] vehicleArray = vehicles.getVehicles().clone();
            String result = "";
            int sortOrSearch = sortOrSearch();

            if (sortOrSearch == 0){
                if(vehicleArray.length > 100){
                    result = sortVehiclesTime(vehicleArray, sortController);
                }else {
                    result = sortVehicles(vehicleArray, sortController);
                }
                JOptionPane.showMessageDialog(null,result);
            }else {
                JOptionPane.showMessageDialog(null, findVehicle(vehicleArray,searchController));
            }
        }catch (InvalidComparator e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch (InvalidVehicleType e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch (InvalidVehicleArg e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch (InterruptedException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Número de espacios inválido");
        }
    }

    public static VehicleInput defaultOrCustomVehicleArray() throws InvalidVehicleArg, InvalidVehicleType{
        String[] options = new String[]{"Arreglo por Defecto", "Arreglo personalizado", "10000 vehicles"};
        int selectedOption = JOptionPane.showOptionDialog(null, "Selecciona una opción para comenzar: ", "Garaje NiiChan", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );
        if(selectedOption == 1){


            int spaces = Integer.parseInt(JOptionPane.showInputDialog(null, "numero de espacios para el garaje"));
            VehicleInput vehicleInput = new VehicleInput(spaces);
            fillVehicleArr(vehicleInput);

            return vehicleInput;

        }

        if (selectedOption == 2){
            return new VehicleInput(fillThousandVehicles());
        }

        return new VehicleInput();
    }

    private static Vehicle[] fillThousandVehicles() {

        Vehicle[] array = new Vehicle[10000];
        for (int i = 0 ; i < array.length; i++){
            array[i] = genRandomVehicle();
        }

        return array;
    }

    private static Vehicle genRandomVehicle(){
        String[] vehicleType = new String[]{"disel", "electrico", "aereorotatorio", "aereofijo","gasolina"};
        String[] modelGasoline = new String[]{"Ford Fiesta 2015", "BMW i8", "Mercedes Benz KC19", "Ford Mustang 1991", "Renault Clio 2020"};
        String[] modelDiesel = new String[]{"DAF XF", "Kenworth K81", "Mercedes KG 103", "Iveco Starlight", "Volvo FS"};
        String[] modelElectrical = new String[]{"BMW x8", "Tesla Roaster", "Tesla Model S", "Tesla Model M", "Renault Zeo"};
        String[] modelFixedWings = new String[]{"Boeing 767", "Boeing 757", "Boeing 323", "Boeing 564", "Boeing 747"};
        String[] modelRotatoryWings = new String[]{"BlackBird X2", "BlackBird X8", "BlackBird X10", "BlackBird X9", "BlackBird Zeo"};

        int[] wheels = {4, 6, 8, 3};
        int[] doors = { 2, 3, 4, 5, 6};


        int randomType = randUtil.nextInt(5);
        int randomModel = randUtil.nextInt(5);
        int randomWheels = randUtil.nextInt(wheels.length);
        int randomDoors = randUtil.nextInt(doors.length);
        double randomFuel = randUtil.nextDouble(50) + 1;
        String type = vehicleType[randomType];
        String model = "";
        switch (type){
            case "disel" -> {model = modelDiesel[randomModel] ;}
            case "gasolina" -> { model = modelGasoline[randomModel];}
            case "electrico" -> { model = modelElectrical[randomModel]; }
            case "aereorotatorio" -> { model = modelRotatoryWings[randomModel]; }
            case "aereofijo" -> { model = modelFixedWings[randomModel];}
        }

        return createNewVehicle(type, randomPlate(), model, doors[randomDoors], wheels[randomWheels], randomFuel);
    }

    public static String randomPlate(){

        String plate = "";
        for(int i = 0; i < 3; i++){
            plate += (char)(randUtil.nextInt(25) + 65) + "";
        }
        plate += " ";
        for (int j = 0; j < 3; j++){
            plate += "" + randUtil.nextInt(10);
        }

        return plate;
    }

    public static int sortOrSearch(){
        String[] options = new String[]{"Ordenar", "Buscar"};
        int selectedOption = JOptionPane.showOptionDialog(null, "Selecciona si quieres buscar u ordenar: ", "Garaje NiiChan", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );
        return selectedOption;
    }

    public static String findVehicle(Vehicle[] vehicles, SearchController controller) throws InvalidVehicleArg, InvalidVehicleType, InvalidComparator {
        int typeSearch = selectSearchType();
        if(typeSearch == 1){
             String arg = selectArg();
             String vehicleAtt = JOptionPane.showInputDialog(null, "Ingrese "+ arg + " a buscar");
             if (vehicles.length > 100){
                 return controller.linearSearchTime(vehicles,vehicleAtt,arg);
             }
             return controller.linearSearch(vehicles, vehicleAtt, arg);
        }

        String method = selectSearchMethod();

        Vehicle vehicle = verifyVehicleInfo();
        String infoToShow = "";
        if (method.compareToIgnoreCase(LINEAL) == 0){
            if (vehicles.length > 100){
                return controller.linearSearchTime(vehicles,vehicle);
            }
            infoToShow = controller.linearSearch(vehicles, vehicle);
        }else {
            if (vehicles.length > 100){
                return controller.binarySearchTime(vehicles,vehicle, "placas");
            }
            infoToShow = controller.binarySearch(vehicles, vehicle, "placas");
        }

        return infoToShow;
    }

    public static String sortVehicles(Vehicle[] vehicles, SortController controller){
        String method = selectSortMethod();
        String arg = selectArg();
       return "Ordenados por "+ arg + "\n"  + controller.sort(vehicles, method,arg);
    }

    public static String sortVehiclesTime(Vehicle[] vehicles, SortController controller) throws InterruptedException{
        String method = selectSortMethod();
        String arg = selectArg();
        return "Ordenamiento terminado en: " + controller.sortTime(vehicles, method, arg);
    }

    public static String selectArg(){
        String[] options = new String[]{"placas", "modelo", "puertas", "ruedas", "combustible"};
        int selectedOption = JOptionPane.showOptionDialog(null, "Selecciona un argumento para ordenar: ", "Método Ordenamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );
        return options[selectedOption];
    }

    public static String selectSearchMethod(){
        String[] options = new String[]{LINEAL, BINARY};
        int selectedOption = JOptionPane.showOptionDialog(null, "Selecciona un método para buscar: ", "Método Búsqueda", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );
        return options[selectedOption];
    }

    public static int selectSearchType(){
        String[] options = new String[]{"Vehiculo", "Argumento"};
        int selectedOption = JOptionPane.showOptionDialog(null, "Selecciona un tipo de busqueda: ", "Tipo de Búsqueda", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );
        return selectedOption;
    }

    public static String selectSortMethod(){
        String[] options = new String[]{BUBBLE, SELECTION, INSERTION, MERGE, QUICK, SHELL};
        int selectedOption = JOptionPane.showOptionDialog(null, "Selecciona un método para ordenar: ", "Método Ordenamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );
        return options[selectedOption];
    }

    public static void fillVehicleArr(VehicleInput vehicles) throws InvalidVehicleArg, InvalidVehicleType{
        for(int i = 0; i < vehicles.getVehicles().length; i++){
           vehicles.addNewVehicle(verifyVehicleInfo(), i);
        }
    }

    public static Vehicle verifyVehicleInfo() throws InvalidVehicleArg, InvalidVehicleType {
        String plate = "";
        String model = "";
        String vehicleType = "";
        int numDoors = 0;
        int numWheels = 0;
        double maxFuelCapacity = 0;
        boolean isInfoRight = false;
        do {
            String[] vehicleData = inputVehicleInfo();
            try {
                vehicleType = vehicleData[0].toLowerCase().replaceAll(" ", "");
                plate = vehicleData[1];
                model = vehicleData[2];
                numDoors = Integer.parseInt(vehicleData[3]);
                numWheels = Integer.parseInt(vehicleData[4]);
                maxFuelCapacity = Double.parseDouble(vehicleData[5]);

                if(numDoors < 0 || numWheels < 0 || maxFuelCapacity < 0) throw new InvalidVehicleArg("valores menores a 0");

                Vehicle myNewVehicle = createNewVehicle(vehicleType, plate,model,numDoors,numWheels,maxFuelCapacity);

                if(myNewVehicle == null) throw new InvalidVehicleType(vehicleType + "Tipo de vehículo no valido");

                isInfoRight = true;
                return myNewVehicle;
            }catch (NumberFormatException e){
                throw  new InvalidVehicleArg("Valores numéricos no válidos");
            }catch (IllegalArgumentException e){
                throw new InvalidVehicleType("Tipo de vehículo no válido");
            }

        }while (!isInfoRight);
    }

   public static String[] inputVehicleInfo(){
        String[] vehicleArgs = new String[]{"Tipo de vehiculo(disel,electrico,aereo rotatorio, aereo fijo, gasolina)",
        "placa", "modelo","Número Puertas", "Número ruedas","capacidad máxima de combustible (gl/mAh)"};

        String[] typeVehicles = new String[]{"disel", "electrico", "aereo rotatorio", "aereo fijo","gasolina"};

        String[] vehicleData = new String[6];
        int indexType = JOptionPane.showOptionDialog(null, "Selecciona tipo de vehiculo: ", "Garaje NiiChan", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, typeVehicles,0 );
        vehicleData[0] = typeVehicles[indexType];
        for (int i = 1; i < vehicleData.length; i++){
            vehicleData[i] = JOptionPane.showInputDialog(null, "Ingrese " + vehicleArgs[i]);
        }
        return vehicleData;
   }

   public static Vehicle createNewVehicle(String typeVehicle, String plate,String model, int doors, int wheels,double maxFuel){
        switch (typeVehicle){
            case "disel" -> { return  new DiselVehicle(plate,model,maxFuel,doors,wheels);}
            case "gasolina" -> { return new GasolineCar(plate, model,maxFuel, doors, wheels);}
            case "electrico" -> { return new ElectricalVehicle(plate,model, maxFuel, doors, wheels);}
            case "aereorotatorio" -> { return new RotatoryWings(plate, model,maxFuel, doors, wheels);}
            case "aereofijo" -> { return new FixedWings(plate, model,maxFuel, doors, wheels); }
        }
        return null;
   }


}
