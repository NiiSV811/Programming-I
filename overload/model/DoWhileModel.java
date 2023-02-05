package ProgrammingI.overload.model;

public class DoWhileModel {

    public DoWhileModel(){}

    public String DoWhileStringNumbers(){
        String concat = "";
        int counter = 0;
        int limit = 4;

        do{
            concat += " , " + counter;
            counter++;
        }while (counter <= limit);

        concat = concat.replaceFirst(",", "");
        return concat;
    }

    public String DoWhileStringNumbers(int limit){
        String concat = "";
        int counter = 0;

        do{
            concat += " , " + counter;
            counter++;
        }while (counter <= limit);

        concat = concat.replaceFirst(",", "");
        return concat;
    }
}
