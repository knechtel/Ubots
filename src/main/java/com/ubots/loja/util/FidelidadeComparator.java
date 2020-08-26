package com.ubots.loja.util;

import com.ubots.loja.dto.ComprasDto;

import java.util.Comparator;

public class FidelidadeComparator implements Comparator<ComprasDto> {
    @Override
    public int compare(ComprasDto o1, ComprasDto o2) {
        return o2.getContador()-o1.getContador();
    }
}
