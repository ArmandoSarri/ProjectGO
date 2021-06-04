package com.ProjectGO.servicio;

import java.util.Optional;

import com.ProjectGO.modelo.DocumentacionVO;

public interface ServicioDocumentacion {

	<S extends DocumentacionVO> S save(S entity);

	<S extends DocumentacionVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<DocumentacionVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<DocumentacionVO> findAll();

	Iterable<DocumentacionVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(DocumentacionVO entity);

	void deleteAll(Iterable<? extends DocumentacionVO> entities);

	void deleteAll();

}