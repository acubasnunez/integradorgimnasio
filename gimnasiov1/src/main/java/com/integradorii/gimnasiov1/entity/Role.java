package com.integradorii.gimnasiov1.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idroles")
    private Long idroles;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(length = 255)
    private String description;
}

