package com.formacionbdi.microservicios.app.usuarios.services;


import com.formacionbdi.microservicios.app.usuarios.dto.ClienteDto;
import com.formacionbdi.microservicios.app.usuarios.dto.ClienteResponseDto;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Cliente;
import com.prueba.her.commons.service.CommonService;
import java.util.List;

public interface ClienteService extends CommonService<Cliente> {

    Cliente save(ClienteDto clienteDto);
    List<ClienteResponseDto> listar ();
}
