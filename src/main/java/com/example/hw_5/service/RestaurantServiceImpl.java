package com.example.hw_5.service;

import com.example.hw_5.dao.RestaurantRepository;
import com.example.hw_5.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public String getDescriptionByName(String name) {
        Restaurant restaurant = findRestaurantByName(name);
        return restaurant.getDescription();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void updateDescriptionByName(String name, String description) {
        Restaurant restaurant = findRestaurantByName(name);
        restaurant.setDescription(description);
        addRestaurant(restaurant);
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        return restaurantRepository.findRestaurantByName(name);
    }
}
