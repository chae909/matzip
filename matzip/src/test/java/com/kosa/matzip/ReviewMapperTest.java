package com.kosa.matzip;

import com.kosa.matzip.domain.Restaurant;
import com.kosa.matzip.domain.Review;
import com.kosa.matzip.mapper.RestaurantMapper;
import com.kosa.matzip.mapper.ReviewMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ReviewMapperTest {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    @Test
    public void testInsertAndSelect() {
        // 테스트용 레스토랑 생성
        Restaurant restaurant = Restaurant.builder()
                .name("맛있는 식당")
                .address("서울시 강남구")
                .build();
        restaurantMapper.insert(restaurant);

        // 테스트용 리뷰 생성
        Review review = Review.builder()
                .restaurant_id(restaurant.getId())
                .content("정말 맛있어요!")
                .score(5)
                .build();

        // 리뷰 삽입
        reviewMapper.insert(review);

        // ID가 생성되었는지 확인
        assertNotNull(review.getId());

        // 삽입된 리뷰 조회
        Review found = reviewMapper.selectById(review.getId());

        // 데이터 검증
        assertNotNull(found);
        assertEquals(review.getContent(), found.getContent());
        assertEquals(review.getScore(), found.getScore());
    }
}