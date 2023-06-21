package com.etiya.ecommercedemo5.core.util.exceptions;

//İş kuralları valid olmadığında fırlatılacak exceptionun classı
public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
