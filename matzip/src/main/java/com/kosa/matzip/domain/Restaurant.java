package com.kosa.matzip.domain;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private int id;
    private String name;
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private List<Menu> menus;
    private List<Review> reviews;
}