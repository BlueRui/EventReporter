package com.example.lucky.eventreporter;

/**
 * Created by lucky on 6/22/2017.
 */

public class Event {
  /**
   * All data for an event
   */
  private String address;
  private String description;
  private int good;
  private int bad;
  private int commentNumber;
  private String id;
  private String location;
  private long time;
  private String username;
  private int repost;
  private String title;
  private String imgUri;

  /**
   * Constructor
   */
  public Event(String title, String address, String description) {
    this.title = title;
    this.address = address;
    this.description = description;
  }

  public Event() {}

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setGood(int good) {
    this.good = good;
  }

  public void setBad(int bad) {
    this.bad = bad;
  }

  public void setCommentNumber(int commentNumber) {
    this.commentNumber = commentNumber;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setTime(long time) {
    this.time = time;
  }

  public void setUser(String username) {
    this.username = username;
  }

  public void setRepost(int repost) { this.repost = repost; }

  public void setImgUri(String imgUri) { this.imgUri = imgUri; }


  public String getTitle() { return title; }

  public String getAddress() {
    return address;
  }

  public String getDescription() {
    return description;
  }

  public int getGood() {
    return good;
  }

  public int getBad() {
    return bad;
  }

  public int getCommentNumber() {
    return commentNumber;
  }

  public String getId() {
    return id;
  }

  public String getLocation() {
    return location;
  }

  public long getTime() {
    return time;
  }

  public String getUser() {
    return username;
  }

  public int getRepost() { return repost; }

  public String getImgUri() { return imgUri; }

}
