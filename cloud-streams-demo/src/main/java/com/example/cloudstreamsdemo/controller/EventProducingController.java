package com.example.cloudstreamsdemo.controller;

import com.example.cloudstreamsdemo.stream.EventStreamProducer;
import com.example.cloudstreamsdemo.stream.model.TestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class EventProducingController {

  @Autowired private EventStreamProducer eventStreamProducer;

  // Test get method just to trigger flow via browser
  //  @PostMapping("/produce")
  @GetMapping("/produce")
  public Boolean sendEvent(@RequestParam int id, @RequestParam String name) throws Exception {
    return eventStreamProducer.produceEvent(new TestMessage(id, name));
  }
}
