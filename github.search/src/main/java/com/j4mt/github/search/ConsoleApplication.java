package com.j4mt.github.search;

import com.j4mt.github.search.service.HelloService;
import com.j4mt.github.search.service.SearchService;
import com.j4mt.github.search.util.ArgParser;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    private HelloService helloService;

    private SearchService searchService;

    public ConsoleApplication(HelloService helloService) {
        this.helloService = helloService;
    }

    public static void main(String... argv) {

        SpringApplication app = new SpringApplication(ConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(argv);
    }

    @Override
    public void run(String... argv) {

        ArgParser argParser = new ArgParser();
        argParser.parse(argv);
        System.out.println(argParser);
    }
}
