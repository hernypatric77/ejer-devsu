package com.formacionbdi.microservicios.app.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDto {
    private String nombre;
    private String direccion;
    private String telefono;
    private String contraenia;
    private String estado;


}
