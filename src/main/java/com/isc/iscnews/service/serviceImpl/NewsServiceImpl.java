package com.isc.iscnews.service.serviceImpl;

import com.isc.iscnews.model.News;
import com.isc.iscnews.model.dto.NewsRequestDto;
import com.isc.iscnews.repository.NewsRepo;
import com.isc.iscnews.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepo newsRepo;

    public NewsServiceImpl(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }

    @Override
    public List<News> getNews(NewsRequestDto newsRequestDto) {
        List<News> news = newsRepo.findAllByCountryAndCategory(newsRequestDto.getCountry(), newsRequestDto.getCategory());
        return news;
    }
}
