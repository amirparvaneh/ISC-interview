package com.isc.iscnews.service;


import com.isc.iscnews.model.News;
import com.isc.iscnews.model.dto.NewsRequestDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface NewsService {
    Mono<List<News>> getNews(NewsRequestDto newsRequestDto);
    List<News> getNewsByRestTemplate(String country,String category);
}
