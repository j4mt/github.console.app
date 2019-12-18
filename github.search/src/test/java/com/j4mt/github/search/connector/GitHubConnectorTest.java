package com.j4mt.github.search.connector;

import com.j4mt.github.search.model.Repositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class GitHubConnectorTest {

    @Autowired
    private GitHubConnector gitHubConnector;

    @Test
    public void test_GitHubConnector_searchRepo_for_1(){
        Repositories repositories = gitHubConnector.searchRepo("testng", 1);
        assertThat(repositories.size(), is(1));
    }

    @Test
    public void test_GitHubConnector_searchRepo_for_5(){
        Repositories repositories = gitHubConnector.searchRepo("testng", 5);
        assertThat(repositories.size(), is(5));
    }
}