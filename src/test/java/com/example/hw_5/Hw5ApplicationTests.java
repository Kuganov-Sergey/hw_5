package com.example.hw_5;

import com.example.hw_5.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class Hw5ApplicationTests {

    @Autowired
    private RestaurantService restaurantService;

}
