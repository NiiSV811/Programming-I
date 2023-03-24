package ProgrammingI.co.edu.uptc.workshop.vehicles.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    public String[][] dataVehicles(String path, int args) throws FileNotFoundException {

        File myFile = new File(path);
        Scanner reader = new Scanner(myFile);
        int size = this.countLines(path);

        String[][] result = new String[size][args];
        for(int i = 0; i < size; i++){
            result[i] = reader.nextLine().split(",");
        }
        return result;
    }

    public int countLines(String path) throws FileNotFoundException {
        int lines = 0;
        File myFile = new File(path);
        Scanner reader = new Scanner(myFile);

        while (reader.hasNext()){
            lines++;
            reader.nextLine();
        }

        return lines;
    }
}
