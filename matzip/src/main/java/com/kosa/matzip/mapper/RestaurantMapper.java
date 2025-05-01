package com.kosa.matzip.mapper;

import com.kosa.matzip.domain.Restaurant;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RestaurantMapper {
    Restaurant selectById(int id);
    List<Restaurant> selectAll();
    void insert(Restaurant restaurant);
    void updateById(Restaurant restaurant);
    void deleteById(int id);
}