package com.kosa.matzip.domain;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private int id;
    private int restaurant_id;
    private String content;
    private Integer score;
    private LocalDateTime created_at;
}