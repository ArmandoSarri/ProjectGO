package com.ProjectGO.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProjectGO.servicio.ServicioUsuario;
import com.ProjectGO.servicio.ServicioUsuarioRol;

@Controller
public class AdminControlador {

	@Autowired
	ServicioUsuario su;	
	
	@Autowired
	ServicioUsuarioRol sur;
	
	@GetMapping("/eliminarusuario")
	@Transactional
	public String eliminarUsuario(@RequestParam int idusuario, Model modelo) {
		sur.deleteByUsuario(su.findById(idusuario).get());
		su.deleteById(idusuario);
		return "redirect:/index";
	}
}
