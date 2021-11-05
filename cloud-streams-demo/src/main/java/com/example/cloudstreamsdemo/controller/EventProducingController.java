package com.example.cloudstreamsdemo.controller;

import com.example.cloudstreamsdemo.stream.producer.EventStreamProducer;
import com.example.cloudstreamsdemo.stream.model.TestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class EventProducingController {

  @Autowired private EventStreamProducer eventStreamProducer;

  /**
   * Params are passed as request params for simplicity.
   *
   * To trigger this method from console:
   * curl -X POST 'http://localhost:8080/api/event/produce?id=777&name=dummy'
   */
  @PostMapping("/produce")
  public Boolean sendEvent(@RequestParam int id, @RequestParam String name) throws Exception {
    return eventStreamProducer.produceEvent(new TestMessage(id, name));
  }
}
