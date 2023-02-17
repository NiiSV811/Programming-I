package ProgrammingI.mathutil.view;

import ProgrammingI.mathutil.controller.FileNumController;

import javax.swing.*;
import java.io.FileNotFoundException;

public class FileView {
    public static void main(String[] args) {
        FileManager files = new FileManager();
        FileNumController controller = new FileNumController();
        String url = "./src/ProgrammingI/mathutil/files/";
        String fileName = "";
        String path = "";
        String inputFromFile = "";
        String result = "";

        fileName = JOptionPane.showInputDialog(null, files.listFiles(url));
        path = url+fileName;
        try {
            inputFromFile = files.readFile(path);
        }catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Archivo no encontrado, intentelo una vez más.");
            return;
        }

        JOptionPane.showMessageDialog(null, controller.getTheBigger(inputFromFile));
        JOptionPane.showMessageDialog(null, controller.getTheMinor(inputFromFile));

    }
}
