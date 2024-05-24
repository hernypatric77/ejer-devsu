package com.formacionbdi.microservicios.app.usuarios.controllers;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Cuenta;
import com.formacionbdi.microservicios.app.usuarios.services.CuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.prueba.her.commons.controller.CommonController;

import java.util.Optional;

@RestController
@RequestMapping("/cuenta")
public class CuentaController extends CommonController<Cuenta, CuentaService>{



    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Cuenta cuenta, @PathVariable Long id){
        Optional<Cuenta> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Cuenta cuentaDb = o.get();
        cuentaDb.setClienteId(cuenta.getClienteId());
        cuentaDb.setEstado(cuenta.getEstado());
        cuentaDb.setSaldoInicial(cuenta.getSaldoInicial());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cuentaDb));
    }



}
