package com.ubots.loja.dto;

import com.ubots.loja.domain.Produto;

import java.time.LocalDate;
import java.util.List;

public class ComprasDto implements Comparable<ComprasDto> {
    private String codigo;
    private String data;
    private String cliente;
    private Double valorTotal;
    private List<Produto> itens;
    private Integer contador = 0;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    @Override
    public int compareTo(ComprasDto o) {
        return Double.compare(o.getValorTotal(), this.valorTotal);
    }


}
