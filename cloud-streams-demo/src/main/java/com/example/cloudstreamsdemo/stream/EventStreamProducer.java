package com.example.cloudstreamsdemo.stream;

import com.example.cloudstreamsdemo.stream.model.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Slf4j
@Service
public class EventStreamProducer {
  @Autowired
  private StreamBridge streamBridge;

  public Boolean produceEvent(TestMessage msg) {
    log.info(">>> Producing events: id: {}, name: {}.", msg.getId(), msg.getName());
    return streamBridge.send("eventProducer-out-0",
        MessageBuilder.withPayload(msg)
            .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
            .build());
  }
}
