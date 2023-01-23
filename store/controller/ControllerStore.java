package ProgrammingI.store.controller;

import ProgrammingI.store.model.Store;

public class ControllerStore {
    private Store myStore;
    private String response;

    public ControllerStore(){
        this.myStore = new Store();
        this.response = "";
    }

    public String addItems(int pos, String[] itemValues){
        String auxName = itemValues[0];
        float[] numericValues = new float[5];

        if(auxName.equals(" ")){
            this.response = "Name is empty";
            return response;
        }
        try {
            for(int i = 0; i < numericValues.length; i++){
                numericValues[i] = Float.parseFloat(itemValues[i+1]);
            }

            myStore.setProduct(pos, auxName,numericValues);

        }catch (Exception e){
            this.response = "Invalid numeric values. Please Try Again";
            return response;
        }

        this.response = "";
        return response;
    }

    public String printItems(){
        this.response = this.myStore.getProductsToShow();
        return response;
    }
}
