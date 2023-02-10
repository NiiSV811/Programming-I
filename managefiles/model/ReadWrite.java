package ProgrammingI.managefiles.model;
import java.util.*;
import java.io.*;
public class ReadWrite {
    public ReadWrite(){}

    public String readFile(String path) throws FileNotFoundException{
        String result = "";
        File myFile = new File(path);
        Scanner reader = new Scanner(myFile);
        while (reader.hasNext()){
            result += reader.nextLine() + "\n";
        }
        return result;
    }

    public boolean createFile(String url) throws Exception{
        boolean result = false;
        File myFile = new File(url);

        result = myFile.createNewFile();
        return result;
    }

    public String deleteFile(String url ){
        File myFile = new File(url);
        if(myFile.delete()){
            return "Archivo " + myFile.getName() + " ha sido borrado con éxito";
        }
        return "El archivo " + myFile.getName() + " No ha sido borrado";
    }

    public void writeFile(String url, String line) throws IOException{
        FileWriter writer = new FileWriter(url, true);
        writer.write("\n" + line);
        writer.close();
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
