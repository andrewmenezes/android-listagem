package com.fucapi.submarino.listagem.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by berredo on 2/19/17.
 */

public class Resultado {
    @SerializedName("limit")
    private Integer limite;

    @SerializedName("offset")
    private Integer inicio;

    @SerializedName("total")
    private Integer total;


    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
