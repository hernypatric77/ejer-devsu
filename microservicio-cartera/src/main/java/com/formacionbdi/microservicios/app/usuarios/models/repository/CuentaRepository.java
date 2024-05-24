package com.formacionbdi.microservicios.app.usuarios.models.repository;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;
import java.sql.Date;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

    Cuenta findByNumero(String numeroCuenta);

}
