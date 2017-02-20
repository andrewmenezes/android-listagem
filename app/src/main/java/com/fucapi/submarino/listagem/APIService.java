package com.fucapi.submarino.listagem;

import com.fucapi.submarino.listagem.wrapper.PesquisaGeralWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by berredo on 2/19/17.
 */

public interface APIService {

    @GET("mystique/search")
    Call<PesquisaGeralWrapper> getProdutos (@Query("content") String conteudo, @Query("source") String fonte, @Query("sortBy") String ordernar);
}
