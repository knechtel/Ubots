package com.ubots.loja.controller;

import com.ubots.loja.controller.ClienteController;
import com.ubots.loja.domain.Cliente;
import com.ubots.loja.dto.ComprasDto;
import com.ubots.loja.service.ClienteService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void doGetClienteByMaiorValorTotal() throws Exception {
        mockMvc.perform(get("/clienteByMaiorValorTotal")).andExpect(status().isOk());
    }
    @Test
    void doGetClienteByFidelidade() throws Exception {
        mockMvc.perform(get("/clienteByFidelidade")).andExpect(status().isOk());
    }
    @Test
    void doGetFindByYear() throws Exception {
        mockMvc.perform(get("/findByYear")).andExpect(status().isOk());
    }




}
