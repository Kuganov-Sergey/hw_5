package com.example.hw_5.controller;

import com.example.hw_5.entity.Review;
import com.example.hw_5.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{name}")
    public List<String> getReviewsByName(@PathVariable String name) {
        return reviewService.getReviewsByName(name);
    }

    @GetMapping("/rating/{name}")
    public double getRatingByName(@PathVariable String name) {
        return reviewService.getRatingByName(name);
    }

    @PutMapping("/new")
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
    }
}
