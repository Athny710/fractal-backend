package com.example.fractal.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Entidad que representa a la tabla "tb_item" en donde se almacenan todos los productos por pedido

@Data
@Entity
@Table(name = "tb_item")
@AllArgsConstructor @NoArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "orderfk", nullable = false)
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product")
    private ProductEntity product;

    @Column(nullable = false)
    private int quantity;

}