package com.formacionbdi.microservicios.app.usuarios.models.entity;

import java.math.BigDecimal;
import java.util.Date;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movimiento")
@Data
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private String tipoMovimiento;
	private BigDecimal valor;
	private BigDecimal saldo;
	@ManyToOne
	@JoinColumn(name = "cuenta_id")
	private Cuenta cuenta;
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}


}
