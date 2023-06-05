package com.isc.iscnews.repository;


import com.isc.iscnews.model.News;
import org.reactivestreams.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepo extends JpaRepository<News,Long> {
    List<News> findAllByCountryAndCategory(
            @Param("country")String country,
            @Param("category")String category
    );
}
