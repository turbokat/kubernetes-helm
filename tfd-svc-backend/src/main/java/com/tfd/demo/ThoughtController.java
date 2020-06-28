package com.tfd.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RestController
public class ThoughtController {

  @Value("${tfd.logic.api.url}") // #1
  private String tfdLogicApiUrl;

  RestTemplate restTemplate = new RestTemplate();

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @RequestMapping("/default-thought")
  public Thought getDefaultThought() {
    System.out.println("using url: " + tfdLogicApiUrl);
    return restTemplate.getForEntity(tfdLogicApiUrl + "/default-thought", Thought.class).getBody();
	}

  @RequestMapping("/thought-for-the-day")
  public Thought getTodaysThought() {
    try {
      Thread.sleep(2500);
    } catch (InterruptedException e) {
      throw new RuntimeException("Error fetching thoughts - " + e.getMessage(), e);
    }
    System.out.println("using url: " + tfdLogicApiUrl);
    return restTemplate.getForEntity(tfdLogicApiUrl + "/thought-for-the-day", Thought.class).getBody();
	}
}