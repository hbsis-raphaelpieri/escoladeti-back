package br.com.time07.sevenfit.core.resultObject;

public abstract class Result {

    public Result(boolean sucess) {
        this.sucess = sucess;
    }

    private boolean sucess;

    public boolean isSucess() {
        return sucess;
    }
}
