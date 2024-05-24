package com.formacionbdi.microservicios.app.usuarios.controllers;

import com.formacionbdi.microservicios.app.usuarios.dto.ClienteDto;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Cliente;
import com.formacionbdi.microservicios.app.usuarios.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.prueba.her.commons.controller.CommonController;

import java.util.Collections;
import java.util.Optional;

@RestController
public class ClienteController extends CommonController<Cliente, ClienteService>{

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ClienteDto dto) {
        Cliente entiryDb = this.service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(entiryDb);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok().body(this.service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Cliente cliente, @PathVariable Long id){
         Optional<Cliente> o = service.findById(id);
        if (o.map(Collections::singleton).orElse(Collections.emptySet()).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Cliente clienteDb = o.get();
        clienteDb.setContrasenia(cliente.getContrasenia());
        clienteDb.setEstado(cliente.getEstado());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteDb));
    }


}
