package com.example.realnews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import java.util.ArrayList;

public class NewsRvAdapter extends RecyclerView.Adapter<NewsRvAdapter.ViewHolder> {
    List<Articles> articlesArrayList;
    Context context;

    public NewsRvAdapter(List<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public NewsRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
        return new NewsRvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRvAdapter.ViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);
        holder.textView.setText(articles.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(context,MainActivity2.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name" , articles.getName());
                intent.putExtra("alpha_two_code" , articles.getAlpha_two_code());
                intent.putExtra("country", articles.getCountry());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.cn);
            imageView =itemView.findViewById(R.id.imgv);
        }
    }
}
