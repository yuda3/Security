package com.group.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;
    private String author;
    private int page;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookImage> bookImages;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Cart> cart;
}
