package com.example.cloudstreamsdemo.stream;

import com.example.cloudstreamsdemo.stream.model.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Slf4j
@Service
public class EventStreamService {
  @Autowired private EventStream eventStream;

  public Boolean produceEvent(TestMessage msg) {
    log.info(">>> Producing events: id: {}, name: {}.", msg.getId(), msg.getName());
    MessageChannel messageChannel = eventStream.producer();
    return messageChannel.send(
        MessageBuilder.withPayload(msg)
            .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
            .build());
  }
}
