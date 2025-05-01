package com.kosa.matzip.service;

import com.kosa.matzip.domain.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant selectById(int id);
    public List<Restaurant> selectAll();
    public void insert(Restaurant restaurant);
    public void updateById(Restaurant restaurant);
    public void deleteById(int id);
}
