package com.ProjectGO.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProjectGO.modelo.UsuarioRolVO;
import com.ProjectGO.modelo.UsuarioVO;

@Repository
public interface UsuarioRolRepositorio extends CrudRepository<UsuarioRolVO, Integer> {

	List<UsuarioRolVO> findByUsuario(UsuarioVO usuario);
	
	void deleteByUsuario(UsuarioVO usuario);
}
