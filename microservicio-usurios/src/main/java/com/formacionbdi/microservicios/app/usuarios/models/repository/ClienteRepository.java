package com.formacionbdi.microservicios.app.usuarios.models.repository;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
