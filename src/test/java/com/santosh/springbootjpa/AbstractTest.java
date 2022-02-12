package com.santosh.springbootjpa;

import org.springframework.web.client.RestTemplate;

public abstract class AbstractTest {
    public static final String BASE_URL = "http://localhost:8084";

    protected RestTemplate restTemplate;

    public AbstractTest() {
        this.restTemplate = restTemplate();
    }

    private RestTemplate restTemplate() {
        return new RestTemplate();
    }

    protected String buildPath(String path) {
        return BASE_URL + "/" + path;
    }
}
