package Programming1.store.model;

public class Product {
    //Attributes
    private String name;
    private float buyPrice;
    private float sellPrice;
    private float weight;
    private float height;
    private float width;

    public Product(){
        this.name = "";
        this.buyPrice = 0;
        this.sellPrice = 0;
        this.weight = 0;
        this.height = 0;
        this.width = 0;
    }
    //Setter & Getters
        //Set
    public void setName(String name){
        this.name = name;
    }
    public void setBuyPrice(float buyPrice){
        this.buyPrice = buyPrice;
    }
    public void setSellPrice(float sellPrice){
        this.sellPrice = sellPrice;
    }

    public void setWeight(float weight){
        this.weight = weight;
    }

    public void setHeight(float height){
        this.height = height;
    }
    public void setWidth(float width){
        this.width = width;
    }

    // Get

    public String getName(){
        return this.name;
    }
    public float getBuyPrice(){
        return this.buyPrice;
    }

    public float getSellPrice(){
        return this.sellPrice;
    }
    public float getWeight(){
        return this.weight;
    }
    public float getHeight(){
        return this.height;
    }
    public float getWidth(){
        return this.width;
    }
}
