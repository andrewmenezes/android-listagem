package com.fucapi.submarino.listagem.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by berredo on 2/19/17.
 */

public class Imagem {
    @SerializedName("small")
    private String pequena;

    @SerializedName("medium")
    private String media;

    @SerializedName("large")
    private String grande;

    @SerializedName("extraLarge")
    private String extraGrande;

    public String getPequena() {
        return pequena;
    }

    public void setPequena(String pequena) {
        this.pequena = pequena;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getGrande() {
        return grande;
    }

    public void setGrande(String grande) {
        this.grande = grande;
    }

    public String getExtraGrande() {
        return extraGrande;
    }

    public void setExtraGrande(String extraGrande) {
        this.extraGrande = extraGrande;
    }
}
