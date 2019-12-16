package com.j4mt.github.search;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterDescription;
import com.beust.jcommander.ParameterException;
import com.j4mt.github.search.service.HelloService;
import com.j4mt.github.search.service.SearchService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    @Parameter(names = {"--searchUser", "-su"}, description = "Search User")
    String user;
    @Parameter(names = {"--SearchRepo", "-sr"}, description = "Search repository")
    String repo;

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
        ConsoleApplication consoleApplication = new ConsoleApplication(new HelloService());
        JCommander jCommander = new JCommander(this);
        if (argv.length > 0) {
            try {
                jCommander.parse(argv);
            } catch (ParameterException pe) {
                System.err.println(pe.getMessage());
            }
            for (ParameterDescription cmd : jCommander.getParameters()) {
                System.out.println("Parameter " + cmd.getDescription());
            }

        } else {
            System.out.println(helloService.getMessage());
        }
    }
}
