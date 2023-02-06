package ProgrammingI.overload.model;

public class Recursion {
    public Recursion(){}

    public String recursionStringNumbers(int limit){
        if(limit <= 0){
            return "0";
        }else{
         String result = this.recursionStringNumbers(limit - 1);
         result += ", " + limit;
         return result;
        }
    }

    public String recursionStringNumbers(int floorLimit, int topLimit){
        if(topLimit <= floorLimit){
            return String.valueOf(floorLimit);
        }else {
            String result = this.recursionStringNumbers(floorLimit, topLimit-1);
            result += " , " + topLimit;
            return result;
        }
    }
}
