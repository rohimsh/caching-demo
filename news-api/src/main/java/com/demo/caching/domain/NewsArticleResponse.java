package com.demo.caching.domain;

import java.util.List;

public record NewsArticleResponse(String status, int totalResults, List<NewsArticle> articles) {
}
