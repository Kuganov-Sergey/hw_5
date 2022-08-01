package com.example.hw_5.service;

import com.example.hw_5.entity.Restaurant;
import com.example.hw_5.exception.FoundationDateIsExpiredException;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantService {

    String getDescriptionByName(String name);
    List<Restaurant> getAllRestaurants();
    void addRestaurant(Restaurant restaurant);
    void updateDescriptionByName(String name, String description);
    Restaurant findRestaurantByName(String name);
    void addPhoneByRestaurantName(String name, String phone);
    void addEmailAddressByName(String name, String emailAddress) throws FoundationDateIsExpiredException;
    void addRestaurantByNameAndCreationDate(String name, LocalDate creationDate) throws FoundationDateIsExpiredException;
    LocalDate getCreationDateByRestaurantName(String name);
}
