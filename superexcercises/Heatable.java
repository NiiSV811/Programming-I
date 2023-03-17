package ProgrammingI.superexcercises;

public interface Heatable {
    int MIN_TEMP = 2;
    int MAX_TEMP = 60;

    void toHeat(int degrees);
    void toCool(int degrees);
}
