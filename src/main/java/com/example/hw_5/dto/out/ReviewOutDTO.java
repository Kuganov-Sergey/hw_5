package com.example.hw_5.dto.out;

import com.example.hw_5.entity.Restaurant;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewOutDTO {

    private int id;
    private Restaurant restaurant_id;
    private String review;
    private double rating;
}
