package com.j4mt.github.search;

import com.j4mt.github.search.connector.GitHubConnector;
import com.j4mt.github.search.model.Repositories;
import com.j4mt.github.search.model.Repository;
import com.j4mt.github.search.model.Tag;
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

        if (argv.length == 2) {

            Repository repository = gitHubConnector.searchRepo(argv[0], "1").getItems().get(0);
            System.out.println("Name : " + repository.getName() + ", Stars : " + repository.getStargazersCount());

            Tag[] tags = gitHubConnector.getLatestTagForRepo(repository.getOwner().getLogin(), repository.getName(), "1");
            if (tags[0].getName().equalsIgnoreCase(argv[1]))
                System.out.println("Search Tag is Latest");
            else
                System.out.println("Search Tag is not Latest");
        }
    }
}
