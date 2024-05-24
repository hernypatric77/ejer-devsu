package com.formacionbdi.microservicios.app.usuarios.dto;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Cuenta;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Movimiento;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MovimientoDto  {

    private String tipoMovimiento;
    private BigDecimal valor;
    private String numCuenta;

}
