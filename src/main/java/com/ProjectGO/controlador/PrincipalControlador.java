package com.ProjectGO.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ProjectGO.modelo.UsuarioRolVO;
import com.ProjectGO.modelo.UsuarioVO;
import com.ProjectGO.servicio.ServicioRol;
import com.ProjectGO.servicio.ServicioUsuario;
import com.ProjectGO.servicio.ServicioUsuarioRol;

@Controller
public class PrincipalControlador {

	@Autowired
	private ServicioUsuario su;
	
	@Autowired
	private ServicioUsuarioRol sur;
	
	@Autowired
	private ServicioRol sr;
	
	@Autowired
	private BCryptPasswordEncoder encriptador;
	

	@GetMapping("/index")
    public String index(Authentication authentication, Model model) {

        if (authentication != null && authentication.isAuthenticated()) {
        	
        	UsuarioVO usuario =  su.findByUsuario(authentication.getName());
        	
            model.addAttribute("usuario", usuario);
            
            List<UsuarioRolVO> usuariosroles = sur.findByUsuario(usuario);
            
            Boolean isAdmin = usuariosroles.stream().anyMatch(x->x.getRol().getIdrol() == 2);
            
            model.addAttribute("nombreUsuario", authentication.getName());
            
            model.addAttribute("autentificado", 1);
            
            if(isAdmin) {

        		model.addAttribute("admin", "true");
        		
            	return "index";
            }
            else {
            	return "index";
            }
        }
        else {
        	model.addAttribute("nombreUsuario", " ");
        	model.addAttribute("autentificado", 0);
        	return "index";
        }

    }

	@GetMapping("/")
	public String barra() {
		return "redirect:/index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registro")
	public String registro() {
		return "registro";
	}
	
	@PostMapping("/submit")
	public String insertarUsuario(@ModelAttribute UsuarioVO usuario, Model modelo) {
		
		if(su.findByUsuario(usuario.getUsuario()) == null) {	
			
			transformarUsuario(usuario);
			su.save(usuario);
			sur.save(new UsuarioRolVO(usuario, sr.findById(1).get()));
			return "redirect:/index";
			
		}else {
			return "redirect:/registro?error=Este usuario ya existe";
		}
		
	}
	
	private void transformarUsuario(UsuarioVO usuario) {
		
		usuario.setPassword(encriptador.encode(usuario.getPassword()));
	}
	
	@GetMapping("/guia")
	public String guia(Authentication authentication, Model model) {
		
		if (authentication != null && authentication.isAuthenticated()) {
        	
        	UsuarioVO usuario =  su.findByUsuario(authentication.getName());
        	
            model.addAttribute("usuario", usuario);
            
            List<UsuarioRolVO> usuariosroles = sur.findByUsuario(usuario);
            
            Boolean isAdmin = usuariosroles.stream().anyMatch(x->x.getRol().getIdrol() == 2);
            
            model.addAttribute("nombreUsuario", authentication.getName());
            
            model.addAttribute("autentificado", 1);
            
            if(isAdmin) {

        		model.addAttribute("admin", "true");
        		
            	return "guia";
            }
            else {
            	return "guia";
            }
        }
        else {
        	model.addAttribute("nombreUsuario", " ");
        	model.addAttribute("autentificado", 0);
        	return "guia";
        }
	}
	
	@GetMapping("/documentacion")
	public String documentacion(Authentication authentication, Model model) {
		
		if (authentication != null && authentication.isAuthenticated()) {
        	
        	UsuarioVO usuario =  su.findByUsuario(authentication.getName());
        	
            model.addAttribute("usuario", usuario);
            
            List<UsuarioRolVO> usuariosroles = sur.findByUsuario(usuario);
            
            Boolean isAdmin = usuariosroles.stream().anyMatch(x->x.getRol().getIdrol() == 2);
            
            model.addAttribute("nombreUsuario", authentication.getName());
            
            model.addAttribute("autentificado", 1);
            
            if(isAdmin) {

        		model.addAttribute("admin", "true");
        		
            	return "documentacion";
            }
            else {
            	return "documentacion";
            }
        }
        else {
        	model.addAttribute("nombreUsuario", " ");
        	model.addAttribute("autentificado", 0);
        	return "documentacion";
        }
	}
	
