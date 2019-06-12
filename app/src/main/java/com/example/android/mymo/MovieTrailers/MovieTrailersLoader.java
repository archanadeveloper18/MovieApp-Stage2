package com.example.android.mymo.MovieTrailers;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.android.mymo.model.MovieTrailer;
import com.example.android.mymo.webservice.ThemoviedbApiClient;

import java.util.ArrayList;
import java.util.List;

public class MovieTrailersLoader extends AsyncTaskLoader<List<MovieTrailer>> {
    private List<MovieTrailer> mMovieTrailers;
    int mMovieId, mLimit;


    public MovieTrailersLoader(Context context, int movieId, int limit) {
        super(context);
        mMovieTrailers = new ArrayList<>();
        this.mMovieId = movieId;
        this.mLimit = limit;
    }

    @Override
    public List<MovieTrailer> loadInBackground() {

        mMovieTrailers =
                ThemoviedbApiClient.getMovieTrailers(mMovieId, mLimit);
        return mMovieTrailers;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
