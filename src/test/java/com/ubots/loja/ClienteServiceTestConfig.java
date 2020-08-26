package com.ubots.loja;

import com.ubots.loja.service.ClienteService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;




public class ClienteServiceTestConfig {

    public ClienteService clienteService() {
        return Mockito.mock(ClienteService.class);
    }
}
