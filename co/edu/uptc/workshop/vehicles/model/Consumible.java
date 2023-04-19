package ProgrammingI.co.edu.uptc.workshop.vehicles.model;

public interface Consumible {
    double GASOLINE_AIR_PROPORTION = 0.04;
    double GASOLINE_PROPORTION = 0.03;
    double DISEL_PROPORTION = 0.05;
    double BATTERY_PROPORTION = 0.01;
    void toConsumeFuel(double fuel);
    void toRefillFuel();
}
