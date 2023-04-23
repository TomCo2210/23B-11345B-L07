package com.example.a23b_11345b_l07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a23b_11345b_l07.Adapters.MovieAdapter;
import com.example.a23b_11345b_l07.Utilities.DataManager;

public class MainActivity extends AppCompatActivity {


    private RecyclerView main_LST_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initViews();

    }

    private void initViews() {
        MovieAdapter movieAdapter = new MovieAdapter(DataManager.getMovies());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        main_LST_movies.setAdapter(movieAdapter);
        main_LST_movies.setLayoutManager(linearLayoutManager);
    }

    private void findViews() {
        main_LST_movies = findViewById(R.id.main_LST_movies);
    }
}