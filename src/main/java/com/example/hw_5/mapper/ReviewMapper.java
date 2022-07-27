package com.example.hw_5.mapper;

import com.example.hw_5.dto.out.ReviewOutDTO;
import com.example.hw_5.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewOutDTO reviewToReviewOutDTO(Review review);
}
