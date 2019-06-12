package com.example.android.mymo.MovieReviews;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.android.mymo.model.MovieReview;
import com.example.android.mymo.webservice.ThemoviedbApiClient;

import java.util.ArrayList;
import java.util.List;

public class MovieReviewsLoader extends AsyncTaskLoader<List<MovieReview>> {

    List<MovieReview> mMovieReviews;
    int mMovieId, mLimit;

    public MovieReviewsLoader(Context context, int movieId, int limit) {
        super(context);
        mMovieReviews = new ArrayList<>();
        this.mMovieId = movieId;
        this.mLimit = limit;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<MovieReview> loadInBackground() {

        mMovieReviews =
                ThemoviedbApiClient.getMovieReviews(mMovieId, mLimit);
        return mMovieReviews;
    }
}