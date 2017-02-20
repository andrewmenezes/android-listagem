package com.fucapi.submarino.listagem.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fucapi.submarino.listagem.App;
import com.fucapi.submarino.listagem.BuildConfig;
import com.fucapi.submarino.listagem.R;
import com.fucapi.submarino.listagem.model.Oferta;
import com.fucapi.submarino.listagem.model.Produto;
import com.fucapi.submarino.listagem.wrapper.OfertaWrapper;
import com.fucapi.submarino.listagem.wrapper.PesquisaEspecificaWrapper;
import com.fucapi.submarino.listagem.wrapper.ProdutoWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdutoDetalhadoActivity extends AppCompatActivity {
    public static final String PRODUCT_ID_KEY = "productID";
    private Long idProduto;

    private SimpleDraweeView ivPicture;
    private TextView tvNome;
    private TextView tvPreco;
    private TextView preco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_detalhado);
        idProduto = getIntent().getLongExtra(PRODUCT_ID_KEY, 0);

        tvNome = (TextView) findViewById(R.id.tv_name);
        tvPreco = (TextView) findViewById(R.id.tv_preco);
        preco = (TextView) findViewById(R.id.preco);
        ivPicture = (SimpleDraweeView) findViewById(R.id.iv_picture);

        getProduto(idProduto);
    }

    private void getProduto(Long idProduto) {
        final Integer limite = BuildConfig.PESQUISA_ESPECIFICA_KEY_OFFER_LIMIT;
        final String loja = BuildConfig.PESQUISA_ESPECIFICA_STORE_ID;
        final String tags = BuildConfig.PESQUISA_ESPECIFICA_TAGS;

        Call<PesquisaEspecificaWrapper> call = App.ApiInstance(BuildConfig.PESQUISA_ESPECIFICA_URL).getProdutoEspecifico(
                idProduto,
                limite,
                loja,
                tags
        );

        call.enqueue(new Callback<PesquisaEspecificaWrapper>() {
            @Override
            public void onResponse(Call<PesquisaEspecificaWrapper> call, Response<PesquisaEspecificaWrapper> response) {
                PesquisaEspecificaWrapper wrapper = response.body();

                if (wrapper != null) {
                    ProdutoWrapper produtoWrapper = wrapper.getProduto();
                    OfertaWrapper ofertaWrapper = wrapper.getOferta();

                    Produto produto = null;
                    Oferta oferta = null;

                    if (produtoWrapper != null) produto = produtoWrapper.getProduto();
                    if (ofertaWrapper != null) oferta = ofertaWrapper.getOferta().getOferta().get(0);

                    if (oferta != null && produto != null) {
                        if (produto.getImagens() != null && produto.getImagens().get(0) != null) {
                            ivPicture.setImageURI(produto.getImagens().get(0).getGrande());
                        }

                        tvNome.setText(produto.getNome());
                        tvPreco.setText("R$ " + String.valueOf(oferta.getPrecoVenda()));
                        preco.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onFailure(Call<PesquisaEspecificaWrapper> call, Throwable t) {
                String cause = t.getCause().toString();
                Toast.makeText(
                        ProdutoDetalhadoActivity.this,
                        getString(R.string.search_error) + " " + cause,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }
}