package com.dietrich.jakarta2.converter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Estado implements Serializable {
    private String nome;
    private String sigla;

    public Estado(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public static List<Estado> buscarTodos() {
        return Arrays.asList(
                new Estado("PR", "Paraná"),
                new Estado("SC", "Santa Catarina"),
                new Estado("RS", "Rio Grande do Sul"),
                new Estado("MG", "Minas Gerais")
        );
    }

    public static Estado buscar(String sigla) {
        if(sigla.equals("PR"))
            return new Estado("PR", "Paraná");
        if(sigla.equals("SC"))
            return new Estado("SC", "Santa Catarina");
        if (sigla.equals("RS"))
            return new Estado("RS", "Rio Grande do Sul");
        if (sigla.equals("MG"))
            return new Estado("MG", "Minas Gerais");
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        return this.sigla.equalsIgnoreCase(
                ((Estado) o).getSigla()
        );
    }

    @Override
    public int hashCode() {
        return this.sigla.hashCode();
    }
}
