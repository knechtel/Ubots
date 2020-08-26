package com.ubots.loja.service;

import com.ubots.loja.domain.Produto;
import com.ubots.loja.dto.ClienteDto;
import com.ubots.loja.dto.ComprasDto;
import com.ubots.loja.util.ApiCadastro;
import com.ubots.loja.util.FactoryRetrofit;
import com.ubots.loja.util.FidelidadeComparator;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;



import java.util.*;

@Service
public class ClienteService {

    public List<ComprasDto> findClienteByMaiorTotalCompras() {
        List<ComprasDto> listCompra = null;
        try {
            Retrofit retrofit = FactoryRetrofit.getRetroFit();
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
            Retrofit retrofit = FactoryRetrofit.getRetroFit();
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
                    listSortCompra.add(mapCompras.get(chave));
                }
            }
            Collections.sort(listSortCompra, new FidelidadeComparator());


        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return listSortCompra;
    }


    public List<ComprasDto> findClienteByYear() {
        List<ComprasDto> listReturn = new ArrayList<>();
        try {
            Retrofit retrofit = FactoryRetrofit.getRetroFit();
            ApiCadastro api = retrofit.create(ApiCadastro.class);
            List<ComprasDto> listCompra = api.getCompra().execute().body();

            for (ComprasDto comprasDto : listCompra) {
                if (comprasDto.getData().contains("2016")) {
                    listReturn.add(comprasDto);
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return listReturn;
    }

    public ClienteDto geraRecomendacao(ClienteDto clienteDto) {
        List<ComprasDto> listCompra = null;
        ClienteDto clienteDtoReponse = new ClienteDto();

        Map<String, ComprasDto> mapCompras = new HashMap<>();
        try {
            Retrofit retrofit = FactoryRetrofit.getRetroFit();
            ApiCadastro api = retrofit.create(ApiCadastro.class);
            listCompra = api.getCompra().execute().body();

            for (ComprasDto comprasDto : listCompra) {
                for (Produto produto : comprasDto.getItens()) {
                    if (mapCompras.containsKey(comprasDto.getCliente() + "-" + produto.getProduto())) {
                        ComprasDto cAux = mapCompras.get(comprasDto.getCliente() + "-" + produto.getProduto());
                        cAux.setContador(cAux.getContador() + 1);
                        mapCompras.put(comprasDto.getCliente() + "-" + produto.getProduto(), cAux);
                    } else {
                        comprasDto.setContador(comprasDto.getContador() + 1);
                        mapCompras.put(comprasDto.getCliente() + "-" + produto.getProduto(), comprasDto);
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        Set<String> chaves = mapCompras.keySet();
        Integer cnt = 0;
        ComprasDto comprasDtoRecomenda = null;
        for (String chave : chaves) {
            if (chave != null) {
                if (cnt == 0 && chave.contains(clienteDto.getCpf())) {
                    comprasDtoRecomenda = mapCompras.get(chave);
                    String recomenda[] = chave.split("-");
                    clienteDtoReponse.setCpf(recomenda[0]);
                    clienteDtoReponse.setVinho(recomenda[1]);
                }
              //  System.out.println(chave + mapCompras.get(chave) + " " + mapCompras.get(chave).getContador());
                if (chave.contains(clienteDto.getCpf()) && mapCompras.get(chave).getContador() > comprasDtoRecomenda.getContador()) {
                    comprasDtoRecomenda = mapCompras.get(chave);
                    String recomenda[] = chave.split("-");
                    clienteDtoReponse.setCpf(recomenda[0]);
                    clienteDtoReponse.setVinho(recomenda[1]);
                    cnt++;
                }

            }
        }
        return clienteDtoReponse;
    }

}
