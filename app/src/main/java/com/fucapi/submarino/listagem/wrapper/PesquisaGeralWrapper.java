package com.fucapi.submarino.listagem.wrapper;

import com.fucapi.submarino.listagem.model.Produto;
import com.fucapi.submarino.listagem.model.Resultado;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by berredo on 2/19/17.
 */
public class PesquisaGeralWrapper {

    @SerializedName("_result")
    private Resultado resultado;

    @SerializedName("didYouMean")
    private String voceQuisDizer;

    @SerializedName("sortBY")
    private String ordenacao;

    @SerializedName("timing")
    private String tempo;

    @SerializedName("products")
    private List<Produto> produtos;

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public String getVoceQuisDizer() {
        return voceQuisDizer;
    }

    public void setVoceQuisDizer(String voceQuisDizer) {
        this.voceQuisDizer = voceQuisDizer;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
}
