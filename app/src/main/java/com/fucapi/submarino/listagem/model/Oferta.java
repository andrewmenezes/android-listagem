package com.fucapi.submarino.listagem.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by berredo on 2/19/17.
 */

public class Oferta {
    @SerializedName("id")
    private String id;

    @SerializedName("condition")
    private String condicao;

    @SerializedName("salesPrice")
    private Double precoVenda;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }
}
