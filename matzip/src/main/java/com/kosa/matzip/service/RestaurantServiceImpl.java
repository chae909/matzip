package com.kosa.matzip.service;

import com.kosa.matzip.domain.Menu;
import com.kosa.matzip.domain.Restaurant;
import com.kosa.matzip.mapper.MenuMapper;
import com.kosa.matzip.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantMapper mapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Restaurant selectById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Restaurant> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void insert(Restaurant restaurant) {
        mapper.insert(restaurant);
        // 2. 생성된 restaurant ID를 가져와 메뉴에 설정하고 저장
        if (restaurant.getMenus() != null) {
            for (Menu menu : restaurant.getMenus()) {
                menu.setRestaurant_id(restaurant.getId()); // 외래키 설정
                menuMapper.insert(menu);
            }
        }
    }

    @Override
    public void updateById(Restaurant restaurant) {
        mapper.updateById(restaurant);
    }

    @Override
    public void deleteById(int id) {
        mapper.deleteById(id);
    }
}
