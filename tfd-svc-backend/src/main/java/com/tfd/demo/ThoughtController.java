package com.tfd.demo;

import org.springframework.web.bind.annotation.RestController;
import java.util.Random;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ThoughtController {

  Thought defaultThought = new Thought(
    "Commander Feral, Swat Kats", "Back off, Swat Kats! The Enforcers are here! This is Feral, bring me chopper backup!");

  Thought thoughts[] = new Thought[] { new Thought("Billy Connolly",
      "Before you judge a man, walk a mile in his shoes. After that who cares?... He’s a mile away and you’ve got his shoes!"),
      new Thought("A. A. Milne", "People say nothing is impossible, but I do nothing every day."),
      new Thought("Abraham Lincoln",
          "Better to remain silent and be thought a fool than to speak out and remove all doubt."),
      new Thought("Abraham Lincoln", "If I were two-faced, would I be wearing this one?"),
      new Thought("Al McGuire", "The only mystery in life is why the kamikaze pilots wore helmets."),
      new Thought("Alan Dundes",
          "Light travels faster than sound. This is why some people appear bright until you hear them speak."),
      new Thought("Albert Camus", "Nobody realizes that some people expend tremendous energy merely to be normal."),
      new Thought("Albert Einstein", "The difference between stupidity and genius is that genius has its limits."),
      new Thought("Ann Landers",
          "At every party there are two kinds of people – those who want to go home and those who don’t. The trouble is, they are usually married to each other."),
      new Thought("Arthur C. Clarke", "I don’t believe in astrology; I’m a Sagittarius and we’re skeptical."),
      new Thought("Ashleigh Brilliant", "My opinions may have changed, but not the fact that I’m right."),
      new Thought("Ashleigh Brilliant",
          "To be sure of hitting the target, shoot first, and call whatever you hit the target."),
      new Thought("Bernard Baruch",
          "Be who you are and say what you feel, because those who mind don’t matter and those who matter don’t mind.”"), };

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @RequestMapping("/default-thought")
  @CrossOrigin(origins = "*")
  public Thought getDefaultThought() {
    return defaultThought;
	}

  @RequestMapping("/thought")
  @CrossOrigin(origins = "*")
  public Thought getTodaysThought() {
    try {
      Thread.sleep(2500);
    } catch (InterruptedException e) {
      return defaultThought;
    }
		return thoughts[(new Random()).nextInt(10)];
	}
}