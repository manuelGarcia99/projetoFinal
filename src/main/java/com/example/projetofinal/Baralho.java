package com.example.projetofinal;

public class Baralho {///se calhar necessário

    private String nome;
    private Integer numeroDeCartas;
    Baralho(String nome, Integer numeroDeCartas){
        this.nome = nome;
        this.numeroDeCartas = numeroDeCartas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeCartas() {
        return numeroDeCartas;
    }

    public void setNumeroDeCartas(int numeroDeCartas) {
        this.numeroDeCartas = numeroDeCartas;
    }
}
