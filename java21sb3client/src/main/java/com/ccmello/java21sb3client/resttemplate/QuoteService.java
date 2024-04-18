package com.ccmello.java21sb3client.resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteService {
  private static final Logger log = LoggerFactory.getLogger(QuoteService.class);

  @Autowired
  RestTemplate restTemplate;

  public void fetchRandomQuote() {
    var quote = restTemplate.getForObject("http://localhost:8086/api/random", Quote.class);

    log.info(quote.toString());
  }
}
