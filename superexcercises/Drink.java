package ProgrammingI.superexcercises;

public  abstract class Drink {
    private double volumeOz;
    private String drinkName;
    private boolean isSweet;
    private String container;
    public Drink(double volumeOz, String drinkName, boolean isSweet , String container){
        this.volumeOz = volumeOz;
        this.drinkName = drinkName;
        this.isSweet = isSweet;
        this.container = container;
        serveDrink();

    }

    public String getContainer() {
        return container;
    }

    public double getVolume(){ return this.volumeOz; }
    public String getName(){ return this.drinkName; }
    public boolean getIsSweet(){ return this.isSweet; }

    public void setVolumeOz(double Volume){ this.volumeOz = Volume; }
    public void setDrinkName(String Name){ this.drinkName = Name; }
    public void setIsSweet( boolean IsSweet ){ this.isSweet = IsSweet; }

    public void setContainer(String container) {
        this.container = container;
    }

    public  abstract void serveDrink();

    public void toDrink( double volume){
        if((this.volumeOz - volume) >= 0){
            this.volumeOz -= volume;
        }
    }

    public void toRefill( double volume){
        this.volumeOz += volume;
    }
}
