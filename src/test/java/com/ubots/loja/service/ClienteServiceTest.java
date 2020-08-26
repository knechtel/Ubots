package com.ubots.loja.service;

import com.ubots.loja.dto.ComprasDto;
import com.ubots.loja.service.ClienteService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {


    @InjectMocks
    private ClienteService clienteService;
    @Test
    void maiorTotalCompras() throws Exception {
        List<ComprasDto> list = clienteService.findClienteByMaiorTotalCompras();
        assert(list.size()>0);
    }
    @Test
    void maiorFidelidade() throws Exception {
        List<ComprasDto> list = clienteService.findClienteFiel();
        assert(list.size()>0);
    }
    @Test
    void findByYear() throws Exception {
        List<ComprasDto> list = clienteService.findClienteByYear();
        assert(list.size()>0);
    }

}
