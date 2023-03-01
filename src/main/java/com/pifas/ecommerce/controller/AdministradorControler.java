package com.pifas.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pifas.ecommerce.model.Producto;
import com.pifas.ecommerce.service.IUsuarioService;
import com.pifas.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/administrador")
public class AdministradorControler {
	
	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String home(Model model) {
		List<Producto> productos=productoService.findAll();
		model.addAttribute("productos",productos);
		return "administrador/home";
	}

	
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.findAll());
		
		return"administrador/usuarios";
	}
}
