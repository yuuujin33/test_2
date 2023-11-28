package com.mysite.test_2.article;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (length = 200)
    private String subject;

    @Column (columnDefinition = "TEXT")
    private String content;
}
