package com.ProjectGO.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectGO.modelo.ComentarioVO;
import com.ProjectGO.repositorio.ComentarioRepositorio;
import com.ProjectGO.servicio.ServicioComentario;

@Service
public class ServicioComentarioImpl implements ServicioComentario {

	@Autowired
	ComentarioRepositorio cr;

	@Override
	public <S extends ComentarioVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public <S extends ComentarioVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}

	@Override
	public Optional<ComentarioVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public Iterable<ComentarioVO> findAll() {
		return cr.findAll();
	}

	@Override
	public Iterable<ComentarioVO> findAllById(Iterable<Integer> ids) {
		return cr.findAllById(ids);
	}

	@Override
	public long count() {
		return cr.count();
	}

	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public void delete(ComentarioVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ComentarioVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}
	
	
}
