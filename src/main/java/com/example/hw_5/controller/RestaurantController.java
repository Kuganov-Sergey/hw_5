package com.example.hw_5.controller;

import com.example.hw_5.entity.Restaurant;
import com.example.hw_5.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/description/{name}")
    public String getDescriptionByName(@PathVariable String name) {
        Restaurant restaurant = findRestaurantByName(name);
        return restaurant.getDescription();
    }

    @PostMapping("/new")
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/update/{name}/{description}")
    public void updateDescriptionByName(@PathVariable String name, @PathVariable String description) {
        restaurantService.updateDescriptionByName(name, description);
    }

    @GetMapping("/{name}")
    public Restaurant findRestaurantByName(@PathVariable String name) {
        return restaurantService.findRestaurantByName(name);
    }
}
