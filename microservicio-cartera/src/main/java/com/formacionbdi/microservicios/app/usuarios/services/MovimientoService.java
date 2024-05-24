package com.formacionbdi.microservicios.app.usuarios.services;


import com.formacionbdi.microservicios.app.usuarios.dto.MovimientoDto;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Movimiento;
import com.prueba.her.commons.service.CommonService;

import java.awt.*;
import java.util.Date;

public interface MovimientoService extends CommonService<Movimiento> {

    Movimiento save(MovimientoDto movimDto);
    List findByFechaBetween(Date fechaIni, Date fechaFin );
}
