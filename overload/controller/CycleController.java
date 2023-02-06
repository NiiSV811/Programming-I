package ProgrammingI.overload.controller;

import ProgrammingI.overload.model.DoWhileModel;
import ProgrammingI.overload.model.Recursion;
import ProgrammingI.overload.model.WhileModel;

public class CycleController {
    private WhileModel whileModel;
    private DoWhileModel doWhileModel;
    private Recursion myRecursion;

    public CycleController(){
        this.doWhileModel = new DoWhileModel();
        this.whileModel = new WhileModel();
        this.myRecursion = new Recursion();
    }

    public String whileStringNums(){
        return this.whileModel.whileStringNumbers();
    }
    public String whileStringNums(int limit){
        return this.whileModel.whileStringNumbers(limit);
    }

    public String doWhileStringNums(){
        return this.doWhileModel.DoWhileStringNumbers();
    }
    public String doWhileStringNums(int limit){
        return this.doWhileModel.DoWhileStringNumbers(limit);
    }

    public String recursionNumbers(int limit){ return this.myRecursion.recursionStringNumbers(limit);}
    public String recursionNumbers(int limit, int toplimit){return this.myRecursion.recursionStringNumbers(limit,toplimit);}
}
