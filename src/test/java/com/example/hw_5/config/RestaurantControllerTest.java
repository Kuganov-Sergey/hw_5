package com.example.hw_5.config;

import com.example.hw_5.dto.out.RestaurantOutDTO;
import com.example.hw_5.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class RestaurantControllerTest extends AppContextTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestaurantService restaurantService;

    @Test
    void getAll() throws Exception {
        ObjectMapper objectMapper = new JsonMapper();
        String expected = objectMapper.writeValueAsString(restaurantService.getAllRestaurants());
        this.mockMvc.perform(get("/restaurant/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void descriptionByName() throws Exception {
        String expected = restaurantService.getDescriptionByName("mac");
        this.mockMvc.perform(get("/restaurant/description/{name}", "mac"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void addRestaurants() throws Exception {
        RestaurantOutDTO restaurant = RestaurantOutDTO.builder()
                .description("burgers")
                .phoneNumber("absent")
                .emailAddress(null)
                .name("mac")
                .build();
        ObjectMapper objectMapper = new JsonMapper();
        String obj = objectMapper.writeValueAsString(restaurant);
        this.mockMvc.perform(post("/restaurant/new")
                        .contentType(MediaType.APPLICATION_JSON).content(obj))
                .andExpect(status().isOk());
    }

    @Test
    void updateDescription() throws Exception {
        this.mockMvc.perform(put("/restaurant/update/{name}/{description}", "mac", "description"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findRestaurantByName() throws Exception {
        RestaurantOutDTO restaurant = RestaurantOutDTO.builder()
                .id(restaurantService.getAllRestaurants().get(0).getId())
                .description("burgers")
                .phoneNumber("+79997771122")
                .emailAddress(null)
                .name("mac")
                .build();
        ObjectMapper objectMapper = new JsonMapper();
        String expected = objectMapper.writeValueAsString(restaurant);
        this.mockMvc.perform(get("/restaurant/{name}", "mac"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

}
