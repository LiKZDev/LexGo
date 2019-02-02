package dev.likz.lawnetgo.entities;

public class User {
  private String username;
  private String password;
  private String company;
  private String department;
  private String team;

  public User(String username, String password, String company, String department, String team) {
    this.username = username;
    this.password = password;
    this.company = company;
    this.department = department;
    this.team = team;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
}
