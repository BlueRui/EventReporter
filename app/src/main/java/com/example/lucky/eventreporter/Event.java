package com.example.lucky.eventreporter;

/**
 * Created by lucky on 6/22/2017.
 */

public class Event {
  /**
   * All data for an event
   */
  private String title;
  private String address;
  private String description;

  /**
   * Constructor
   */
  public Event(String title, String address, String description) {
    this.title = title;
    this.address = address;
    this.description = description;
  }

  /**
   * Getters for private attributes of Event Class
   */
  public String getTitle() {
    return title;
  }

  public String getAddress() {
    return address;
  }

  public String getDescription() {
    return description;
  }
}
