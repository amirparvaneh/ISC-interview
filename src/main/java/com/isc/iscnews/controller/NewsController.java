package com.isc.iscnews.controller;

import com.isc.iscnews.model.News;
import com.isc.iscnews.model.dto.NewsRequestDto;
import com.isc.iscnews.service.serviceImpl.NewsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    private final NewsServiceImpl newsServiceImpl;

    public NewsController(NewsServiceImpl newsServiceImpl) {
        this.newsServiceImpl = newsServiceImpl;
    }

    @RequestMapping
    public ResponseEntity<List<News>> getNews(@RequestParam String country, @RequestParam String category) {
        NewsRequestDto newsRequestDto = NewsRequestDto.builder()
                .country(country)
                .category(category)
                .build();
        List<News> news = newsServiceImpl.getNews(newsRequestDto);
        if (news.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(news, HttpStatus.OK);
        }
    }
}
