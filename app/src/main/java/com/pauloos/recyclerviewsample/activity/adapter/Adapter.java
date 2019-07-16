package com.pauloos.recyclerviewsample.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pauloos.recyclerviewsample.R;
import com.pauloos.recyclerviewsample.activity.model.Film;
import java.util.List;

/** 4 - We should pass a ViewHolder to the RecyclerView.Adapter<ViewHolderName> **/
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    /** 15 **/
    private List<Film> movieList;
    public Adapter(List<Film> list) {
        this.movieList =  list;
    }

    /** 6 **/
    @NonNull
    @Override /** This method creates a view that will be displayed on screen. **/
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /** 8 **/
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list, parent, false);
        return new MyViewHolder( itemList );
    }

    /** 6 **/
    @Override /** This method displays the items **/
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        /** 17 **/
        Film film = movieList.get( position );
        holder.title.setText( film.getTitle());
        holder.releaseDate.setText( film.getReleaseDate());
        holder.order.setText( film.getOrder());
        holder.chronologicalYear.setText(film.getChronologicalYear());
        holder.poster.setImageResource( film.getPosterUrl());
    }

    @Override /** 16 returns how many item should be displayed **/
    public int getItemCount() {
        return movieList.size();
    }


    /** 5 - Internal Class created. This class is responsible to keep the data before display it  on screen. */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, releaseDate, order, chronologicalYear;
        ImageView poster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            /** 09 **/
            title = itemView.findViewById(R.id.tv_title);
            releaseDate = itemView.findViewById(R.id.tv_rDate);
            order = itemView.findViewById(R.id.tv_order);
            chronologicalYear = itemView.findViewById(R.id.tv_cDate);
            poster = itemView.findViewById(R.id.iv_poster);
        }
    }

}
