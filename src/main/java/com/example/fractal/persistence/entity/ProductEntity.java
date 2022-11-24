package com.example.fractal.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

// Entidad que representa la tabla "tb_product"

@Data
@Entity
@Table(name = "tb_product")
@AllArgsConstructor @NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre es un campo obligatorio")
    private String name;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private int status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category", nullable = false)
    private CategoryEntity category;
}
