package com.t1.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nro_prestamo;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private Integer id_usuario;
	private Integer id_libro;
	private Estado estado;
	
	public enum Estado {
		Emitido,
		Cancelado,
		Anulado
	}
}
