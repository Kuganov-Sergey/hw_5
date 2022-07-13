package com.example.hw_5.service;

import com.example.hw_5.dao.ReviewRepository;
import com.example.hw_5.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<String> getReviewsByName(String name) {
        return reviewRepository.getReviewsByName(name);
    }

    @Override
    public double getRatingByName(String name) {
        return reviewRepository.getRatingByName(name);
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(int id, String review) {
        Optional<Review> reviewNewObject = reviewRepository.findById(id);
        if (reviewNewObject.isPresent()) {
            reviewNewObject.get().setReview(review);
            reviewRepository.save(reviewNewObject.get());
        }
    }
}
