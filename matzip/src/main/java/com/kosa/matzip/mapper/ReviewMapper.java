package com.kosa.matzip.mapper;

import com.kosa.matzip.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReviewMapper {
    Review selectById(int id);
    List<Review> selectByRestaurantId(int restaurant_id);
    List<Review> selectAll();
    void insert(Review review);
    void updateById(Review review);
    void deleteById(int id);
}
