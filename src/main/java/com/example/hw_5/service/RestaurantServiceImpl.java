package com.example.hw_5.service;

import com.example.hw_5.dao.RestaurantRepository;
import com.example.hw_5.entity.Restaurant;
import com.example.hw_5.exception.IncorrectEmailAddressException;
import com.example.hw_5.util.EmailUtil;
import com.example.hw_5.util.PhoneUtil;
import com.google.i18n.phonenumbers.NumberParseException;
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
        String phone = restaurant.getPhoneNumber();
        if (phone == null || phone.equals("absent")) {
            restaurant.setPhoneNumber("absent");
        } else {
            try {
                restaurant.setPhoneNumber(PhoneUtil.reformatRuTelephone(phone));
            } catch (NumberParseException e) {
                e.printStackTrace();
            }
        }
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

    @Override
    public void addPhoneByRestaurantName(String name, String phone) {
        Restaurant restaurant = restaurantRepository.findRestaurantByName(name);
        try {
            restaurant.setPhoneNumber(PhoneUtil.reformatRuTelephone(phone));
            restaurantRepository.save(restaurant);
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEmailAddressByName(String name, String emailAddress) {
        Restaurant restaurant = restaurantRepository.findRestaurantByName(name);
        if (EmailUtil.checkValid(emailAddress)) {
            restaurant.setEmailAddress(emailAddress);
            restaurantRepository.save(restaurant);
        } else {
            try {
                throw new IncorrectEmailAddressException("write correct Email Address");
            } catch (IncorrectEmailAddressException e) {
                e.printStackTrace();
            }
        }
    }
}
