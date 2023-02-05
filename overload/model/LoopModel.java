package ProgrammingI.overload.model;

public class LoopModel {

    public LoopModel(){}

    public String forStringNumbers(){
        String concat = "";
        for(int i = 0; i <= 4; i++){
            concat += " , " + i;
        }
        concat = concat.replaceFirst(",", "");

        return concat;
    }

    public String forStringNumbers(int limit){
        String concat = "";
        for(int i = 0; i <= limit; i++){
            concat += " , " + i;
        }
        concat = concat.replaceFirst(",", "");

        return concat;
    }
}
