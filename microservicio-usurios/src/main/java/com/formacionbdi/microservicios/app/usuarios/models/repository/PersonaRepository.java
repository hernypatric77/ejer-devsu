package com.formacionbdi.microservicios.app.usuarios.models.repository;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
