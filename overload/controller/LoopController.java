package ProgrammingI.overload.controller;

import ProgrammingI.overload.model.LoopModel;

public class LoopController {

    private LoopModel forModel;
    public LoopController(){
        this.forModel = new LoopModel();
    }

    public String forStringNums(){
        return this.forModel.forStringNumbers();
    }

    public String forStringNums(int limit){
        return this.forModel.forStringNumbers(limit);
    }
}
