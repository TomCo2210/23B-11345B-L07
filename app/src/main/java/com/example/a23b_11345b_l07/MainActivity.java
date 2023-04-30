package com.example.a23b_11345b_l07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.a23b_11345b_l07.Adapters.MovieAdapter;
import com.example.a23b_11345b_l07.Interfaces.MovieCallback;
import com.example.a23b_11345b_l07.Models.Movie;
import com.example.a23b_11345b_l07.Utilities.DataManager;
import com.example.a23b_11345b_l07.Utilities.SignalGenerator;

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
        movieAdapter.setMovieCallback(new MovieCallback() {
            @Override
            public void itemClicked(Movie movie, int position) {
                SignalGenerator.getInstance().toast(movie.getTitle(), Toast.LENGTH_SHORT);
            }

            @Override
            public void favoriteClicked(Movie movie, int position) {
                movie.setFavorite(!movie.isFavorite());
                main_LST_movies.getAdapter().notifyItemChanged(position);
            }
        });
    }

    private void findViews() {
        main_LST_movies = findViewById(R.id.main_LST_movies);
    }
}