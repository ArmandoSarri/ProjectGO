package com.ProjectGO.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comentarios")
public class ComentarioVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private UsuarioVO usuario;

	private String contenido;

	public ComentarioVO(UsuarioVO usuario, String contenido) {
		super();
		this.usuario = usuario;
		this.contenido = contenido;
	}
	
	
}
