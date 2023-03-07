package ProgrammingI.interfaces.relations.model;

public class Line  implements Relationable , Comparable<Line> , Nameable{
    //attributes
    private int[] initCors;
    private int[] finalCors;
    //Constructors
    public Line(int[] initCors, int[] finalCors){
        this.initCors = initCors;
        this.finalCors = finalCors;
    }

    public Line(int[] finalCors){
        this.initCors = new int[]{0,0};
        this.finalCors = finalCors;
    }

    public int[] getInitCors() {
        return initCors;
    }

    public int[] getFinalCors() {
        return finalCors;
    }

    public void setInitCors(int[] initCors) {
        this.initCors = initCors;
    }

    public void setFinalCors(int[] finalCors) {
        this.finalCors = finalCors;
    }

    //Own Methods

    public double distance(){
        int xComponent = this.finalCors[0] - this.initCors[0];
        int yComponent = this.finalCors[1] - this.initCors[1];
        return Math.sqrt((xComponent * xComponent) + (yComponent * yComponent));
    }

    //Implements methods
    @Override
    public String toString(){
        return "(" + this.initCors[0] + " , " +this.initCors[1] + " ) ----------- (" + this.finalCors[0] + " , " + this.finalCors[1] + ")";
    }
    @Override
    public Boolean isBiggerThan(Relationable l){
       if(l == null){
           return false;
       }
       if(!(l instanceof Line)){
           return false;
       }
       return this.distance() > ((Line) l).distance();
    }

    @Override
    public Boolean isEqualThan(Relationable l){
        if(l == null){
            return false;
        }
        if(!(l instanceof Line)){
            return false;
        }
        return this.distance() == ((Line) l).distance();
    }

    @Override
    public Boolean isMinorThan(Relationable l){
        if(l == null){
            return false;
        }
        if(!(l instanceof Line)){
            return false;
        }
        return this.distance() < ((Line) l).distance();
    }

    @Override
    public int compareTo(Line l){
        return this.isMinorThan(l) ? -1 : this.isEqualThan(l) ? 0 : 1;
    }

    @Override //We can override default methods to specific behaviours
    public String getClassName(){
        return "Lineas xD";
    }
}
