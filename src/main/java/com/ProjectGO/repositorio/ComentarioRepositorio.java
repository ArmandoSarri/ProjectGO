package com.ProjectGO.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProjectGO.modelo.ComentarioVO;

@Repository
public interface ComentarioRepositorio extends CrudRepository<ComentarioVO, Integer> {

}
