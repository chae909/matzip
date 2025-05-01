package com.kosa.matzip.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int id;
    private int restaurant_id;
    private String name;
    private int price;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
