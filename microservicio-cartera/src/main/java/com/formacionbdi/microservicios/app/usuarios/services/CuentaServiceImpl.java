package com.formacionbdi.microservicios.app.usuarios.services;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Cuenta;
import com.formacionbdi.microservicios.app.usuarios.models.repository.CuentaRepository;
import com.prueba.her.commons.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Date;


@Service
public class CuentaServiceImpl extends CommonServiceImpl<Cuenta, CuentaRepository> implements CuentaService {


    @Override
    public Cuenta findByNumero(String numeroCuenta) {
        return repository.findByNumero(numeroCuenta);
    }


}
