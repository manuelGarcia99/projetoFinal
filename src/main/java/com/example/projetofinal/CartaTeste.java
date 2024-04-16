package com.example.projetofinal;

public class CartaTeste {
    private int id;
    private String pergunta;
    private String resposta;
    private String termo1;
    private String definicao1;
    private String termo2;
    private String definicao2;
    private String nomeDoBaralho;

    CartaTeste(int id, String pergunta, String resposta,String nomeDoBaralho){
        this(id,pergunta,resposta,"Inexistente","Não atribuiu","Inexistente","Não atribuiu!",nomeDoBaralho);

    }
    CartaTeste(int id, String pergunta, String resposta, String termo1, String definicao1,String nomeDoBaralho){
        this(id,pergunta,resposta,termo1,definicao1,"Inexistente","Não atribuiu!",nomeDoBaralho);
    }
    CartaTeste(int id, String pergunta, String resposta, String termo1, String definicao1, String termo2, String definicao2, String nomeDoBaralho)
    {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.termo1 = termo1;
        this.definicao1 = definicao1;
        this.termo2 = termo2;
        this.definicao2 = definicao2;
        this.nomeDoBaralho = nomeDoBaralho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
