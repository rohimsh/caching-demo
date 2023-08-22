package com.demo.caching.domain;

import java.io.Serializable;
import java.util.List;

public record NewsArticleResponse(String status, int totalResults, List<NewsArticle> articles) implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;
}
