package com.isc.iscnews.config;

import com.isc.iscnews.model.News;
import com.isc.iscnews.model.dto.NewsRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class WebProxy {

    private final WebClient webClient;

    @Value("${newsApi.url}")
    private String url;

    @Value("${newsApi.apiKey}")
    private String apiKey;

    public WebProxy(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<List<News>> getNewsReactive(NewsRequestDto newsRequestDto){
        return webClient.get()
                .uri(url)
                .header(newsRequestDto.getCountry(),newsRequestDto.getCategory())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<News>>() {});
    }

}
