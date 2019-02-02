package dev.likz.lawnetgo.entities;

public class CaseContent {
  private String title;
  private String content;

  public CaseContent(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "{" +
            "\"title\":\"" + title.replaceAll("\\\\\\\\", "") + '\"' +
            ", \"content\": \"" + content.replaceAll("\"", "'").replaceAll("\\\\", "") + '\"' +
            "}";
  }
}
