package com.fucapi.submarino.listagem.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fucapi.submarino.listagem.R;
import com.fucapi.submarino.listagem.activity.ProdutoDetalhadoActivity;
import com.fucapi.submarino.listagem.model.Imagem;
import com.fucapi.submarino.listagem.model.Produto;

import java.util.List;

/**
 * Created by berredo on 2/19/17.
 */

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>{
    private List<Produto> mList;

    public ProdutoAdapter(List<Produto> list){
        this.mList = list;
    }
    @Override
    public ProdutoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.produto_item, viewGroup, false);
        return new ProdutoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProdutoViewHolder viewHolder, int i) {
        final Produto produto = mList.get(i);
        viewHolder.viewName.setText(produto.getNome());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProdutoDetalhadoActivity.class);
                intent.putExtra(ProdutoDetalhadoActivity.PRODUCT_ID_KEY, produto.getId());
                v.getContext().startActivity(intent);
            }
        });

        if(produto.getImagens()!=null && produto.getImagens().get(0)!=null) {
            Imagem imagem = produto.getImagens().get(0);
            String imagemPequena = imagem.getPequena();

            viewHolder.viewPicture.setImageURI(imagemPequena);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected static class ProdutoViewHolder extends RecyclerView.ViewHolder{
        protected TextView viewName;
        protected SimpleDraweeView viewPicture;
        protected CardView cardView;

        public ProdutoViewHolder(View itemView) {
            super(itemView);
            viewName = (TextView) itemView.findViewById(R.id.tv_name);
            viewPicture = (SimpleDraweeView) itemView.findViewById(R.id.iv_picture);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
