package com.formacionbdi.microservicios.app.usuarios.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cuenta")
@Data
public class Cuenta {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cuenta_id")
	private Long cuentaId;
	private String numero;
	private String tipo;
	private BigDecimal saldoInicial;
	private String estado;
	private Long clienteId;
//	@OneToMany
//	@JoinColumn(name = "id")
//	private List<Movimiento> movimientoList;
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

}
