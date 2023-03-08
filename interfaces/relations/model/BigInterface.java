package ProgrammingI.interfaces.relations.model;

public interface BigInterface extends Relationable, Nameable, Constants{
    @Override
    default String getClassName() {
        return Relationable.super.getClassName();
    }

    default String printPI(){
        return "pi = " + PI ;
    }
}
