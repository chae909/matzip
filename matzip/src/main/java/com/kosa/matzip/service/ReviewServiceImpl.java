package com.kosa.matzip.service;

import com.kosa.matzip.domain.Review;
import com.kosa.matzip.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper mapper;

    @Override
    public Review selectById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Review> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<Review> selectByRestaurantId(int id){
        return mapper.selectByRestaurantId(id);
    }

    @Override
    public void insert(Review review) {
        mapper.insert(review);
    }

    @Override
    public void updateById(Review review) {
        mapper.updateById(review);
    }

    @Override
    public void deleteById(int id) {
        mapper.deleteById(id);
    }
}
