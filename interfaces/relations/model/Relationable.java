package ProgrammingI.interfaces.relations.model;

import java.util.SplittableRandom;

public interface Relationable {
    Boolean isBiggerThan(Relationable n);
    Boolean isEqualThan(Relationable n);
    Boolean  isMinorThan(Relationable n);

    default String getClassName(){
        String className = getClass().toString();
        int lastDot = className.lastIndexOf(".");
        return className.substring(lastDot+1) + getPrivateStrings();
    }

    static Boolean isNull(Relationable n){
        return n == null;
    }

    private String getPrivateStrings(){
        return "this is a private String";
    }

}
