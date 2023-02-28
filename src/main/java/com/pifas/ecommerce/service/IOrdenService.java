package com.pifas.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.pifas.ecommerce.model.Orden;
import com.pifas.ecommerce.model.Usuario;

public interface IOrdenService {

	List<Orden> finAll();
	
	Orden save (Orden orden);
	
	String generarNumeroOrden();
	
	List<Orden> findByUsuario(Usuario usuario);
	
	Optional<Orden> findById (Integer id);
}
