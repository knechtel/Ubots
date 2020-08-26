package com.ubots.loja;

import com.ubots.loja.service.ClienteService;
import org.mockito.Mockito;





public class ClienteServiceTestConfig {

    public ClienteService clienteService() {
        return Mockito.mock(ClienteService.class);
    }
}
