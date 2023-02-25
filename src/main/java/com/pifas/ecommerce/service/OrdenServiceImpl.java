package com.pifas.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pifas.ecommerce.model.Orden;
import com.pifas.ecommerce.repository.IOrdenRepository;

public class OrdenServiceImpl implements IOrdenService {

	@Autowired
	private IOrdenRepository ordenRepository;
	
	@Override
	public Orden save(Orden orden) {		
		return ordenRepository.save(orden);
	}

}
