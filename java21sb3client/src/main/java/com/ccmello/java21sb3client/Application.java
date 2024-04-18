package com.ccmello.java21sb3client;

import com.ccmello.java21sb3client.feignclient.QuoteFeignClient;
import com.ccmello.java21sb3client.resttemplate.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class Application {
  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner run(QuoteService service, QuoteFeignClient quoteFeignClient) throws Exception {
    return args -> {
      service.fetchRandomQuote();

      quoteFeignClient.getQuotes().forEach(quote -> log.info(quote.toString()));
    };
  }
}
