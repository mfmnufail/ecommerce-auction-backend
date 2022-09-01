package com.shop.syscoshop.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Entity
public class Product {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue()
    private UUID id;

    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private String category;





}
