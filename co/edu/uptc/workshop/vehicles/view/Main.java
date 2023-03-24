package ProgrammingI.co.edu.uptc.workshop.vehicles.view;

import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.GasolineCar;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.DiselVehicle;
import ProgrammingI.co.edu.uptc.workshop.vehicles.model.ElectricalVehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle normalCar = new GasolineCar("ABC 123", 15, 4, 4);
        System.out.println("-----------");
        Vehicle truck = new DiselVehicle("ACAJSH 23098", 100, 2, 8);
        System.out.println("-----------");
        Vehicle teslaModelN = new ElectricalVehicle("ZXC 355", 400, 2, 4);

        normalCar.moveDown(20);

    }
}
