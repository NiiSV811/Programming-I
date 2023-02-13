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

    public int getIterator(){return this.iterator;}
    public void addNumToNumArray(int num){
        this.numArray[iterator] = num;
        this.iterator++;
    }

    public int biggestNumArray(){
       int theBigger = 0;
        for(int i = 0; i < this.iterator; i++){
           theBigger = this.BiggerThan(this.numArray[i], theBigger);
       }
        return theBigger;
    }

    public int theMinorNumArray(){
        int theMinor = 0;
        for(int i = 0; i < this.iterator; i++){
            theMinor = this.LessThan(this.numArray[i], theMinor);
        }
        return theMinor;
    }

    public int BiggerThan(int num1, int num2){
        return num1 > num2? num1 : num2;
    }

    public int LessThan(int num1, int num2){
        return num1 < num2? num1: num2;
    }
}
