package ProgrammingI.managefiles.view;

import ProgrammingI.managefiles.controller.ControllerFile;

import javax.swing.*;

public class View {
    public static void main(String[] args) {
        ControllerFile myController = new ControllerFile();
        String url = "./src/ProgrammingI/managefiles/files/";
        String fileName = "";
        String msg = "";
        String lineAdd = "";
        String title = "CRID By Niichan";
        String[] options = new String[]{"1. Crear", "2. Leer", "3. Insertar", "4. Borrar", "5. Salir"};
        int optionSelected = 0;

        optionSelected = JOptionPane.showOptionDialog(null, "Selecciona una operación: ", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,0 );

        if(optionSelected == 4){
            return;
        }
        msg = myController.controlListFiles(url);
        fileName = JOptionPane.showInputDialog(null,  msg + "\nIngrese nombre del archivo -> \n");
        String path = url + fileName;

        switch (optionSelected){
            case 0 -> {
                msg = myController.controlCreateFile(path);
            }
            case 1 ->{
                msg = myController.controlReadFile(path);
                title = fileName;
            }
            case 2 ->{
                lineAdd = JOptionPane.showInputDialog(null, "Ingrese línea a agregar en : " + fileName);
                msg = myController.controlWriteFile(path, lineAdd);
            }
            case 3 ->{
                msg = myController.controlDeleteFile(path);
            }case 4 ->{
                msg = "Gracias por usar el CRID By Niichan";
            }

        }
            JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);


    }
}
