package com.ProjectGO.repositorio;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProjectGO.modelo.ComentarioVO;

@Repository
public interface ComentarioRepositorio extends CrudRepository<ComentarioVO, Integer> {
	
	ArrayList<ComentarioVO> findAllByOrderByIdDesc();

}
