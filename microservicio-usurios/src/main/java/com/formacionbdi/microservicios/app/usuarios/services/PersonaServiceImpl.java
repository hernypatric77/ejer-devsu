package com.formacionbdi.microservicios.app.usuarios.services;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Persona;
import com.formacionbdi.microservicios.app.usuarios.models.repository.PersonaRepository;
import com.prueba.her.commons.service.CommonServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl extends CommonServiceImpl<Persona, PersonaRepository> implements PersonaService {

}
