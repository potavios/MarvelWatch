package com.pauloos.recyclerviewsample.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.pauloos.recyclerviewsample.R;
import com.pauloos.recyclerviewsample.activity.RecyclerItemClickListener;
import com.pauloos.recyclerviewsample.activity.adapter.Adapter;
import com.pauloos.recyclerviewsample.activity.model.Film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*************************************************************
     1) Create a RecyclerView in xml file and set an ID for it
     2) Create a RecyclerView type variable

     3) Refer the RecyclerView created with the FindViewById
     5) Set the adapter ( creating a class Adapter and extending class RecyclerView.Adapter )
     6) Create an internal class whithin class "Adapter" and create the attributes for the data you want to show
     7) Implements methods of RecyclerView.Adapter
     8) Create a XML file with the model of our view ( adapter_list.xml )
     9) We need to convert our XML file into a object type 'View'
     10) Recovery the ids in class MyViewHolder by FindViewById
     11) Set the RecyclerView
     12) Create a class to manage de films attributes
     13) Create a list of movies
     14) Create a method to create movies
     15) Create an empty constructor in Adapter.java
     16) Add listMovie.size() at method "getItemCount"
     17) onBindViewHolder --> here we will recover the movies attributs

    *************************************************************/




    /* 2 */
    private RecyclerView recyclerView;

    /* 13 */
    private List<Film> filmList = new ArrayList<>();

    private Button btChrono, btRelease;

    private static final String GOOGLE_API_KEY = "AIzaSyBCQ-AWkgAG8W1K12dQ1SgJLraPTKX7fI0";
    Adapter adapter = new Adapter( filmList );



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* 3 */
        recyclerView = findViewById(R.id.recyclerView);

        /* 14 */
        this.createAFilm();

        /* 11 */ // Set the adapter
       // Adapter adapter = new Adapter( filmList );

        btChrono = findViewById(R.id.chrono);
        btRelease = findViewById(R.id.release);


        btChrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderByChronologycalOrder();
            }
        });



        btRelease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderByReleaseOrder();
            }
        });





        /* 6 */
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize( true ); // It will optimize the Recycler View
        recyclerView.addItemDecoration( new DividerItemDecoration( this, LinearLayout.VERTICAL)); // Optional -> create a line to divide the cards
        recyclerView.setAdapter( adapter );

        /* Click Event */
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Film film = filmList.get(position);

                                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                                intent.putExtra("overview", film.getOverview());
                                intent.putExtra("director", film.getDirector());
                                intent.putExtra("writer", film.getWriter());
                                intent.putExtra("runtime", film.getRuntime());
                                intent.putExtra("release", film.getReleaseDate());
                                intent.putExtra("order", film.getOrder());
                                intent.putExtra("seen", film.isSeen());
                                intent.putExtra("youtube", film.getYoutubeId());
                                startActivity( intent );
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Item longo pressionado", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                ));

    }



    /* 14 */
    public void createAFilm(){

        // Estanciar um objetvo tipo Film e depois adicioná-lo a arrayList filmList



        Film film = new Film(getString(R.string.title_01), getString(R.string.release_date_01), getString(R.string.mcu_order_01), getString(R.string.mcu_year_01), getString(R.string.overview_01), getString(R.string.director_01), getString(R.string.writer_01), getString(R.string.runtime_01), R.drawable.poster_01, Integer.valueOf(getString(R.string.id_mcu_01)), Integer.valueOf(getString(R.string.id_rel_01)), false, getString(R.string.youtube_01));
        this.filmList.add( film );

        film = new Film( getString(R.string.title_02), getString(R.string.release_date_02), getString(R.string.mcu_order_02), getString(R.string.mcu_year_02), getString(R.string.overview_02), getString(R.string.director_02), getString(R.string.writer_02 ), getString(R.string.runtime_02), R.drawable.poster_02, Integer.valueOf(getString(R.string.id_mcu_02)), Integer.valueOf(getString(R.string.id_rel_02)), false, getString(R.string.youtube_02)); this.filmList.add( film );
        film = new Film( getString(R.string.title_03), getString(R.string.release_date_03), getString(R.string.mcu_order_03), getString(R.string.mcu_year_03), getString(R.string.overview_03), getString(R.string.director_03), getString(R.string.writer_03 ), getString(R.string.runtime_03), R.drawable.poster_03, Integer.valueOf(getString(R.string.id_mcu_03)), Integer.valueOf(getString(R.string.id_rel_03)), false, getString(R.string.youtube_03)); this.filmList.add( film );
        film = new Film( getString(R.string.title_04), getString(R.string.release_date_04), getString(R.string.mcu_order_04), getString(R.string.mcu_year_04), getString(R.string.overview_04), getString(R.string.director_04), getString(R.string.writer_04 ), getString(R.string.runtime_04), R.drawable.poster_04, Integer.valueOf(getString(R.string.id_mcu_04)), Integer.valueOf(getString(R.string.id_rel_04)), false, getString(R.string.youtube_04)); this.filmList.add( film );
        film = new Film( getString(R.string.title_05), getString(R.string.release_date_05), getString(R.string.mcu_order_05), getString(R.string.mcu_year_05), getString(R.string.overview_05), getString(R.string.director_05), getString(R.string.writer_05 ), getString(R.string.runtime_05), R.drawable.poster_05, Integer.valueOf(getString(R.string.id_mcu_05)), Integer.valueOf(getString(R.string.id_rel_05)), false, getString(R.string.youtube_05)); this.filmList.add( film );
        film = new Film( getString(R.string.title_06), getString(R.string.release_date_06), getString(R.string.mcu_order_06), getString(R.string.mcu_year_06), getString(R.string.overview_06), getString(R.string.director_06), getString(R.string.writer_06 ), getString(R.string.runtime_06), R.drawable.poster_06, Integer.valueOf(getString(R.string.id_mcu_06)), Integer.valueOf(getString(R.string.id_rel_06)), false, getString(R.string.youtube_06)); this.filmList.add( film );
        film = new Film( getString(R.string.title_07), getString(R.string.release_date_07), getString(R.string.mcu_order_07), getString(R.string.mcu_year_07), getString(R.string.overview_07), getString(R.string.director_07), getString(R.string.writer_07 ), getString(R.string.runtime_07), R.drawable.poster_07, Integer.valueOf(getString(R.string.id_mcu_07)), Integer.valueOf(getString(R.string.id_rel_07)), false, getString(R.string.youtube_07)); this.filmList.add( film );
        film = new Film( getString(R.string.title_08), getString(R.string.release_date_08), getString(R.string.mcu_order_08), getString(R.string.mcu_year_08), getString(R.string.overview_08), getString(R.string.director_08), getString(R.string.writer_08 ), getString(R.string.runtime_08), R.drawable.poster_08, Integer.valueOf(getString(R.string.id_mcu_08)), Integer.valueOf(getString(R.string.id_rel_08)), false, getString(R.string.youtube_08)); this.filmList.add( film );
        film = new Film( getString(R.string.title_09), getString(R.string.release_date_09), getString(R.string.mcu_order_09), getString(R.string.mcu_year_09), getString(R.string.overview_09), getString(R.string.director_09), getString(R.string.writer_09 ), getString(R.string.runtime_09), R.drawable.poster_09, Integer.valueOf(getString(R.string.id_mcu_09)), Integer.valueOf(getString(R.string.id_rel_09)), false, getString(R.string.youtube_09)); this.filmList.add( film );
        film = new Film( getString(R.string.title_10), getString(R.string.release_date_10), getString(R.string.mcu_order_10), getString(R.string.mcu_year_10), getString(R.string.overview_10), getString(R.string.director_10), getString(R.string.writer_10 ), getString(R.string.runtime_10), R.drawable.poster_10, Integer.valueOf(getString(R.string.id_mcu_10)), Integer.valueOf(getString(R.string.id_rel_10)), false, getString(R.string.youtube_10)); this.filmList.add( film );
        film = new Film( getString(R.string.title_11), getString(R.string.release_date_11), getString(R.string.mcu_order_11), getString(R.string.mcu_year_11), getString(R.string.overview_11), getString(R.string.director_11), getString(R.string.writer_11 ), getString(R.string.runtime_11), R.drawable.poster_11, Integer.valueOf(getString(R.string.id_mcu_11)), Integer.valueOf(getString(R.string.id_rel_11)), false, getString(R.string.youtube_11)); this.filmList.add( film );
        film = new Film( getString(R.string.title_12), getString(R.string.release_date_12), getString(R.string.mcu_order_12), getString(R.string.mcu_year_12), getString(R.string.overview_12), getString(R.string.director_12), getString(R.string.writer_12 ), getString(R.string.runtime_12), R.drawable.poster_12, Integer.valueOf(getString(R.string.id_mcu_12)), Integer.valueOf(getString(R.string.id_rel_12)), false, getString(R.string.youtube_12)); this.filmList.add( film );
        film = new Film( getString(R.string.title_13), getString(R.string.release_date_13), getString(R.string.mcu_order_13), getString(R.string.mcu_year_13), getString(R.string.overview_13), getString(R.string.director_13), getString(R.string.writer_13 ), getString(R.string.runtime_13), R.drawable.poster_13, Integer.valueOf(getString(R.string.id_mcu_13)), Integer.valueOf(getString(R.string.id_rel_13)), false, getString(R.string.youtube_13)); this.filmList.add( film );
        film = new Film( getString(R.string.title_14), getString(R.string.release_date_14), getString(R.string.mcu_order_14), getString(R.string.mcu_year_14), getString(R.string.overview_14), getString(R.string.director_14), getString(R.string.writer_14 ), getString(R.string.runtime_14), R.drawable.poster_14, Integer.valueOf(getString(R.string.id_mcu_14)), Integer.valueOf(getString(R.string.id_rel_14)), false, getString(R.string.youtube_14)); this.filmList.add( film );
        film = new Film( getString(R.string.title_15), getString(R.string.release_date_15), getString(R.string.mcu_order_15), getString(R.string.mcu_year_15), getString(R.string.overview_15), getString(R.string.director_15), getString(R.string.writer_15 ), getString(R.string.runtime_15), R.drawable.poster_15, Integer.valueOf(getString(R.string.id_mcu_15)), Integer.valueOf(getString(R.string.id_rel_15)), false, getString(R.string.youtube_15)); this.filmList.add( film );
        film = new Film( getString(R.string.title_16), getString(R.string.release_date_16), getString(R.string.mcu_order_16), getString(R.string.mcu_year_16), getString(R.string.overview_16), getString(R.string.director_16), getString(R.string.writer_16 ), getString(R.string.runtime_16), R.drawable.poster_16, Integer.valueOf(getString(R.string.id_mcu_16)), Integer.valueOf(getString(R.string.id_rel_16)), false, getString(R.string.youtube_16)); this.filmList.add( film );
        film = new Film( getString(R.string.title_17), getString(R.string.release_date_17), getString(R.string.mcu_order_17), getString(R.string.mcu_year_17), getString(R.string.overview_17), getString(R.string.director_17), getString(R.string.writer_17 ), getString(R.string.runtime_17), R.drawable.poster_17, Integer.valueOf(getString(R.string.id_mcu_17)), Integer.valueOf(getString(R.string.id_rel_17)), false, getString(R.string.youtube_17)); this.filmList.add( film );
        film = new Film( getString(R.string.title_18), getString(R.string.release_date_18), getString(R.string.mcu_order_18), getString(R.string.mcu_year_18), getString(R.string.overview_18), getString(R.string.director_18), getString(R.string.writer_18 ), getString(R.string.runtime_18), R.drawable.poster_18, Integer.valueOf(getString(R.string.id_mcu_18)), Integer.valueOf(getString(R.string.id_rel_18)), false, getString(R.string.youtube_18)); this.filmList.add( film );
        film = new Film( getString(R.string.title_19), getString(R.string.release_date_19), getString(R.string.mcu_order_19), getString(R.string.mcu_year_19), getString(R.string.overview_19), getString(R.string.director_19), getString(R.string.writer_19 ), getString(R.string.runtime_19), R.drawable.poster_19, Integer.valueOf(getString(R.string.id_mcu_19)), Integer.valueOf(getString(R.string.id_rel_19)), false, getString(R.string.youtube_19)); this.filmList.add( film );
        film = new Film( getString(R.string.title_20), getString(R.string.release_date_20), getString(R.string.mcu_order_20), getString(R.string.mcu_year_20), getString(R.string.overview_20), getString(R.string.director_20), getString(R.string.writer_20 ), getString(R.string.runtime_20), R.drawable.poster_20, Integer.valueOf(getString(R.string.id_mcu_20)), Integer.valueOf(getString(R.string.id_rel_20)), false, getString(R.string.youtube_20)); this.filmList.add( film );
        film = new Film( getString(R.string.title_21), getString(R.string.release_date_21), getString(R.string.mcu_order_21), getString(R.string.mcu_year_21), getString(R.string.overview_21), getString(R.string.director_21), getString(R.string.writer_21 ), getString(R.string.runtime_21), R.drawable.poster_21, Integer.valueOf(getString(R.string.id_mcu_21)), Integer.valueOf(getString(R.string.id_rel_21)), false, getString(R.string.youtube_21)); this.filmList.add( film );
        film = new Film( getString(R.string.title_22), getString(R.string.release_date_22), getString(R.string.mcu_order_22), getString(R.string.mcu_year_22), getString(R.string.overview_22), getString(R.string.director_22), getString(R.string.writer_22 ), getString(R.string.runtime_22), R.drawable.poster_22, Integer.valueOf(getString(R.string.id_mcu_22)), Integer.valueOf(getString(R.string.id_rel_22)), false, getString(R.string.youtube_22)); this.filmList.add( film );
        film = new Film( getString(R.string.title_23), getString(R.string.release_date_23), getString(R.string.mcu_order_23), getString(R.string.mcu_year_23), getString(R.string.overview_23), getString(R.string.director_23), getString(R.string.writer_23 ), getString(R.string.runtime_23), R.drawable.poster_23, Integer.valueOf(getString(R.string.id_mcu_23)), Integer.valueOf(getString(R.string.id_rel_23)), false, getString(R.string.youtube_23)); this.filmList.add( film );



    }




    public void orderByChronologycalOrder(){

        Collections.sort(filmList, new Comparator<Film>() {
            @Override
            public int compare(Film f1, Film f2) {
                return Integer.valueOf(f1.getIdMcu()).compareTo(f2.getIdMcu());
            }
        });
        adapter.notifyDataSetChanged();

        btChrono.setTextColor(getResources().getColor(R.color.fontColor));
        btRelease.setTextColor(getResources().getColor(R.color.colorPrimaryDark));



    }

    public void orderByReleaseOrder(){
        Collections.sort(filmList, new Comparator<Film>() {
            @Override
            public int compare(Film f1, Film f2) {
                return Integer.valueOf(f1.getIdRel()).compareTo(f2.getIdRel());

            }
        });
        adapter.notifyDataSetChanged();

        btRelease.setTextColor(getResources().getColor(R.color.fontColor));
        btChrono.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

    }






}
