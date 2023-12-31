package com.etiya.ecommercedemo5.core.util.results;

public class DataResult<T> extends Result{
    private T data;

    public DataResult(T data, boolean success, String message) {
        super(success, message);
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data=data;
    }
    public T getData(){
        return this.data;
    }

}
