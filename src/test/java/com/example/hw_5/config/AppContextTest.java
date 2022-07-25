package com.example.hw_5.config;

import com.example.hw_5.Hw5Application;
import com.example.hw_5.controller.RestaurantController;
import com.example.hw_5.dao.RestaurantRepository;
import com.example.hw_5.entity.Restaurant;
import com.example.hw_5.entity.Review;
import com.example.hw_5.service.RestaurantServiceImpl;
import com.example.hw_5.service.ReviewService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        Hw5Application.class})
@ActiveProfiles("test")
public class AppContextTest {

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private RestaurantController restaurantController;

    @BeforeEach
    void addRestaurantsAndReviewsInDB() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("mac");
        restaurant.setDescription("burgers");
        restaurantService.addRestaurant(restaurant);
//        Review review = new Review();
//        review.setReview("best place");
//        review.setRestaurant_id(restaurant);
//        review.setRating(5);
//        reviewService.addReview(review);
    }

    @AfterEach
    void cleanTable() {
        restaurantRepository.deleteAll();
    }

    @Test
    void findRestaurantByName() throws Exception {
        String name = "mac";
        String newName = restaurantService.findRestaurantByName(name).getName();
        assertEquals(name, newName);
    }

    @Test
    void getAllRestaurants() {
        assertNotNull(restaurantService.getAllRestaurants());
        assertEquals("mac", restaurantService.getAllRestaurants().get(0).getName());
        assertEquals("burgers", restaurantService.getAllRestaurants().get(0).getDescription());
        assertEquals("absent", restaurantService.getAllRestaurants().get(0).getPhoneNumber());
    }

    @Test
    void updateDescriptionByName() {
        String newDescription = "best burgers";
        restaurantService.updateDescriptionByName("mac", newDescription);
        assertEquals(newDescription, restaurantService.getDescriptionByName("mac"));
    }


    @Test
    void addPhoneByRestaurantName() {
        String phone = "+79998887766";
        restaurantService.addPhoneByRestaurantName("mac" ,phone);
        assertEquals(phone, restaurantService.findRestaurantByName("mac").getPhoneNumber());
    }



//    @Test
//    void getReviewsByName() {
//        String review = "best place";
//        System.out.println(reviewService.getReviewsByName("mac"));
//        assertEquals(review, reviewService.getReviewsByName("mac").get(0));
//    }

}