package com.example.hw_5.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantOutDTO {

    private int id;
    private String restaurantName;
    private String description;
    private String emailAddress;
    private String phoneNumber;

//    public RestaurantOutDTO(int id, String description) {
//        this.id = id;
//        this.description = description;
//        this.emailAddress = "default";
//        this.phoneNumber = "default";
//        this.name = "default";
//    }
}
