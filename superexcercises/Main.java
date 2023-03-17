package ProgrammingI.superexcercises;

public class Main {
    public static void main(String[] args) {
        Tea myTea = new Tea(10.2, "Matcha Tea", false, 10, true, "Glass");
        //super methods
        myTea.toDrink(2);
        myTea.toRefill(8);

        //Interfaces
        myTea.addAComponent("matcha tea");
        myTea.toMix();
        myTea.toHeat(20);
        myTea.toCool(2);
    }
}
