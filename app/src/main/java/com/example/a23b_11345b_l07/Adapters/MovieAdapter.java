package com.example.a23b_11345b_l07.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a23b_11345b_l07.Models.Movie;
import com.example.a23b_11345b_l07.R;
import com.example.a23b_11345b_l07.Utilities.ImageLoader;
import com.example.a23b_11345b_l07.Utilities.TimeFormatter;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> movies;

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = getItem(position);
        holder.movie_LBL_title.setText(movie.getTitle());
        holder.movie_LBL_year.setText(movie.getYear() + "");
        holder.movie_LBL_duration.setText(TimeFormatter.getFormattedTime(movie.getDuration()));
        holder.movie_LBL_reviews.setText(movie.getReviews() + " Reviews");
        holder.movie_RTG_rating.setRating(movie.getRating() / 20);
        ImageLoader.getInstance().loadImage(movie.getImage(), holder.movie_IMG_poster);
        if (movie.isFavorite())
            ImageLoader.getInstance().loadImage(R.drawable.heart, holder.movie_IMG_favorite);
        else
            ImageLoader.getInstance().loadImage(R.drawable.heart_empty, holder.movie_IMG_favorite);


    }

    @Override
    public int getItemCount() {
        return this.movies == null ? 0 : this.movies.size();
    }

    private Movie getItem(int position) {
        return this.movies.get(position);
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ShapeableImageView movie_IMG_favorite;
        private AppCompatRatingBar movie_RTG_rating;
        private MaterialTextView movie_LBL_reviews;
        private MaterialTextView movie_LBL_duration;
        private MaterialTextView movie_LBL_year;
        private MaterialTextView movie_LBL_title;
        private ShapeableImageView movie_IMG_poster;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_IMG_favorite = itemView.findViewById(R.id.movie_IMG_favorite);
            movie_RTG_rating = itemView.findViewById(R.id.movie_RTG_rating);
            movie_LBL_reviews = itemView.findViewById(R.id.movie_LBL_reviews);
            movie_LBL_duration = itemView.findViewById(R.id.movie_LBL_duration);
            movie_LBL_year = itemView.findViewById(R.id.movie_LBL_year);
            movie_LBL_title = itemView.findViewById(R.id.movie_LBL_title);
            movie_IMG_poster = itemView.findViewById(R.id.movie_IMG_poster);
        }
    }
}
