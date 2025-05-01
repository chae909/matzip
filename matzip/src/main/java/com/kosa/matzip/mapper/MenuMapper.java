package com.kosa.matzip.mapper;

import com.kosa.matzip.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> findByRestaurantId(@Param("restaurant_id") int restaurant_id);
    void insert(Menu menu);
}