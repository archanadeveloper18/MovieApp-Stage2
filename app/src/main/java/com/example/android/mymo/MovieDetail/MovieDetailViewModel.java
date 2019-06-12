package com.example.android.mymo.MovieDetail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.mymo.database.MovieDatabase;
import com.example.android.mymo.model.Movie;


public class MovieDetailViewModel extends ViewModel {

    private LiveData<Movie> mMovie;

    public MovieDetailViewModel(MovieDatabase database, int movieId) {
        mMovie = database.movieDao().getMovieById(movieId);
    }

    public LiveData<Movie> getMovie() {
        return mMovie;
    }
}
