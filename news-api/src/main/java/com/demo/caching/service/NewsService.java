package com.demo.caching.service;

import com.demo.caching.domain.NewsArticleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Value("${news.api.key}")
    private String newsApiKey;
    @Value("${news.api.url}")
    private String newsApiUrl;
    @Autowired
    private OkHttpClient okHttpClient;
    @Autowired
    private ObjectMapper objectMapper;


    @Cacheable("news_search")
    public NewsArticleResponse searchNews(String country, String category) throws IOException {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(newsApiUrl).newBuilder();
        httpBuilder.addQueryParameter("country", country);
        httpBuilder.addQueryParameter("category", category);
        httpBuilder.addQueryParameter("apiKey", newsApiKey);
        Request request = new Request.Builder().url(httpBuilder.build().toString()).build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return objectMapper.readValue(response.body().string(), NewsArticleResponse.class);
        }
    }

}
