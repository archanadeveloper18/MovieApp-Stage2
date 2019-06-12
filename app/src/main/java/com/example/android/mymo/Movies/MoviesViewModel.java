package com.example.android.mymo.Movies;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.mymo.database.MovieDatabase;
import com.example.android.mymo.model.Movie;

import java.util.List;

public class MoviesViewModel extends AndroidViewModel {

    private LiveData<List<Movie>> mAllFavoriteMovies;

    public MoviesViewModel(@NonNull Application application) {
        super(application);

        mAllFavoriteMovies = MovieDatabase.getInstance(application)
                .movieDao().getAllMovies();

    }

    public LiveData<List<Movie>> getAllFavoriteMovies() {
        return mAllFavoriteMovies;
    }
}