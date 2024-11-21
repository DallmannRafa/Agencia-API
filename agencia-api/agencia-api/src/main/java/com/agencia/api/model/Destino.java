package com.agencia.api.model;

public class Destino {
    private Long id;
    private String nome;
    private String localizacao;
    private String descricao;
    private double notaMedia;
    private int quantidadeAvaliacoes;

    // Construtor vazio
    public Destino() {}

    // Construtor completo
    public Destino(Long id, String nome, String localizacao, String descricao) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.notaMedia = 0.0;
        this.quantidadeAvaliacoes = 0;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public int getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(int quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }
}
