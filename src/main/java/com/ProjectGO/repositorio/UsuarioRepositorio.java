package com.ProjectGO.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProjectGO.modelo.UsuarioVO;

@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioVO, Integer> {

	UsuarioVO findByUsuario(String usuario);
}
