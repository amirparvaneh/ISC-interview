package com.isc.iscnews.controller;

import com.isc.iscnews.model.News;
import com.isc.iscnews.model.dto.NewsRequestDto;
import com.isc.iscnews.service.serviceImpl.NewsServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@OpenAPIDefinition(tags = {@Tag(name = "newsApi", description = "finding news by country and category with webflux")})
public class NewsController {

    private final NewsServiceImpl newsServiceImpl;

    public NewsController(NewsServiceImpl newsServiceImpl) {
        this.newsServiceImpl = newsServiceImpl;
    }

//    @GetMapping
//    public Mono<List<News>> getNews(@RequestParam String country, @RequestParam String category) throws Exception {
//        NewsRequestDto newsRequestDto = NewsRequestDto.builder()
//                .country(country)
//                .category(category)
//                .build();
//        return newsServiceImpl.getNews(newsRequestDto);
//    }

    @GetMapping
    public List<News> getNews(@RequestParam String country,@RequestParam String category){
        NewsRequestDto newsRequestDto = NewsRequestDto.builder()
                .country(country)
                .category(category)
                .build();
        return newsServiceImpl.getNewsWithFeign(newsRequestDto);
    }

}
