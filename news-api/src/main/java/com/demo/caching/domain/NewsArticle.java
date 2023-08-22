package com.demo.caching.domain;

import java.io.Serializable;

public record NewsArticle(NewsSource source,
                          String author,
                          String title,
                          String description,
                          String url,
                          String urlToImage,
                          String publishedAt,
                          String content) implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;
}
