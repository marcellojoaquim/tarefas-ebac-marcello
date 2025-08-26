package com.vendas.online.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String goToClientePage() {
		return "/cliente/list.xhtml"; 
	}
}
