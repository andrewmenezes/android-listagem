package com.fucapi.submarino.listagem.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.fucapi.submarino.listagem.App;
import com.fucapi.submarino.listagem.BuildConfig;
import com.fucapi.submarino.listagem.R;
import com.fucapi.submarino.listagem.model.Produto;
import com.fucapi.submarino.listagem.wrapper.PesquisaGeralWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = (RecyclerView) findViewById(R.id.recycler);

        if(mRecycler!=null) {
            mRecycler.setHasFixedSize(true);

            // use a linear layout manager
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRecycler.setLayoutManager(mLayoutManager);

            // specify an adapter (see also next example)
//            mAdapter = new MyAdapter(myDataset);
//            mRecycler.setAdapter(mAdapter);
        }

        getProdutos();
    }

    private void getProdutos() {
        final String conteudo = BuildConfig.PESQUISA_GERAL_KEY_CONTENT;
        final String fonte = BuildConfig.PESQUISA_GERAL_KEY_SRC;
        final String ordenacao = BuildConfig.PESQUISA_GERAL_KEY_SORT_BY;

        Call<PesquisaGeralWrapper> call = App.ApiInstance(BuildConfig.PESQUISA_GERAL_URL)
                .getProdutos(conteudo, fonte, ordenacao);

        call.enqueue(new Callback<PesquisaGeralWrapper>() {
            @Override
            public void onResponse(Call<PesquisaGeralWrapper> call, Response<PesquisaGeralWrapper> response) {
                PesquisaGeralWrapper pesquisaGeralWrapper = response.body();

            }

            @Override
            public void onFailure(Call<PesquisaGeralWrapper> call, Throwable t) {
                String cause = t.getCause().toString();
                Toast.makeText(
                        MainActivity.this,
                        getString(R.string.search_error) + " " + cause,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
