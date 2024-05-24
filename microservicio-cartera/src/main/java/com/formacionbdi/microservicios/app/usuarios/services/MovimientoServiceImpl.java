package com.formacionbdi.microservicios.app.usuarios.services;

import com.formacionbdi.microservicios.app.usuarios.dto.MovimientoDto;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Cuenta;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Movimiento;
import com.formacionbdi.microservicios.app.usuarios.models.repository.CuentaRepository;
import com.formacionbdi.microservicios.app.usuarios.models.repository.MovimientoRepository;
import com.prueba.her.commons.service.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Date;


@Service
public class MovimientoServiceImpl extends CommonServiceImpl<Movimiento, MovimientoRepository> implements MovimientoService {

    @Autowired
    CuentaService cuentaService;

    @Transactional
    public Movimiento save(MovimientoDto dto) {
        Cuenta cuenta = cuentaService.findByNumero(dto.getNumCuenta());
        BigDecimal saldo = BigDecimal.ZERO;
        if (dto.getTipoMovimiento().equalsIgnoreCase("RET") &&
        cuenta.getSaldoInicial().compareTo(dto.getValor()) < 0 ) {
            return null;
        } else if (dto.getTipoMovimiento().equalsIgnoreCase("RET") &&
                cuenta.getSaldoInicial().compareTo(dto.getValor()) >0 ) {
            saldo = cuenta.getSaldoInicial().add(dto.getValor().negate());
        } else if (dto.getTipoMovimiento().equalsIgnoreCase("DEP")) {
            saldo = cuenta.getSaldoInicial().add(dto.getValor());
        }

        cuenta.setSaldoInicial(saldo);
        cuentaService.save(cuenta);
        Movimiento mov = new Movimiento();
        mov.setCuenta(cuenta);
        mov.setFecha(new Date());
        mov.setSaldo(saldo);
        mov.setTipoMovimiento(dto.getTipoMovimiento());
        mov.setValor(dto.getValor());
        return this.repository.save(mov);
    }

    @Override
    public List findByFechaBetween(Date fechaIni, Date fechaFin) {
        return this.repository.findByFechaBetween(fechaIni, fechaFin);
    }
}
