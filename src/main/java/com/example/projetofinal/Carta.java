package com.example.projetofinal;

public  class Carta {
    private double easinessFactor;
    private int id;
    private int intervaloAnterior;
    private int ordemDaRepeticao;
    private String pergunta;
    private String resposta;
    private String termo1;
    private String definicao1;
    private String termo2;
    private String definicao2;
    private String nomeDoBaralho;
    private int intervaloAtual;

    Carta(int id, String pergunta, String resposta, String termo1, String definicao1, String termo2, String definicao2, String nomeDoBaralho)
    {
        this.easinessFactor = 2.5;
        this.ordemDaRepeticao = 1;
        this.id = id;//Vamos ter que trabalhar com a base de dados
        this.intervaloAtual = 1;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.termo1 = termo1;
        this.definicao1 = definicao1;
        this.termo2 = termo2;
        this.definicao2 = definicao2;
        this.nomeDoBaralho = nomeDoBaralho;
    }

    public double getEasinessFactor() {
        return easinessFactor;
    }

    public void setEasinessFactor(double easinessFactor) {
        this.easinessFactor = easinessFactor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntervalo() {
        return intervaloAtual;
    }

    public void setIntervalo(int intervalo) {
        this.intervaloAtual = intervalo;
    }

    public int getOrdemDaRepeticao() {
        return ordemDaRepeticao;
    }

    public void setOrdemDaRepeticao(int ordemDaRepeticao) {
        this.ordemDaRepeticao = ordemDaRepeticao;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getTermo1() {
        return termo1;
    }

    public void setTermo1(String termo1) {
        this.termo1 = termo1;
    }

    public String getDefinicao1() {
        return definicao1;
    }

    public void setDefinicao1(String definicao1) {
        this.definicao1 = definicao1;
    }

    public String getTermo2() {
        return termo2;
    }

    public void setTermo2(String termo2) {
        this.termo2 = termo2;
    }

    public String getDefinicao2() {
        return definicao2;
    }

    public void setDefinicao2(String definicao2) {
        this.definicao2 = definicao2;
    }

    public String getNomeDoBaralho() {
        return nomeDoBaralho;
    }

    public void setNomeDoBaralho(String nomeDoBaralho) {
        this.nomeDoBaralho = nomeDoBaralho;
    }




}
