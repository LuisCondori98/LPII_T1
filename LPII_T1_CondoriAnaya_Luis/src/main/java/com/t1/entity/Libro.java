package com.t1.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Libro {

	@Id
	private Integer id_libro;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String autor;
	private Date anio_pub;
}
