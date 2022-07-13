package com.example.hw_5.service;

import com.example.hw_5.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    String getDescriptionByName(String name);
    List<Restaurant> getAllRestaurants();
    void addRestaurant(Restaurant restaurant);
    void updateDescriptionByName(String name, String description);
    Restaurant findRestaurantByName(String name);
}
