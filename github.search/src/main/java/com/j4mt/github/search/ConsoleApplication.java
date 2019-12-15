package com.j4mt.github.search;

import com.j4mt.github.search.service.HelloService;
import com.j4mt.github.search.service.SearchService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    private HelloService helloService;

    private SearchService searchService;

    public ConsoleApplication(HelloService helloService) {
        this.helloService = helloService;
    }

    public static void main(String[] args) {
//		SpringApplication.run(ConsoleApplication.class, args);
        SpringApplication app = new SpringApplication(ConsoleApplication.class);
//         disable spring banner
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
//         check if the user passes any arguments
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("searchUser")) {
                System.out.println("In search user");
                ResponseEntity<String> response = searchService.searchUser(args[1]);
                //TODO: display User information in Console
            } else if (args[0].equalsIgnoreCase("searchRepo")) {
                System.out.println("In search Repo");
//				System.out.println(searchService.searchRepo(args[1]));
            } else {
                System.out.println(helloService.getMessage(args[0]));
            }

        } else {
            // print default message
            System.out.println(helloService.getMessage());
        }
    }
}
