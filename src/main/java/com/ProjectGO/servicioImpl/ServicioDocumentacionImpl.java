package com.ProjectGO.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectGO.modelo.DocumentacionVO;
import com.ProjectGO.repositorio.DocumentacionRepositorio;
import com.ProjectGO.servicio.ServicioDocumentacion;

@Service
public class ServicioDocumentacionImpl implements ServicioDocumentacion {

	@Autowired
	DocumentacionRepositorio dr;

	@Override
	public <S extends DocumentacionVO> S save(S entity) {
		return dr.save(entity);
	}

	@Override
	public <S extends DocumentacionVO> Iterable<S> saveAll(Iterable<S> entities) {
		return dr.saveAll(entities);
	}

	@Override
	public Optional<DocumentacionVO> findById(Integer id) {
		return dr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return dr.existsById(id);
	}

	@Override
	public Iterable<DocumentacionVO> findAll() {
		return dr.findAll();
	}

	@Override
	public Iterable<DocumentacionVO> findAllById(Iterable<Integer> ids) {
		return dr.findAllById(ids);
	}

	@Override
	public long count() {
		return dr.count();
	}

	@Override
	public void deleteById(Integer id) {
		dr.deleteById(id);
	}

	@Override
	public void delete(DocumentacionVO entity) {
		dr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends DocumentacionVO> entities) {
		dr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		dr.deleteAll();
	}
	
	
}
