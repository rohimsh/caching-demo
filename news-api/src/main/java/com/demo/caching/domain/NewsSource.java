package com.demo.caching.domain;

import java.io.Serializable;

public record NewsSource (String id,
                          String name,
                          String description,
                          String url,
                          String category,
                          String language,
                          String country) implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;
}
