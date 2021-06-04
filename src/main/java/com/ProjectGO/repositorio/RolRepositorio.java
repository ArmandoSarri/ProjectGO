package com.ProjectGO.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProjectGO.modelo.RolVO;

@Repository
public interface RolRepositorio extends CrudRepository<RolVO, Integer> {

}
