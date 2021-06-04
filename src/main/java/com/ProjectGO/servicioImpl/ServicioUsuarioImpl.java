package com.ProjectGO.servicioImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ProjectGO.modelo.UsuarioRolVO;
import com.ProjectGO.modelo.UsuarioVO;
import com.ProjectGO.repositorio.RolRepositorio;
import com.ProjectGO.repositorio.UsuarioRepositorio;
import com.ProjectGO.repositorio.UsuarioRolRepositorio;
import com.ProjectGO.servicio.ServicioUsuario;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario, UserDetailsService {

	@Autowired
	UsuarioRepositorio ur;
	
	@Autowired
	UsuarioRolRepositorio urr;
	
	@Autowired
	RolRepositorio rr;

	@Override
	public <S extends UsuarioVO> S save(S entity) {
		return ur.save(entity);
	}

	@Override
	public <S extends UsuarioVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ur.saveAll(entities);
	}

	@Override
	public Optional<UsuarioVO> findById(Integer id) {
		return ur.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ur.existsById(id);
	}

	@Override
	public Iterable<UsuarioVO> findAll() {
		return ur.findAll();
	}

	@Override
	public Iterable<UsuarioVO> findAllById(Iterable<Integer> ids) {
		return ur.findAllById(ids);
	}

	@Override
	public long count() {
		return ur.count();
	}

	@Override
	public void deleteById(Integer id) {
		ur.deleteById(id);
	}

	@Override
	public void delete(UsuarioVO entity) {
		ur.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends UsuarioVO> entities) {
		ur.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ur.deleteAll();
	}
	
	@Override
	public UsuarioVO findByUsuario(String usuario) {
		return ur.findByUsuario(usuario);
	}
	
	@Override
    public UserDetails loadUserByUsername(String username) {
		
		System.out.println(username);
		UsuarioVO usuario = ur.findByUsuario(username);

		System.out.println(usuario);
		
        if (usuario != null ) {

        	List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            
        	List<UsuarioRolVO> usuariosroles = urr.findByUsuario(usuario);
        	usuariosroles.forEach(x -> grantList.add(new SimpleGrantedAuthority(x.getRol().getNombre())));
            UserDetails user = new User(usuario.getUsuario(), usuario.getPassword(), grantList);

            return user;

        } else {
            throw new UsernameNotFoundException("Error");
        }
	}
}
