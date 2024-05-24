package com.formacionbdi.microservicios.app.usuarios.models.repository;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Movimiento;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;
import java.util.Date;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

    List findByFechaBetween(Date fechaInicial, Date fechaFinal);
}
