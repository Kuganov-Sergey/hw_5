package com.example.hw_5.mapper;

import com.example.hw_5.dto.out.RestaurantOutDTO;
import com.example.hw_5.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    @Mapping(target = "restaurantName", source = "restaurant.name")
    RestaurantOutDTO restaurantToRestaurantOutDTO(Restaurant restaurant);
}
