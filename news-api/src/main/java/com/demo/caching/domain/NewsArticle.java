package com.demo.caching.domain;

public record NewsArticle(NewsSource source,
                          String author,
                          String title,
                          String description,
                          String url,
                          String urlToImage,
                          String publishedAt,
                          String content) {
}
