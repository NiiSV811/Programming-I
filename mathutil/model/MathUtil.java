package ProgrammingI.mathutil.model;

public class MathUtil {
    private int[] numArray;
    private int iterator;
    private int arrSize;
    public MathUtil(int size){
        this.arrSize = size;
        this.numArray = new int[this.arrSize];
        this.iterator = 0;
    }

    public int[] getNumArray(){return  this.numArray;}
    public int getIterator(){return this.iterator;}
    public int addBiggerToNumArray(int num1, int num2){
        int pushValue = this.BiggerThan(num1, num2);
        this.numArray[iterator] = pushValue;
        this.iterator++;
        return pushValue;
    }

    public int biggestNumArray(){
       int theBigger = 0;
        for(int i = 0; i < this.iterator; i++){
           theBigger = this.BiggerThan(this.numArray[i], theBigger);
       }
        return theBigger;
    }

    public int theMinorNumArray(){
        int theMinor = this.numArray[0];
        for(int i = 0; i < this.iterator; i++){
            theMinor = this.LessThan(this.numArray[i], theMinor);
        }
        return theMinor;
    }

    private int BiggerThan(int num1, int num2){
        return num1 > num2? num1 : num2;
    }

    private int LessThan(int num1, int num2){
        return num1 < num2? num1: num2;
    }
}
