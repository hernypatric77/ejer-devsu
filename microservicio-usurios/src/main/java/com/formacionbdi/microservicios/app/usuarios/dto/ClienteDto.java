package com.formacionbdi.microservicios.app.usuarios.dto;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Persona;
import lombok.Data;

import java.util.Date;
@Data
public class ClienteDto extends Persona {
    private String contrasenia;
    private String estado;

}
