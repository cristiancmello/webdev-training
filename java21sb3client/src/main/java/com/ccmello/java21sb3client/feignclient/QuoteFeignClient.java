package com.ccmello.java21sb3client.feignclient;

import com.ccmello.java21sb3client.resttemplate.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "employee", url = "http://localhost:8086")
public interface QuoteFeignClient {
  @RequestMapping(method = RequestMethod.GET, value = "/api")
  List<Quote> getQuotes();
}
