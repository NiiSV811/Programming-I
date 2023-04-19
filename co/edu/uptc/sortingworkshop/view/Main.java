package ProgrammingI.co.edu.uptc.sortingworkshop.view;

import ProgrammingI.co.edu.uptc.sortingworkshop.controller.SortController;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //Default Vehicle Array
        SortController sortController = new SortController();
        VehicleInput vehicles = new VehicleInput();
        System.out.println(vehicles.toString());
        Vehicle[] vehiclesCopy = vehicles.getVehicles().clone();
        System.out.println(sortController.bubbleSort(vehiclesCopy, "combustible"));
        System.out.println(sortController.selectionSort(vehiclesCopy, "placas"));
        System.out.println(sortController.insertionSort(vehiclesCopy, "puertas"));
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

        String[] vehicleData = new String[6];
        for (int i = 0; i < vehicleData.length; i++){
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
