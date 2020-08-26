package com.ubots.loja.service;

import com.ubots.loja.domain.Cliente;
import com.ubots.loja.dto.ComprasDto;
import com.ubots.loja.util.ApiCadastro;
import com.ubots.loja.util.FidelidadeComparator;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.util.*;

@Service
public class ClienteService {

    public List<ComprasDto> findClienteByMaiorTotalCompras() {
        List<ComprasDto> listCompra = null;
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/v2/598b16861100004905515ec7/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiCadastro api = retrofit.create(ApiCadastro.class);
            listCompra = api.getCompra().execute().body();
            Collections.sort(listCompra);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return listCompra;
    }

    public List<ComprasDto> findClienteFiel() {
        List<ComprasDto> listCompra = null;
        List<ComprasDto> listSortCompra = new ArrayList<>();
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/v2/598b16861100004905515ec7/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiCadastro api = retrofit.create(ApiCadastro.class);
            listCompra = api.getCompra().execute().body();
            Map<String, ComprasDto> mapCompras = new HashMap<>();
            for (ComprasDto comprasDto : listCompra) {
                if (mapCompras.containsKey(comprasDto.getCliente())) {
                    ComprasDto cAux = mapCompras.get(comprasDto.getCliente());
                    cAux.setContador(cAux.getContador() + 1);
                    mapCompras.put(comprasDto.getCliente(), cAux);
                } else {
                    comprasDto.setContador(comprasDto.getContador() + 1);
                    mapCompras.put(comprasDto.getCliente(), comprasDto);
                }
            }
            Set<String> chaves = mapCompras.keySet();
            for (String chave : chaves) {
                if (chave != null) {
                    System.out.println(chave + mapCompras.get(chave) + " " + mapCompras.get(chave).getContador());
                    listSortCompra.add(mapCompras.get(chave));
                }
            }
            Collections.sort(listSortCompra, new FidelidadeComparator());
            for (ComprasDto c : listSortCompra) {
                System.out.println(c.getContador() + " - " + c.getCliente());
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return listSortCompra;
    }


}
