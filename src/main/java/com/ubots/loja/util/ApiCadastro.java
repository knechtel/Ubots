package com.ubots.loja.util;

import com.ubots.loja.domain.Cliente;
import com.ubots.loja.dto.ComprasDto;


import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface ApiCadastro {
    @GET("http://www.mocky.io/v2/598b16291100004705515ec5")
    public Call<List<Cliente>> getCliente();

    @GET("http://www.mocky.io/v2/598b16861100004905515ec7")
    public Call<List<ComprasDto>> getCompra();
}
