package com.demo.caching.domain;

public record NewsSource (String id,
     String name,
     String description,
     String url,
     String category,
     String language,
     String country
) { }
