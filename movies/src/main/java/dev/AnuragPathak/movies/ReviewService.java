package dev.AnuragPathak.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired // This is a constructor injection
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId) {

        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        // This is a query to update the reviewIds Array in the Movie database
        return review;

    }
//    public void deleteReview(String reviewId, String imdbId) {
//        reviewRepository.deleteById(reviewId);
//        mongoTemplate.update(Movie.class)
//                .matching(Criteria.where("imdbId").is(imdbId))
//                .apply(new Update().pull("reviewId", reviewId))
//    }
}
