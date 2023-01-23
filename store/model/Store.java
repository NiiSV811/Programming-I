package ProgrammingI.store.model;

public class Store {
    //Attributes
    private Product[] listProducts;
    private String productsToShow;

    public Store(){
        this.listProducts = new Product[10];
        this.productsToShow = "";
    }

    //Methods
    public void setProduct(int pos, String name, float[] itemNumValues){
        Product auxItem = new Product();
        auxItem.setName(name);
        auxItem.setBuyPrice(itemNumValues[0]);
        auxItem.setSellPrice(itemNumValues[1]);
        auxItem.setWeight(itemNumValues[2]);
        auxItem.setHeight(itemNumValues[3]);
        auxItem.setWidth(itemNumValues[4]);

        this.listProducts[pos] = auxItem;
    }

    public String getProductsToShow(){
        for(int i = 0; i < this.listProducts.length; i++){
            Product selectedItem = this.listProducts[i];
            this.productsToShow += "Product No. " + i+1 + " : " + selectedItem.getName() +
                    "  Buy Price: " + selectedItem.getBuyPrice()  + " $" +
                    "  Sell Price: " + selectedItem.getSellPrice()  + " $" +
                    "  Weight : " + selectedItem.getWeight() + " kg" +
                    "  Height : " + selectedItem.getHeight() + " m" +
                    "  Width: " + selectedItem.getWidth() + " m" + "\n";

        }

        return this.productsToShow;
    }
}
