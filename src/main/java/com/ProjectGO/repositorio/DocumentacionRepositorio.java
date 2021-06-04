package com.ProjectGO.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProjectGO.modelo.DocumentacionVO;

@Repository
public interface DocumentacionRepositorio extends CrudRepository<DocumentacionVO, Integer> {

}
