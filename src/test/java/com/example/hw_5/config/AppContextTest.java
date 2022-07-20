package com.example.hw_5.config;

import com.example.hw_5.Hw5Application;
import com.example.hw_5.service.RestaurantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
        Hw5Application.class,
        H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class AppContextTest {

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @Test
    void contextLoads() {
    }

    @Test
    void getRestaurantById() {
        String name = "lolo";
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setDescription("apapapa");
        restaurantService.addRestaurant(restaurant);
        String newName = restaurantService.getDescriptionByName("lolo");
        Assertions.assertEquals("apapapa", newName);
    }
}
