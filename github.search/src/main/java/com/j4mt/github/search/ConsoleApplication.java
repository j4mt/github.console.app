package com.j4mt.github.search;

import com.j4mt.github.search.service.HelloService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

	private HelloService helloService;

	public ConsoleApplication(HelloService helloService){
		this.helloService = helloService;
	}

	public static void main(String[] args) {
//		SpringApplication.run(ConsoleApplication.class, args);
		SpringApplication app = new SpringApplication(ConsoleApplication.class);
		// disable spring banner
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		// check if the user passes any arguments
		if(args.length > 0){
			System.out.println(helloService.getMessage(args[0]));
		} else {
			// print default message
			System.out.println(helloService.getMessage());
		}
	}
}
