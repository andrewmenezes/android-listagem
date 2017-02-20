package com.fucapi.submarino.listagem.wrapper;

import com.fucapi.submarino.listagem.model.Oferta;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by berredo on 2/20/17.
 */

public class OfertasWrapper {
    @SerializedName("offers")
    private List<Oferta> oferta;

    public List<Oferta> getOferta() {
        return oferta;
    }

    public void setOferta(List<Oferta> oferta) {
        this.oferta = oferta;
    }
}
