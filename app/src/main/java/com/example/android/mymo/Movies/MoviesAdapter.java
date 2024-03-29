package com.example.android.mymo.Movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.mymo.R;
import com.example.android.mymo.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private static final String LOG_TAG = MoviesAdapter.class.getSimpleName();

    private List<Movie> mMovieList;
    private Context mContext;
    private final MovieAdapterOnClickHandler mClickHandler;

    public interface MovieAdapterOnClickHandler {
        void onClick(Movie movie);
    }


    public MoviesAdapter(MovieAdapterOnClickHandler clickHandler) {
        this.mClickHandler = clickHandler;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        @BindView(R.id.iv_movie_poster) ImageView mMovieImageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mClickHandler.onClick(mMovieList.get(position));
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_item, parent, false);

        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);

        Picasso.with(mContext)
                .load(movie.getPosterPath())
                .into(holder.mMovieImageView);
    }

    @Override
    public int getItemCount() {
        return mMovieList != null ? mMovieList.size() : 0;
    }

    public void setMovieList(List<Movie> movieList) {
        this.mMovieList = movieList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

}