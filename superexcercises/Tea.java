package ProgrammingI.superexcercises;

public class Tea  extends Drink implements Heatable, Mixable{
    private double gramsTea;
    private boolean isHeat;
    private String container;
    private double temperature;

    public Tea(double volumeOz, String drinkName, boolean isSweet, double gramsTea, boolean isHeat,String container ){
        super(volumeOz, "Tea", isSweet, container);
        this.gramsTea = gramsTea;
        this.isHeat = isHeat;

    }

    public double getGramsTea() {
        return gramsTea;
    }

    public boolean isHeat() {
        return isHeat;
    }


    public double getTemperature() {
        return temperature;
    }

    public void setGramsTea(double gramsTea) {
        this.gramsTea = gramsTea;
    }

    public void setHeat(boolean heat) {
        isHeat = heat;
    }


    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void serveDrink() {
        System.out.println("Serving Tea on " + this.getContainer() + " for you!");
    }

    @Override
    public void toHeat(int degrees) {
        if((this.temperature + degrees) < MAX_TEMP){
            this.temperature += degrees;
        }
    }

    @Override
    public void toCool(int degrees) {
        if((this.temperature - degrees) > MIN_TEMP){
            this.temperature -= degrees;
        }
    }

    @Override
    public void addAComponent(String component) {
        System.out.println("Adding your Tea some " + component );
    }

    @Override
    public void toMix() {
        System.out.println("Mixing your tea to taste better!");
    }
}
