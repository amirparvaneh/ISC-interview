package com.isc.iscnews.service;


import com.isc.iscnews.model.News;
import com.isc.iscnews.model.dto.NewsRequestDto;

import java.util.List;

public interface NewsService {
    List<News> getNews(NewsRequestDto newsRequestDto);
}
