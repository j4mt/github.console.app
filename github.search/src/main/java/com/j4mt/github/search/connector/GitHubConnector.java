package com.j4mt.github.search.connector;

import com.j4mt.github.search.model.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubConnector {

    @Autowired
    private RestTemplate restTemplate;

    public Repositories searchRepo(String query, String perPage) {

        return restTemplate.getForObject("https://api.github.com/search/repositories?q={query}&sort=stars&order=desc&per_page={perPage}", Repositories.class, query, perPage.toString());
    }
}
