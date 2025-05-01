package com.kosa.matzip.controller;

import com.kosa.matzip.domain.Review;
import com.kosa.matzip.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService service;

    // 리뷰 작성
    @PostMapping("/add")
    public String addReview(@RequestBody Review review) {
        System.out.println("restaurant_id: " + review.getRestaurant_id());
        System.out.println("content: " + review.getContent());
        System.out.println("score: " + review.getScore());
        service.insert(review);
        return "redirect:/restaurant/detail/" + review.getRestaurant_id();
    }

    // 리뷰 수정 폼
    @GetMapping("/edit/{id}")
    public String editReviewForm(@PathVariable("id") int id, Model model) {
        Review review = service.selectById(id);
        if (review == null) {
            return "redirect:/restaurant/";
        }
        model.addAttribute("review", review);
        return "review/edit";
    }

    // 리뷰 수정 처리
    @PostMapping("/edit")
    public String updateReview(Review review) {
        service.updateById(review);
        return "redirect:/restaurant/detail/" + review.getRestaurant_id();
    }


    // 리뷰 삭제
    @PostMapping("/delete/{id}")
    public String deleteReview(@PathVariable("id") int id,
                               @RequestParam("restaurant_id") int restaurant_id) {
        service.deleteById(id);
        return "redirect:/restaurant/detail/" + restaurant_id;
    }
}
