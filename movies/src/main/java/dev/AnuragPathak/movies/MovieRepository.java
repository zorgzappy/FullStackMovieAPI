package dev.AnuragPathak.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    //Spring data MongoDB will automatically implement this method
    Optional<Movie> findMovieByImdbId(String imdbId);


}
