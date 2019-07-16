package com.pauloos.recyclerviewsample.activity.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pauloos.recyclerviewsample.R;
import com.pauloos.recyclerviewsample.activity.activity.MainActivity;
import com.pauloos.recyclerviewsample.activity.model.Film;

import java.util.List;


/*5 - Deve se passar um View Holder para o RecyclerView.Adapter<VIEW HOLDER> */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    /* 15 */
    private List<Film> movieList;
    public Adapter(List<Film> list) {
        this.movieList =  list;
    }



    /* 7 */
    @NonNull
    @Override // Este método cria apenas as view que serão exibidas na tela //
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /* 9 */
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list, parent, false);
        return new MyViewHolder( itemList );
    }

    @Override // Este método exibe os itens //
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        Film film = movieList.get( position );

        holder.title.setText( film.getTitle());
        holder.releaseDate.setText( film.getReleaseDate());
        holder.order.setText( film.getOrder());
        holder.chronologicalYear.setText(film.getChronologicalYear());
        holder.poster.setImageResource( film.getPosterUrl());
        holder.getItemId();



        holder.poster.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            }
        }



        );



    }

    @Override // Retorna a qt de items a serem exibidos
    public int getItemCount() {
        /* 16 */
        return movieList.size();
    }



    /**
     * 6
     * Classe interna responsável por guardar os dados antes de serem exibidos na tela
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, releaseDate, order, chronologicalYear;
        ImageView poster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            /* 10 */
            title = itemView.findViewById(R.id.tv_title);
            releaseDate = itemView.findViewById(R.id.tv_rDate);
            order = itemView.findViewById(R.id.tv_order);
            chronologicalYear = itemView.findViewById(R.id.tv_cDate);
            poster = itemView.findViewById(R.id.iv_poster);






        }
    }



}
