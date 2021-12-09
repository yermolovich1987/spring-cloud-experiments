package com.example.sampleapigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Dummy controller to check that all is working
@RestController
public class CheckController {

  @RequestMapping("/check")
  public String check() {
    return "test";
  }
}
