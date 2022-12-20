public class Athlete {
  public String name, sex, team, noc, games, season, city, sport, event, medal, id;
  public int age, height, weight, year;

  public Athlete(String name, String sex, String team, String noc, String games, String season, String city, String sport, String event, String medal, int age, int height, int weight, int year, String id) { 
    this.id = id;
    this.age = age;
    this.weight = weight;
    this.year = year;
    this.name = name;
    this.sex = sex;
    this.team = team;
    this.noc = noc;
    this.games = games;
    this.season = season;
    this.city = city;
    this.sport = sport;
    this.event = event;
    this.medal = medal;
  }
  public String getAthlete() {
    return name;
  }

  public String getMedal() {
    return medal;
  }
  
  public String getTeam() {
    return team;
  }

  public int getAge() { 
    return age;
  }

  public String getNoc() { 
    return noc;
  }

  public String getID() {
    return id;
  }
  
  public int getYear() {
    return year;
  }

  public String getGames() {
    return games;
  }

  public int getHeight() {
    return height;
  }

  public int getWeight() {
    return weight;
  }

  public String getSport() {
    return sport;
  }
  
  



  

}