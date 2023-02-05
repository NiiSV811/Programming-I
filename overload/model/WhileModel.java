package ProgrammingI.overload.model;

public class WhileModel {

    public WhileModel(){}

    public String whileStringNumbers(){
        String concat = "";
        int counter = 0;
        int limit = 4;

        while (counter <= limit){
            concat += " , " + counter;
            counter++;
        }
        concat = concat.replaceFirst("," , "");
        return concat;
    }

    public String whileStringNumbers(int limit){
        String concat = "";
        int counter = 0;

        while (counter <= limit){
            concat += " , " + counter;
            counter++;
        }
        concat = concat.replaceFirst("," , "");
        return concat;
    }
}
