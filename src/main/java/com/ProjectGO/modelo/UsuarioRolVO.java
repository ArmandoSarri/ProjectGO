package com.ProjectGO.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuariosroles")
public class UsuarioRolVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idur;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private UsuarioVO usuario;
	
	@ManyToOne
	@JoinColumn(name="idrol")
	private RolVO rol;

	public int getIdur() {
		return idur;
	}

	public void setIdur(int idur) {
		this.idur = idur;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public RolVO getRol() {
		return rol;
	}

	public void setRol(RolVO rol) {
		this.rol = rol;
	}

	public UsuarioRolVO(UsuarioVO usuario, RolVO rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public UsuarioRolVO(int idur, UsuarioVO usuario, RolVO rol) {
		super();
		this.idur = idur;
		this.usuario = usuario;
		this.rol = rol;
	}

	public UsuarioRolVO() {
		super();
	}
	
	
	
}
