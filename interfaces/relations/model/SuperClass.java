package ProgrammingI.interfaces.relations.model;

public class SuperClass implements BigInterface{


    @Override
    public Boolean isBiggerThan(Relationable n) {
        return false;
    }

    @Override
    public Boolean isEqualThan(Relationable n) {
        return true;
    }

    @Override
    public Boolean isMinorThan(Relationable n) {
        return false;
    }
}
