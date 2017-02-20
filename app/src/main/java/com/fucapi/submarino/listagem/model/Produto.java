package com.fucapi.submarino.listagem.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by berredo on 2/19/17.
 */

public class Produto {
    @SerializedName("id")
    private Long id;

    @SerializedName("images")
    private List<Imagem> imagens;

    @SerializedName("name")
    private String nome;

    @SerializedName("rate")
    private String avaliacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
}
