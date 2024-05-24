package com.formacionbdi.microservicios.app.usuarios;


import com.formacionbdi.microservicios.app.usuarios.controllers.CuentaController;
import com.formacionbdi.microservicios.app.usuarios.services.MovimientoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AlumnoController_Test {

    @Mock
    private MovimientoService service;
    @InjectMocks
    private CuentaController controller;

    @Mock
    private MovimientoService alumnoService;

    @InjectMocks
    private CuentaController alumnoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testVer() {
//        Long id = 2L;
//        Alumno alumno = new Alumno();
//        alumno.setId(id);
//        alumno.setNombre("Juan Jose");
//        alumno.setApellido("Lopez");
//        alumno.setEmail("prueba@mail.com");
//
//        when(alumnoService.findById(id)).thenReturn(Optional.of(alumno));
//
//        ResponseEntity<?> responseEntity = alumnoController.ver(id);
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(alumno, responseEntity.getBody());
//
//        verify(alumnoService, times(1)).findById(id);
//    }

    @Test
    public void testVerAlumnoNoEncontrado() {
        Long id = 1L;

        when(service.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<?> responseEntity = controller.ver(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        verify(service, times(1)).findById(id);
    }

}