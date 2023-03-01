package com.pifas.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pifas.ecommerce.model.Orden;
import com.pifas.ecommerce.model.Producto;
import com.pifas.ecommerce.service.IOrdenService;
import com.pifas.ecommerce.service.IUsuarioService;
import com.pifas.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/administrador")
public class AdministradorControler {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IOrdenService ordenService;

	@Autowired
	private ProductoService productoService;

	private final Logger logg = LoggerFactory.getLogger(AdministradorControler.class);

	
	@GetMapping("")
	public String home(Model model) {
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos", productos);
		return "administrador/home";
	}

	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.findAll());
		return "administrador/usuarios";
	}

	@GetMapping("/ordenes")
	public String ordenes(Model model) {
		model.addAttribute("ordenes", ordenService.finAll());
		return "administrador/ordenes";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable Integer id) {
		logg.info("Id de la orden:{}", id);
		Orden orden = ordenService.findById(id).get();
		model.addAttribute("detalles", orden.getDetalle());
		return"administrador/detalleorden";
	}
}
