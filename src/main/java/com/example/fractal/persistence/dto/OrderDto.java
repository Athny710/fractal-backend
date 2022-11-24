package com.example.fractal.persistence.dto;

import com.example.fractal.persistence.entity.UserEntity;
import lombok.Data;

@Data
public class OrderDto {

    private Long id;
    private String status;
    private UserEntity user;
    private float total;

}
