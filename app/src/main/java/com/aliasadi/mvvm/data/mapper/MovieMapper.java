package com.aliasadi.mvvm.data.mapper;

import com.aliasadi.mvvm.data.domain.Movie;
import com.aliasadi.mvvm.data.model.MovieRemote;

/**
 * Created by Ali Asadi on 05/04/2021
 */
public class MovieMapper {

    public static Movie toDomain(MovieRemote movieRemote) {
        return new Movie(movieRemote.getId(), movieRemote.getDescription(),
                movieRemote.getImage(), movieRemote.getTitle());
    }

    public static MovieRemote toModel(Movie pMovie){
        MovieRemote lMovieRemote = new MovieRemote();
        lMovieRemote.setId(pMovie.getId());
        lMovieRemote.setTitle(pMovie.getTitle());
        lMovieRemote.setDescription(pMovie.getDescription());
        lMovieRemote.setImage(pMovie.getImage());

        return lMovieRemote;
    }
}
