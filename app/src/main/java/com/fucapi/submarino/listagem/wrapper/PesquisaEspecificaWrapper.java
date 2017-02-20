package com.fucapi.submarino.listagem.wrapper;

import com.google.gson.annotations.SerializedName;

/**
 * Created by berredo on 2/19/17.
 */

public class PesquisaEspecificaWrapper {
    @SerializedName("product")
    private ProdutoWrapper produto;

    @SerializedName("offer")
    private OfertaWrapper oferta;

    public ProdutoWrapper getProduto() {
        return produto;
    }

    public void setProduto(ProdutoWrapper produto) {
        this.produto = produto;
    }

    public OfertaWrapper getOferta() {
        return oferta;
    }

    public void setOferta(OfertaWrapper oferta) {
        this.oferta = oferta;
    }
}
