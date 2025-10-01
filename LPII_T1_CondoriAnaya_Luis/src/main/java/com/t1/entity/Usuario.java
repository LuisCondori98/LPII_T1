package com.t1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {

	@Id
	private Integer id_usuario;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String correo;
}
