package Programming1.store.model;

public class Store {
    //Attributes
    private Product[] listProducts;
    private String productsToShow;

    public Store(){
        this.listProducts = new Product[10];
        this.productsToShow = "";
    }

    //Methods
    public void setProduct(int pos, String name, float buyPrice, float sellPrice, float weight, float height, float width){
        Product auxItem = new Product();
        auxItem.setName(name);
        auxItem.setBuyPrice(buyPrice);
        auxItem.setSellPrice(sellPrice);
        auxItem.setWeight(weight);
        auxItem.setHeight(height);
        auxItem.setWidth(width);

        this.listProducts[pos] = auxItem;
    }

    public String getProductsToShow(){
        for(int i = 0; i < this.listProducts.length; i++){
            Product selectedItem = this.listProducts[i];
            this.productsToShow += "Producto No. " + i + " : " + selectedItem.getName() +
                    " Precio Compra: " + selectedItem.getBuyPrice()  + " $" +
                    " Precio Venta: " + selectedItem.getSellPrice()  + " $" +
                    " Peso : " + selectedItem.getWeight() + " kg" +
                    " Alto : " + selectedItem.getHeight() + " m" +
                    " Ancho: " + selectedItem.getWidth() + " m" + "\n";
        }

        return this.productsToShow;
    }
}
