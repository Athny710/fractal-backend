package com.example.fractal.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

// Entidad que representa a la tabla "tb_user"

@Data
@Entity
@Table(name = "tb_user")
@AllArgsConstructor @NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre es un campo obligatorio")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "El email es un campo obligatorio")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "El estado es un campo obligatorio")
    private int status;

}
