package com.j4mt.github.search;

import com.j4mt.github.search.connector.GitHubConnector;
import com.j4mt.github.search.model.Repositories;
import com.j4mt.github.search.util.ArgParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private GitHubConnector gitHubConnector;

    public Application() {
    }

    public static void main(String... argv) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(argv);
    }

    @Override
    public void run(String... argv) {

        ArgParser argParser = new ArgParser();
        argParser.parse(argv);
        if(argParser.isValid())
            System.out.println(gitHubConnector.searchRepo(argParser.get("--searchRepo"), argParser.getOrDefault("--perPage", "10")));
    }
}
