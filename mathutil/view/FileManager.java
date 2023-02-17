package ProgrammingI.mathutil.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

    public FileManager(){}
    public String readFile(String path) throws FileNotFoundException {
        String result = "";
        File myFile = new File(path);
        Scanner reader = new Scanner(myFile);
        while (reader.hasNext()){
            result += reader.nextLine();
        }
        return result;
    }

    public String listFiles(String url){
        String listFiles = "";
        File myFile = new File(url);
        for(String fileNames : myFile.list()){
            listFiles += fileNames + "\n";
        }
        return listFiles;
    }
}
