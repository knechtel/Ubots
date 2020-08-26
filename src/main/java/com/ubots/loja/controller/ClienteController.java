package com.ubots.loja.controller;
import com.ubots.loja.domain.Cliente;
import com.ubots.loja.dto.ComprasDto;
import com.ubots.loja.service.ClienteService;
import com.ubots.loja.util.ApiCadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping({"/api"})
    public String sayHello() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/598b16291100004705515ec5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCadastro api = retrofit.create(ApiCadastro.class);

        List<Cliente> list = api.getCliente().execute().body();
        System.out.println(list);
        return "hello";
    }

    @RequestMapping(value = "/clienteByMaiorValorTotal",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<ComprasDto> clienteByMaiorValorTotal() throws IOException {
        return clienteService.findClienteByMaiorTotalCompras();
    }
    @RequestMapping(value = "/clienteByFidelidade",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<ComprasDto> clienteByFidelidade() throws IOException {
        return clienteService.findClienteFiel();
    }
    @RequestMapping(value = "/findByYear",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<ComprasDto> findByYear2016() {
        return clienteService.findClienteByYear();
    }
}
