package com.github.huwenwen.webmagic;

/**
 * @author huwenwen
 * @since 2017/4/19
 */
public class GithubBean {

  private String author;
  private String name;
  private String readme;
  private String start;
  private String watch;
  private String fork;

  public String getWatch() {
    return watch;
  }

  public void setWatch(String watch) {
    this.watch = watch;
  }

  public String getFork() {
    return fork;
  }

  public void setFork(String fork) {
    this.fork = fork;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReadme() {
    return readme;
  }

  public void setReadme(String readme) {
    this.readme = readme;
  }
}
