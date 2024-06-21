package com.group.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookImage {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="book_id", nullable = false)
    private Book book;
    private int type;
    private String path;
}
