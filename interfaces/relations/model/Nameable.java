package ProgrammingI.interfaces.relations.model;

public interface Nameable {
    default String getClassName(){
        return "Objeto Nombrable";
    }

    static Boolean isNull(Nameable n){
        return false;
    }
}
