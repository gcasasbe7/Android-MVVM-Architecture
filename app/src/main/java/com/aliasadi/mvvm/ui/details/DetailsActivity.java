package com.aliasadi.mvvm.ui.details;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.aliasadi.mvvm.R;
import com.aliasadi.mvvm.data.network.model.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ali Asadi on 12/03/2018.
 */
public class DetailsActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE = "EXTRA_MOVIE";

    @BindView(R.id.image) AppCompatImageView image;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.desc) TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        DetailsViewModel viewModel = createViewModel();

        viewModel.getMovie().observe(this, new MovieObserver());

        viewModel.loadMovieData();
    }

    private DetailsViewModel createViewModel() {
        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        DetailsViewModelFactory factory = new DetailsViewModelFactory(movie);
        return ViewModelProviders.of(this,factory).get(DetailsViewModel.class);
    }

    private class MovieObserver implements Observer<Movie> {
        @Override
        public void onChanged(@Nullable Movie movie) {
            if (movie == null) return;

            title.setText(movie.getTitle());
            desc.setText(movie.getDescription());
            Glide.with(getApplicationContext()).load(movie.getImage()).into(image);
        }
    }

}
