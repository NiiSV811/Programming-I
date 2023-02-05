package ProgrammingI.overload.controller;

import ProgrammingI.overload.model.DoWhileModel;
import ProgrammingI.overload.model.WhileModel;

public class CycleController {
    private WhileModel whileModel;
    private DoWhileModel doWhileModel;

    public CycleController(){
        this.doWhileModel = new DoWhileModel();
        this.whileModel = new WhileModel();
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
}
