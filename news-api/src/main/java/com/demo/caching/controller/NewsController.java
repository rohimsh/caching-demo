package com.demo.caching.controller;

import com.demo.caching.domain.NewsArticleResponse;
import com.demo.caching.domain.NewsData;
import com.demo.caching.service.NewsService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news-api/v0")

public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/search")
    public NewsData getNews(@RequestParam("country") String country, @RequestParam("category") String category) throws IOException {
        return new NewsData(newsService.getNews(country, category), false);
    }
}