	@GetMapping("/ejemplos")
	public String ejemplos(Authentication authentication, Model model) {
		
		if (authentication != null && authentication.isAuthenticated()) {
        	
        	UsuarioVO usuario =  su.findByUsuario(authentication.getName());
        	
            model.addAttribute("usuario", usuario);
            
            List<UsuarioRolVO> usuariosroles = sur.findByUsuario(usuario);
            
            Boolean isAdmin = usuariosroles.stream().anyMatch(x->x.getRol().getIdrol() == 2);
            
            model.addAttribute("nombreUsuario", authentication.getName());
            
            model.addAttribute("autentificado", 1);
            
            if(isAdmin) {

        		model.addAttribute("admin", "true");
        		
            	return "ejemplos";
            }
            else {
            	return "ejemplos";
            }
        }
        else {
        	model.addAttribute("nombreUsuario", " ");
        	model.addAttribute("autentificado", 0);
        	return "ejemplos";
        }
	}
	
	@GetMapping("/informacion")
	public String informacion(Authentication authentication, Model model) {
		
		if (authentication != null && authentication.isAuthenticated()) {
        	
        	UsuarioVO usuario =  su.findByUsuario(authentication.getName());
        	
            model.addAttribute("usuario", usuario);
            
            List<UsuarioRolVO> usuariosroles = sur.findByUsuario(usuario);
            
            Boolean isAdmin = usuariosroles.stream().anyMatch(x->x.getRol().getIdrol() == 2);
            
            model.addAttribute("nombreUsuario", authentication.getName());
            
            model.addAttribute("autentificado", 1);
            
            if(isAdmin) {

        		model.addAttribute("admin", "true");
        		
            	return "informacion";
            }
            else {
            	return "informacion";
            }
        }
        else {
        	model.addAttribute("nombreUsuario", " ");
        	model.addAttribute("autentificado", 0);
        	return "informacion";
        }
	}
	

	@GetMapping("/perfil")
	public String perfil(Authentication authentication, Model model) {
			
		UsuarioVO usuario =  su.findByUsuario(authentication.getName());
    	
        model.addAttribute("usuario", usuario);
        
        List<UsuarioRolVO> usuariosroles = sur.findByUsuario(usuario);
        
        Boolean isAdmin = usuariosroles.stream().anyMatch(x->x.getRol().getIdrol() == 2);
        
        model.addAttribute("nombreUsuario", authentication.getName());
        
        model.addAttribute("autentificado", 1);
        
        if(isAdmin) {

    		model.addAttribute("admin", "true");
    		
        	return "perfil";
        }
        else {
        	return "perfil";
        }
	}
	
	@GetMapping("/administrar")
	public String administrar(Authentication authentication, Model model) {
		
		model.addAttribute("usuarios", su.findAll());
		
		UsuarioVO usuario =  su.findByUsuario(authentication.getName());
    	
        model.addAttribute("usuario", usuario);
        
        List<UsuarioRolVO> usuariosroles = sur.findByUsuario(usuario);
        
        Boolean isAdmin = usuariosroles.stream().anyMatch(x->x.getRol().getIdrol() == 2);
        
        model.addAttribute("nombreUsuario", authentication.getName());
        
        model.addAttribute("autentificado", 1);
        
        if(isAdmin) {

    		model.addAttribute("admin", "true");
    		
        	return "admin";
        }
        else {
        	return "admin";
        }
	}
	
	@RequestMapping("/cambiarImagen")
    public String actualizarImagen(@RequestParam("imagen") MultipartFile image, Authentication authentication, Model model) {

        UsuarioVO usuario = su.findByUsuario(authentication.getName());

        if (!image.isEmpty()) {

            try {
                //lo maximo que deja mysql por defecto son 4MB, el maximo que dejamos en el servidor
                //tanto como de subida de archivos como de request son 3MB por si acaso
                usuario.setImagen(Base64.getEncoder().encodeToString(image.getBytes()));

            } catch (IOException e) {
                e.printStackTrace();

            }

        } else {
            usuario.setImagen(null);
        }

        su.save(usuario);

        return "redirect:/perfil";
    }
	
	@RequestMapping("/{nombre}/imagen")
    public void getImagenAsBase64(@PathVariable("nombre") String nombre, HttpServletResponse response,HttpServletRequest request) 
              throws ServletException, IOException{

        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");

        UsuarioVO usuario = su.findByUsuario(nombre);

        if (usuario.getImagen() != null) {

            response.getOutputStream().write(Base64.getDecoder().decode(usuario.getImagen()));

        } else {
        	ClassPathResource resource = new ClassPathResource("/static/Imagenes/usuario.png");
            response.getOutputStream().write(Files.readAllBytes(resource.getFile().toPath()));
        }

        response.getOutputStream().close();

    }
	
	@GetMapping("/clicklogo")
	public String clicklogo() {
		return "redirect:/index";
	}

}
