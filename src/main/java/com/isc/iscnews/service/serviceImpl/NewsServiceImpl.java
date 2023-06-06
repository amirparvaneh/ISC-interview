package com.isc.iscnews.service.serviceImpl;

import com.isc.iscnews.config.WebProxy;
import com.isc.iscnews.model.News;
import com.isc.iscnews.model.dto.NewsRequestDto;
import com.isc.iscnews.proxy.OpenFeignProxy;
import com.isc.iscnews.repository.NewsRepo;
import com.isc.iscnews.service.NewsService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepo newsRepo;

    private final WebProxy webProxy;

    private final OpenFeignProxy openFeignProxy;

    public NewsServiceImpl(NewsRepo newsRepo,WebProxy webProxy,OpenFeignProxy openFeignProxy) {
        this.newsRepo = newsRepo;
        this.webProxy = webProxy;
        this.openFeignProxy = openFeignProxy;
    }

    @Override
    public Mono<List<News>> getNews(NewsRequestDto newsRequestDto) {
        Mono<List<News>> news = webProxy.getNewsReactive(newsRequestDto);
        return news;
    }

    @Override
    public List<News> getNewsByOpenFeign(String country, String category) {
        return openFeignProxy.getNewsByFeign(country,category);
    }


}
