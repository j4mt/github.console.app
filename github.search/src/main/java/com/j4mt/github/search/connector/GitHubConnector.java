package com.j4mt.github.search.connector;

import com.j4mt.github.search.model.Repositories;
import com.j4mt.github.search.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubConnector {

    @Autowired
    private RestTemplate restTemplate;

    public Repositories searchRepo(String query, String perPage) {

        return restTemplate.getForObject("https://api.github.com/search/repositories?q={query}&sort=stars&order=desc&per_page={perPage}", Repositories.class, query, perPage);
    }

    public Tag[] getLatestTagForRepo(String userName, String repoName, String perPage) {

        return restTemplate.getForObject("https://api.github.com/repos/{userName}/{repoName}/tags?per_page={perPage}", Tag[].class, userName, repoName, perPage);
    }
}
