package dev.AnuragPathak.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payLoad) {
        return new ResponseEntity<Review>(reviewService.createReview(payLoad.get("reviewBody"), payLoad.get("imdbId")), HttpStatus.CREATED);
    }
    //ResponseEntity is a class that represents an HTTP response, including headers, body, and status
    //We use so that we can give proper response codes, so that we know if our request was successful or not

//    @DeleteMapping
//    public ResponseEntity<String> deleteReview(@RequestBody Map<String,String> payLoad)
//    {
//        reviewService.deleteReview(payLoad.get("reviewBody"),payLoad.get("imdbId"));
//        return new ResponseEntity<String>("Review Deleted",HttpStatus.OK);
//    }
}
