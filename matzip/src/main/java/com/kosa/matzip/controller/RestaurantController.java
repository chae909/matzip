package com.kosa.matzip.controller;

import com.kosa.matzip.domain.Menu;
import com.kosa.matzip.domain.Restaurant;
import com.kosa.matzip.domain.Review;
import com.kosa.matzip.service.MenuService;
import com.kosa.matzip.service.RestaurantService;
import com.kosa.matzip.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MenuService menuService;

    // 메인 페이지 (맛집 목록)
    @GetMapping({"/", "/restaurants"})
    public String index(Model model) {
        List<Restaurant> restaurants = service.selectAll();
        model.addAttribute("restaurants", restaurants);
        return "restaurant/index";
    }

    // 맛집 등록 폼
    @GetMapping("/restaurant/new")
    public String createForm() {
        return "restaurant/new";
    }

    // 맛집 등록 처리
    @PostMapping("/restaurant")
    public String create(@ModelAttribute Restaurant restaurant) {
        service.insert(restaurant);
        return "redirect:/restaurants";
    }

    // 맛집 상세 정보
    @GetMapping("/restaurant/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Restaurant restaurant = service.selectById(id);
        if (restaurant == null) {
            return "redirect:/restaurants";
        }
        // 메뉴정보 가져오기
        List<Menu> menus = menuService.selectById(id);
        restaurant.setMenus(menus);
        // 리뷰 정보 가져오기
        List<Review> reviews = reviewService.selectByRestaurantId(id);

        model.addAttribute("restaurant", restaurant);
        model.addAttribute("reviews", reviews);
        return "restaurant/detail";
    }

    // 맛집 수정 폼
    @GetMapping("/restaurant/{id}/edit")
    public String editForm(@PathVariable int id, Model model) {
        Restaurant restaurant = service.selectById(id);
        if (restaurant == null) {
            return "redirect:/restaurants";
        }
        model.addAttribute("restaurant", restaurant);
        return "restaurant/edit";
    }

    // 맛집 수정 처리
    @PostMapping("/restaurant/{id}")
    public String update(@PathVariable int id,
                         @ModelAttribute Restaurant restaurant) {
        restaurant.setId(id);
        service.updateById(restaurant);
        return "redirect:/restaurant/detail/" + id;
    }

    // 맛집 삭제
    @PostMapping("/restaurant/{id}/delete")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/restaurants";
    }
}
