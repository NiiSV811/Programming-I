package ProgrammingI.co.edu.uptc.workshop.vehicles.view;

import ProgrammingI.co.edu.uptc.workshop.vehicles.controller.InputController;
import ProgrammingI.co.edu.uptc.workshop.vehicles.exceptions.CarNotFound;
import ProgrammingI.co.edu.uptc.workshop.vehicles.exceptions.InvalidVehicleArg;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CarNotFound, InvalidVehicleArg, NullPointerException {
        InputController controller = new InputController();
        String url = "./src/ProgrammingI/co/edu/uptc/workshop/vehicles/data/";
        Reader myread = new Reader();
        Scanner inputLine = new Scanner(System.in);

        String inputGarage = "";
        String plate = "";
        String msg = "Ingrese acciones con el vehiculo\n" +
                "1. acelerar\n" +
                "2. frenar\n" +
                "3. mover Adelante\n" +
                "4. Reversa\n" +
                "5. Girar a la derecha\n" +
                "6. Girar a la izquierda\n" +
                "7. Apagar vehiculo\n";
        int option = 0;
        float arg = 0;

        try {
            System.out.println("Ingrese nombre de su garaje: ");
            inputGarage = inputLine.nextLine();
            url+=inputGarage+".txt";
            String[][] garage = myread.dataVehicles(url, 4);

            System.out.println("Ingrese placas del vehiculo: ");
            plate = inputLine.nextLine();
            Vehicle myCar = controller.selectVehicle(garage, plate);

            do{
                System.out.println(msg);
                option = inputLine.nextInt();
                if(option == 7) break;

                switch (option){
                    case 1 ->{
                        System.out.println("cuanto desea acelerar (m/s^2) ");
                        arg = inputLine.nextFloat();
                        myCar.toAcelerate(arg);
                    }
                    case 2 ->{
                        System.out.println("cuanto desea frenar (m/s^2) ");
                        arg = inputLine.nextFloat();
                        myCar.toBrake(arg);
                    }
                    case 3 ->{
                        System.out.println("cuanto desea avanzaar (m) ");
                        arg = inputLine.nextFloat();
                        myCar.moveForward(arg);
                    }
                    case 4 ->{
                        System.out.println("cuanto desea retrocedr (m) ");
                        arg = inputLine.nextFloat();
                        myCar.moveBackwarward(arg);
                    }
                    case 5 ->{
                        System.out.println("cuanto desea girar a la derecha (m) ");
                        arg = inputLine.nextFloat();
                        myCar.moveRight(arg);
                    }
                    case 6 ->{
                        System.out.println("cuanto desea girar a la izquierda (m) ");
                        arg = inputLine.nextFloat();
                        myCar.moveLeft(arg);
                    }
                }
            }while (true);

            myCar.toTurnOff();

        } catch (FileNotFoundException e) {
            System.out.println("Garaje no encontrado... Intente de nuevo");

        }


    }

}
