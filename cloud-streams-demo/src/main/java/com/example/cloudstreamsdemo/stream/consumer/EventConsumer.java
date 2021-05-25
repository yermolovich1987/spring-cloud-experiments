package com.example.cloudstreamsdemo.stream.consumer;

import com.example.cloudstreamsdemo.stream.EventStream;
import com.example.cloudstreamsdemo.stream.model.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventConsumer {

  @StreamListener(EventStream.INBOUND)
  public void consumeEvent(@Payload TestMessage msg) {
    log.info("<<< Inbound message:  id: {}, name: {}.", msg.getId(), msg.getName());
  }
}
