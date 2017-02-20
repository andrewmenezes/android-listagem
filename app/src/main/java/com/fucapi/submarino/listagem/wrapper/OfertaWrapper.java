package com.fucapi.submarino.listagem.wrapper;

import com.fucapi.submarino.listagem.model.Oferta;
import com.google.gson.annotations.SerializedName;

/**
 * Created by berredo on 2/19/17.
 */

public class OfertaWrapper {
    @SerializedName("result")
    private OfertasWrapper oferta;

    public OfertasWrapper getOferta() {
        return oferta;
    }

    public void setOferta(OfertasWrapper oferta) {
        this.oferta = oferta;
    }
}
