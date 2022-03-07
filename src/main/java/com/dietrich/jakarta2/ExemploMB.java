package com.dietrich.jakarta2;

import com.dietrich.jakarta2.converter.Estado;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class ExemploMB {
    private Estado selecionado;
    private List<Estado> listaEstados;

    @PostConstruct
    public void init() {
        listaEstados = Estado.buscarTodos();
    }

    public Estado getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Estado selecionado) {
        this.selecionado = selecionado;
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }
}
