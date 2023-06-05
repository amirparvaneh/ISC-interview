package com.isc.iscnews.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String sourceId;
    private String sourceName;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    //additional field
    private String country;
    private String category;
}
