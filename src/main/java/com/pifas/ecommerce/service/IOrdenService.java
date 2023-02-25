package com.pifas.ecommerce.service;

import java.util.List;

import com.pifas.ecommerce.model.Orden;

public interface IOrdenService {

	List<Orden> finAll();
	
	Orden save (Orden orden);
	
}
