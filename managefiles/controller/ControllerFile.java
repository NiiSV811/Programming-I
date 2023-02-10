package ProgrammingI.managefiles.controller;

import ProgrammingI.managefiles.model.ReadWrite;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ControllerFile {
    private ReadWrite readerWriter;
    public ControllerFile(){
        this.readerWriter = new ReadWrite();
    }

    public String controlReadFile(String url){
        try {
            return this.readerWriter.readFile(url);
        }catch (FileNotFoundException e){
            return "El archivo no ha sido encontrado";
        }
    }

    public String controlCreateFile(String url){
        String response = "";
        boolean result = false;
        try {
            result = this.readerWriter.createFile(url);
            if(result){
                response = "Archivo creado con exito";
            }else {
                response = "El archivo ya existe";
            }
        }catch (Exception e){
            return  "Ha ocurrido un error al crear el archivo";
        }

        return response;
    }

    public  String controlDeleteFile(String url){
        return this.readerWriter.deleteFile(url);
    }

    public  String controlWriteFile(String url, String line){
        try {
            this.readerWriter.writeFile(url, line);
            return "Se han escrito correctamente";
        }catch (IOException e){
            return "Ha ocurrido un error al escribir";
        }catch (NullPointerException e){
            return "Ha creado un archivo vacío";
        }
    }

    public String controlListFiles(String url){
        return this.readerWriter.listFiles(url);
    }
}
