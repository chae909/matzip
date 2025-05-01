package com.kosa.matzip;

import com.kosa.matzip.domain.Restaurant;
import com.kosa.matzip.domain.Review;
import com.kosa.matzip.mapper.RestaurantMapper;
import com.kosa.matzip.mapper.ReviewMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Commit  // 이 어노테이션을 사용하면 트랜잭션이 커밋됩니다
public class DatabaseInsertTest {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    @Test
    public void insertTestData() {
        // 레스토랑 데이터 생성 및 삽입
        Restaurant restaurant = Restaurant.builder()
                .name("맛있는 한식당")
                .address("서울시 강남구 테헤란로 123")
                .build();
        restaurantMapper.insert(restaurant);
        System.out.println("저장된 레스토랑 ID: " + restaurant.getId());

        // 리뷰 데이터 생성 및 삽입
        Review review = Review.builder()
                .restaurant_id(restaurant.getId())
                .content("정말 맛있어요! 특히 김치찌개가 일품입니다.")
                .score(5)
                .build();
        reviewMapper.insert(review);
        System.out.println("저장된 리뷰 ID: " + review.getId());
    }
}