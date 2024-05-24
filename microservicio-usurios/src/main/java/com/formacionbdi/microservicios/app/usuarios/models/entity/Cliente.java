package com.formacionbdi.microservicios.app.usuarios.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long clienteId;
	private String contrasenia;
	private String estado;
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@ManyToOne
	@JoinColumn(name = "id")
	private Persona persona;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

}
