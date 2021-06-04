package com.ProjectGO.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectGO.modelo.UsuarioRolVO;
import com.ProjectGO.modelo.UsuarioVO;
import com.ProjectGO.repositorio.UsuarioRolRepositorio;
import com.ProjectGO.servicio.ServicioUsuarioRol;

@Service
public class ServicioUsuarioRolImpl implements ServicioUsuarioRol {

	@Autowired
	UsuarioRolRepositorio urr;

	@Override
	public <S extends UsuarioRolVO> S save(S entity) {
		return urr.save(entity);
	}

	@Override
	public <S extends UsuarioRolVO> Iterable<S> saveAll(Iterable<S> entities) {
		return urr.saveAll(entities);
	}

	@Override
	public Optional<UsuarioRolVO> findById(Integer id) {
		return urr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return urr.existsById(id);
	}

	@Override
	public Iterable<UsuarioRolVO> findAll() {
		return urr.findAll();
	}

	@Override
	public Iterable<UsuarioRolVO> findAllById(Iterable<Integer> ids) {
		return urr.findAllById(ids);
	}

	@Override
	public long count() {
		return urr.count();
	}

	@Override
	public void deleteById(Integer id) {
		urr.deleteById(id);
	}

	@Override
	public void delete(UsuarioRolVO entity) {
		urr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends UsuarioRolVO> entities) {
		urr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		urr.deleteAll();
	}
	
	@Override
	public List<UsuarioRolVO> findByUsuario(UsuarioVO usuario) {
		return urr.findByUsuario(usuario);
	}
	
	@Override
	public void deleteByUsuario(UsuarioVO usuario) {
		urr.deleteByUsuario(usuario);
	}
}
