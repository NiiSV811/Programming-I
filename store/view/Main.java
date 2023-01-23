package ProgrammingI.store.view;

import ProgrammingI.store.controller.ControllerStore;

import javax.swing.*;

public class Main {
    private static ControllerStore controller;

    public static void main(String[] args) {
        controller = new ControllerStore();
        String status = "";
        String result = "";
        String auxSlot = "";
        String[] itemValues = new String[6];
        String[] askedValues = new String[]{"Name", "Buy Price" , "Sell Price", "Weight (in kg)", "Height (in meters) ", "Width (in meters)" };
        int items = 10;
        int counter = 0;

        while (counter < items){
            for(int  i = 0; i < 6; i++){
                auxSlot = JOptionPane.showInputDialog(null, "Enter the " + askedValues[i] + " of the product : ");
                itemValues[i] = auxSlot;
            }

            status = controller.addItems(counter, itemValues);

            if(status.equals("")){
                counter++;
            }else {
                JOptionPane.showMessageDialog(null, status);
            }
        }

        result = controller.printItems();
        JOptionPane.showMessageDialog(null, "Products in the Cart are: \n" + result);

    }
}
