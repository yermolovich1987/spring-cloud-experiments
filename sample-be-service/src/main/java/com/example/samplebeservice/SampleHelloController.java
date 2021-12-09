package com.example.samplebeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class SampleHelloController {

  @GetMapping("/hello")
  public String sayHello() {
    return "Hello, current time: " + ZonedDateTime.now();
  }
}
