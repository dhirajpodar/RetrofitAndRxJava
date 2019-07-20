package com.example.retrofitandrxandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitandrxandroid.R;
import com.example.retrofitandrxandroid.model.Hero;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    List<Hero> heroes;

    public MyAdapter(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_listview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Hero hero = heroes.get(position);

        Picasso.get().load(hero.getImageurl()).into(holder.imageView);

        holder.name.setText(hero.getName());
        holder.realname.setText(hero.getRealname());
        holder.firstapperance.setText(hero.getFirstappearance());
        holder.publisher.setText(hero.getPublisher());
        holder.createdby.setText(hero.getCreatedby());
        holder.team.setText(hero.getTeam());

    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

         ImageView imageView;
         TextView name;
         TextView realname;
         TextView firstapperance;
         TextView publisher;
         TextView createdby;
         TextView team;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            realname = itemView.findViewById(R.id.realname);
            firstapperance = itemView.findViewById(R.id.firstapperance);
            publisher = itemView.findViewById(R.id.publisher);
            createdby = itemView.findViewById(R.id.createdby);
            team = itemView.findViewById(R.id.team);
        }
    }
}