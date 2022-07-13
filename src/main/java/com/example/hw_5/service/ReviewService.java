package com.example.hw_5.service;

import com.example.hw_5.entity.Review;

import java.util.List;

public interface ReviewService {

    List<String> getReviewsByName(String name);
    double getRatingByName(String name);
    void addReview(Review review);
    void updateReview(int id, String review);
}
