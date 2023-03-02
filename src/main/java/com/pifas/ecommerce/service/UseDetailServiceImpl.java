package com.pifas.ecommerce.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pifas.ecommerce.model.Usuario;

@Service
public class UseDetailServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Autowired
	HttpSession session;

	private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Este es el username");
		Optional<Usuario> OptionalUser = usuarioService.findByEmail(username);
		if (OptionalUser.isPresent()) {
			log.info("Este es el id del usuario:{}", OptionalUser.get().getId());
			session.setAttribute("idusuario", OptionalUser.get().getId());
			Usuario usuario = OptionalUser.get();
			return User.builder().username(usuario.getNombre()).password(bCrypt.encode(usuario.getPassword()))
					.roles(usuario.getTipo()).build();
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}

}
