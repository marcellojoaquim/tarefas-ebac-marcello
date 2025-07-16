package com.produtos.online.dao.exceptions;

public class NotFoundException extends Exception{

    public NotFoundException(String msg) {
        this(msg, null);
    }

    public  NotFoundException(String msg, Throwable e) {
        super(msg, e);
    }
}
