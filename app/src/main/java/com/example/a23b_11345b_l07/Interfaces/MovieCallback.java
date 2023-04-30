package com.example.a23b_11345b_l07.Interfaces;

import com.example.a23b_11345b_l07.Models.Movie;

public interface MovieCallback {
    void itemClicked(Movie movie, int position);

    void favoriteClicked(Movie movie, int position);
}
