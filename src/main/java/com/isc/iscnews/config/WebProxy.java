package com.isc.iscnews.config;

import com.isc.iscnews.model.News;
import com.isc.iscnews.model.dto.NewsRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class WebProxy {

    private final Logger log = LoggerFactory.getLogger(WebProxy.class);

    private final WebClient webClient;

    @Value("${newsApi.url}")
    private String url;

    public WebProxy(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<List<News>> getNewsReactive(NewsRequestDto newsRequestDto) throws Exception {
        String uriString = getString(newsRequestDto);
        log.warn(uriString+"##");
        try{
            Mono<List<News>> monoResponse=webClient.get()
                    .uri(url)
                    .header(uriString)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<News>>() {
                    });
            return monoResponse;
        }catch (Exception e){
            throw new Exception(e.getCause());
        }
    }

    private String getString(NewsRequestDto newsRequestDto) {
        String uriString = UriComponentsBuilder.fromUriString(url)
                .queryParam("country", newsRequestDto.getCountry())
                .queryParam("category", newsRequestDto.getCategory())
                .queryParam("apiKey", newsRequestDto.getApiKey())
                .toUriString();
        return uriString;
    }

}
