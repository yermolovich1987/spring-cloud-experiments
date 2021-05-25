package com.example.cloudstreamsdemo.stream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestMessage {
  private int id;
  private String name;
}
