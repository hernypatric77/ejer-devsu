package com.formacionbdi.microservicios.app.usuarios.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReporteRequest {
    private Date fechaIni;
    private Date fechaFin;
}
