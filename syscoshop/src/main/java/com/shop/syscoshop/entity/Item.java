package com.shop.syscoshop.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long itemId;

    @Column(nullable = false)
    private Float quantity;

    @Column(nullable = false)
    private Float price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
