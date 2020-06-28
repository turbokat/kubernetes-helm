package com.tfd.demo;

public class Thought {

  private String author;

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

  public void setThought(String thoguht) {
    this.thought = thoguht;
  }

  public Thought(String author, String thought) {
    this.author = author;
    this.thought = thought;
  }
  
}