package com.isc.iscnews.proxy;

import com.isc.iscnews.model.News;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class NewsProxy {

    private final RestTemplate restTemplate;

    @Value("${newsApi.url}")
    private String url;

    @Value("${newsApi.apiKey}")
    private String apiKey;

    public NewsProxy(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<News> getNewsByRestTemplate(String country, String category){
        HttpHeaders headers = new HttpHeaders();
        headers.set("country", country);
        headers.set("category", category);
        headers.set("api", apiKey);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<List<News>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<>() {
                }
        );
        return responseEntity.getBody();
    }
}
