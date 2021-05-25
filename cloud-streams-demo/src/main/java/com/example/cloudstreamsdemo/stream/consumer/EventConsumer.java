package com.example.cloudstreamsdemo.stream.consumer;

import com.example.cloudstreamsdemo.stream.model.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class EventConsumer {

  @Bean
  public Consumer<TestMessage> loggingConsumer() {
    return msg -> log.info("<<< Inbound message:  id: {}, name: {}.", msg.getId(), msg.getName());
  }
}
