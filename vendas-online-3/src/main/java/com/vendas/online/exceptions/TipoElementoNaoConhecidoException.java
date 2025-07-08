package com.vendas.online.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {
    private static final long serialVersionUID = -2268140970978666251L;

    public TipoElementoNaoConhecidoException(String message) {
        this(message, null);
    }
    public TipoElementoNaoConhecidoException(String message, Throwable e) {
        super(message, e);
    }
}
