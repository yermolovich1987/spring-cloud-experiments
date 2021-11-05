package com.example.cloudstreamsdemo.stream.consumer;

import com.example.cloudstreamsdemo.stream.model.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.Message;

import java.util.function.Function;

@Slf4j
@Configuration
public class EventConsumer {

  // Just a sample that reads from one topic and publishes to another one.
  @Bean
  public Function<TestMessage, TestMessage> loggingHandler() {
    return msg -> {
      log.info("<<< Inbound message:  id: {}, name: {}.", msg.getId(), msg.getName());
      return new TestMessage(msg.getId(), msg.getName() + "_processed");
    };
  }

  @Bean
  public IntegrationFlow uppercaseFlow() {
    return IntegrationFlows.from(
            MessageFunction.class, gateway -> gateway.beanName("integrationFlowHandler"))
        .<TestMessage, String>transform(testMessage -> testMessage.getName().toUpperCase())
        .handle(
            (msg, headers) -> {
              log.info("Handled message via sample integration flow: " + msg);
              return msg;
            })
        .get();
  }

  public interface MessageFunction extends Function<Message<TestMessage>, Message<String>> {}
}
