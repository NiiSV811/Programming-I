package ProgrammingI.co.edu.uptc.sortingworkshop.view;

import ProgrammingI.co.edu.uptc.sortingworkshop.controller.SearchController;
import ProgrammingI.co.edu.uptc.sortingworkshop.controller.SortController;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.*;

import javax.swing.*;

public class Main {

    private static final String BUBBLE = "bubble";
    private static final String SELECTION = "selection";
    private static final String INSERTION = "insertion";
    private static final String MERGE = "merge";
    private static final String QUICK = "quick";
    private static final String SHELL = "shell";
    private static final String LINEAL = "lineal";
    private static final String BINARY = "binary";

    public static void main(String[] args) {
        //Default Vehicle Array
        SortController sortController = new SortController();
        SearchController searchController = new SearchController();
        VehicleInput vehicles = defaultOrCustomVehicleArray();
        Vehicle[] vehicleArray = vehicles.getVehicles().clone();

        int sortOrSearch = sortOrSearch();

        if (sortOrSearch == 0){
            sortVehicles(vehicleArray, sortController);
        }else {
            findVehicle(vehicleArray,searchController);
        }
    }

    public static VehicleInput defaultOrCustomVehicleArray(){
        String[] options = new String[]{"Arreglo por Defecto", "Arreglo personalizado"};
        int selectedOption = JOptionPane.showOptionDialog(null, "Selecciona una opción para comenzar: ", "Garaje NiiChan", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );
        if(selectedOption == 1){
            try {

                int spaces = Integer.parseInt(JOptionPane.showInputDialog(null, "numero de espacios para el garaje"));
                VehicleInput vehicleInput = new VehicleInput(spaces);
                fillVehicleArr(vehicleInput);

                return vehicleInput;

            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Espacios para garaje No validos");

            }
        }

        return new VehicleInput();
    }

    public static int sortOrSearch(){
        String[] options = new String[]{"Ordenar", "Buscar"};
        int selectedOption = JOptionPane.showOptionDialog(null, "Selecciona si quieres buscar u ordenar: ", "Garaje NiiChan", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );
        return selectedOption;
    }

    public static void findVehicle(Vehicle[] vehicles, SearchController controller){
        int typeSearch = selectSearchType();
        if(typeSearch == 1){
             String arg = selectArg();
             String vehicleAtt = JOptionPane.showInputDialog(null, "Ingrese "+ arg + " a buscar");
             JOptionPane.showMessageDialog(null, controller.linearSearch(vehicles, vehicleAtt, arg));
             return;
        }

        String method = selectSearchMethod();
        Vehicle vehicle = verifyVehicleInfo();
        String infoToShow = "";
        if (method.compareToIgnoreCase(LINEAL) == 0){
            infoToShow = controller.linearSearch(vehicles, vehicle);
        }else {
            infoToShow = controller.binarySearch(vehicles, vehicle, "placas");
        }

        JOptionPane.showMessageDialog(null,infoToShow);
    }

    public static void sortVehicles(Vehicle[] vehicles, SortController controller){
        String method = selectSortMethod();
        String arg = selectArg();
        JOptionPane.showMessageDialog(null,"Ordenados por "+ arg + "\n"  + controller.sort(vehicles, method,arg));
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

    public static void fillVehicleArr(VehicleInput vehicles){
        for(int i = 0; i < vehicles.getVehicles().length; i++){
           vehicles.addNewVehicle(verifyVehicleInfo(), i);
        }
    }

    public static Vehicle verifyVehicleInfo(){
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

                Vehicle myNewVehicle = createNewVehicle(vehicleType, plate,model,numDoors,numWheels,maxFuelCapacity);

                if(myNewVehicle == null) throw new IllegalArgumentException();

                isInfoRight = true;
                return myNewVehicle;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Datos ingresados, invalidos para la conversion... Intentelo de nuevo");
            }catch (IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Debes ingresar un tipo válido de vehiculo");
            }

        }while (!isInfoRight);

        return null;
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
