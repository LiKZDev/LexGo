package dev.likz.lawnetgo.entities;

public class Note {
  String content;
  String company;
  String department;
  String team;
  String id;
  String username;
  String cases;

  public Note(String content, String company, String department, String team, String id, String username, String cases) {
    this.content = content;
    this.company = company;
    this.department = department;
    this.team = team;
    this.id = id;
    this.username = username;
    this.cases = cases;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getCases() {
    return cases;
  }

  public void setCases(String cases) {
    this.cases = cases;
  }

  @Override
  public String toString() {
    return "Note{" +
            "content='" + content + '\'' +
            ", company='" + company + '\'' +
            ", department='" + department + '\'' +
            ", team='" + team + '\'' +
            ", id='" + id + '\'' +
            ", username='" + username + '\'' +
            ", cases='" + cases + '\'' +
            '}';
  }
}