package com.formacionbdi.microservicios.app.usuarios.services;


import com.formacionbdi.microservicios.app.usuarios.models.entity.Cuenta;
import com.prueba.her.commons.service.CommonService;


public interface CuentaService extends CommonService<Cuenta> {

    public Cuenta findByNumero(String numeroCuenta);


}
