package com.example.hw_5.mapper;

import com.example.hw_5.dto.out.RestaurantOutDTO;
import com.example.hw_5.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantOutDTO restaurantToRestaurantOutDTO(Restaurant restaurant);
}
