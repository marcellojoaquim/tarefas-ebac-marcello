package com.vendas.online.exceptions;

public class DaoException extends Exception {
	
	private static final long serialVersionUID = -5934557631404701188L;

	public DaoException(String msg, Exception ex) {
		super(msg, ex);
	}

}
