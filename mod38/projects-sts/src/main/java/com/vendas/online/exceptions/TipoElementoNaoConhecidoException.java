package com.vendas.online.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {
	
	private static final long serialVersionUID = 581446109921530757L;

	private TipoElementoNaoConhecidoException(String msg) {
		this(msg, null);
	}
	
	private TipoElementoNaoConhecidoException(String msg, Throwable e) {
		super(msg, e);
	}

}
