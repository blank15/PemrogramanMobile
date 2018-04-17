package yudistirosaputro.gmail.com.pertemuan4.pertemuanKe5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import yudistirosaputro.gmail.com.pertemuan4.R;

public class Pertemuan5 extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewMoviesAdapter adapter;
    List<Movie> movieList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertemuan5);
        recyclerView = findViewById(R.id.rview);
        adapter = new RecyclerViewMoviesAdapter(movieList,Pertemuan5.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        prepareMovieData();     }
    private void prepareMovieData() {         Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015","4.5/5",R.drawable.mad);
        movieList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015","4/5",R.drawable.inside);
        movieList.add(movie);
        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015","4.5/5",R.drawable.star);
        movieList.add(movie);
        movie = new Movie("Shaun the Sheep", "Animation", "2015","4.5/5",R.drawable.shaoun);
        movieList.add(movie);
        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015","4.5/5",R.drawable.martian);
        movieList.add(movie);
        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015","4.5/5",R.drawable.mission);
        movieList.add(movie);

        movieList.add(movie);
        adapter.notifyDataSetChanged();     } }