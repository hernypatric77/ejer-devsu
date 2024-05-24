package com.formacionbdi.microservicios.app.usuarios;


import com.formacionbdi.microservicios.app.usuarios.controllers.ClienteController;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Cliente;
import com.formacionbdi.microservicios.app.usuarios.services.ClienteService;
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

public class ClienteController_Test {

    @Mock
    private ClienteService service;
    @InjectMocks
    private ClienteController controller;

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testVer() {
        Long id = 2L;
        Cliente cliente = new Cliente();
        cliente.setClienteId(id);
        cliente.setContrasenia("admin123");
        cliente.setEstado("ACT");

        when(clienteService.findById(id)).thenReturn(Optional.of(cliente));

        ResponseEntity<?> responseEntity = clienteController.ver(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(cliente, responseEntity.getBody());

        verify(clienteService, times(1)).findById(id);
    }

    @Test
    public void testVerAlumnoNoEncontrado() {
        Long id = 1L;

        when(service.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<?> responseEntity = controller.ver(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        verify(service, times(1)).findById(id);
    }

}