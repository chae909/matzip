package com.kosa.matzip.service;

import com.kosa.matzip.domain.Review;

import java.util.List;

public interface ReviewService {
    public Review selectById(int id);
    public List<Review> selectAll();
    public List<Review> selectByRestaurantId(int id);
    public void insert(Review review);
    public void updateById(Review review);
    public void deleteById(int id);
}
