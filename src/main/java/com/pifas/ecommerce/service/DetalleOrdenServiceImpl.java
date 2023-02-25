package com.pifas.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pifas.ecommerce.model.DetalleOrden;
import com.pifas.ecommerce.repository.IDetalleOrdenRepository;

public class DetalleOrdenServiceImpl implements IDetalleOrdenService {

	@Autowired
	private IDetalleOrdenRepository detalleOrdenRepository;

	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {

		return detalleOrdenRepository.save(detalleOrden);
	}

}