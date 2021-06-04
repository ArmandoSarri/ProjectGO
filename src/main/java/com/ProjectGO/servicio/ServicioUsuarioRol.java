package com.ProjectGO.servicio;

import java.util.List;
import java.util.Optional;

import com.ProjectGO.modelo.UsuarioRolVO;
import com.ProjectGO.modelo.UsuarioVO;

public interface ServicioUsuarioRol {

	<S extends UsuarioRolVO> S save(S entity);

	<S extends UsuarioRolVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuarioRolVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuarioRolVO> findAll();

	Iterable<UsuarioRolVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(UsuarioRolVO entity);

	void deleteAll(Iterable<? extends UsuarioRolVO> entities);

	void deleteAll();

	List<UsuarioRolVO> findByUsuario(UsuarioVO usuario);
	
	void deleteByUsuario(UsuarioVO usuario);
}