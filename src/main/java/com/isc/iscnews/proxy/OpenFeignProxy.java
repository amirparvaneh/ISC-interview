package com.isc.iscnews.proxy;


import com.isc.iscnews.model.News;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "OpenFeignProxy", url = "${newsApi.url}")
public interface OpenFeignProxy {

    @GetMapping(value = "/api")
    List<News> getNewsByFeign(@RequestParam String country, @RequestParam String category);
}
