package com.formacionbdi.microservicios.app.usuarios.controllers;

import com.formacionbdi.microservicios.app.usuarios.dto.MovimientoDto;
import com.formacionbdi.microservicios.app.usuarios.dto.ReporteRequest;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Movimiento;
import com.formacionbdi.microservicios.app.usuarios.services.MovimientoService;
import com.prueba.her.commons.controller.CommonController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController extends CommonController<Movimiento, MovimientoService>{

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody MovimientoDto dto) {
        Movimiento entityDb = this.service.save(dto);
        if( entityDb == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Saldo no disponible");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }

    @GetMapping("/reportes")
    public ResponseEntity<?> getByFecha( @RequestParam("fechaIni") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaIni,
                                         @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        List repuesta = service.findByFechaBetween(fechaIni, fechaFin);
         return ResponseEntity.status(HttpStatus.OK).body(repuesta);
    }





}
