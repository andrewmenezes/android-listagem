package com.fucapi.submarino.listagem.wrapper;

import com.fucapi.submarino.listagem.model.Produto;
import com.google.gson.annotations.SerializedName;

/**
 * Created by berredo on 2/19/17.
 */

public class ProdutoWrapper {

    @SerializedName("result")
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
