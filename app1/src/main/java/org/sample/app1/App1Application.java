package org.sample.app1;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App1Application implements ApplicationRunner {


  public static void main(String[] args) {
    SpringApplication.run(App1Application.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {

  }
}
