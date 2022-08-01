package com.example.hw_5.service;

import com.example.hw_5.entity.Review;

import java.util.List;

public interface ReviewService {

    List<String> getReviewsByRestaurantName(String name);

    double getRatingByRestaurantName(String name);

    void addReview(Review review);

    void updateReviewByRestaurantId(int id, String review);
}
