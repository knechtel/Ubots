package com.ubots.loja.controller;
import com.ubots.loja.domain.Cliente;
import com.ubots.loja.dto.ClienteDto;
import com.ubots.loja.dto.ComprasDto;
import com.ubots.loja.service.ClienteService;
import com.ubots.loja.util.ApiCadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @RequestMapping(value = "/clienteByMaiorValorTotal",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<ComprasDto> clienteByMaiorValorTotal()  {
        return clienteService.findClienteByMaiorTotalCompras();
    }
    @RequestMapping(value = "/clienteByFidelidade",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<ComprasDto> clienteByFidelidade()  {
        return clienteService.findClienteFiel();
    }
    @RequestMapping(value = "/findByYear",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<ComprasDto> findByYear2016() {
        return clienteService.findClienteByYear();
    }
    @RequestMapping(value = "/clienteRecomendacao",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ClienteDto clienteRecomendacao(@RequestBody ClienteDto clienteDto) {
        return clienteService.geraRecomendacao(clienteDto);
    }

}
