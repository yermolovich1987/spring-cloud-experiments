package com.example.samplebeservice;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/test-resource")
public class SampleHelloController {

  @GetMapping("/hello")
  public String sayHello() {
    return "Hello, current time: " + ZonedDateTime.now();
  }

  @GetMapping("/token")
  public String resource(@AuthenticationPrincipal Jwt jwt) {
    return String.format("Resource accessed by: %s (with subjectId: %s)" ,
        jwt.getClaims().get("user_name"),
        jwt.getSubject());
  }
}
