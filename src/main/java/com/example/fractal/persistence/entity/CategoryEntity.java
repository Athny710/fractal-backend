package com.example.fractal.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

// Entidad que representa a la tabla "tb_category"

@Data
@Entity
@Table(name = "tb_category")
@AllArgsConstructor @NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre es un campo obligatorio")
    private String name;

    @Column(nullable = false)
    private int status;
}
