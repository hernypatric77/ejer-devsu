package com.prueba.her.commons.controller;

import com.prueba.her.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CommonController<E, S extends CommonService<E>> {
    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<E> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());

    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody E entiry){
        E entiryDb = service.save(entiry);
        return ResponseEntity.status(HttpStatus.CREATED).body(entiryDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
