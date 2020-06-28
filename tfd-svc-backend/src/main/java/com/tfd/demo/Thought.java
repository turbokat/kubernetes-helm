package com.tfd.demo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Thought implements Serializable {

  @JsonProperty("author")
  private String author;

  @JsonProperty("thought")
  private String thought;

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getThought() {
    return thought;
  }

  public void setThought(String thought) {
    this.thought = thought;
  }

  public Thought() {
  }

  public Thought(String author, String thought) {
    this.author = author;
    this.thought = thought;
  }
}