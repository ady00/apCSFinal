//Most countries with medals
//Country that participated the most
//Player that won the most medals
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class ScanData {
  private static int getTotalMedals(String id, Athlete allAthletes[]) {
    int count = 0;
    for(int k = 0; k < 271110; ++k) {
      if (id.equals(allAthletes[k].getID())) {
        count++;
      } 

    }
    return count;
  }

  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
  public static void read() {
    Athlete [] allAthletes = new Athlete[271116];
    try {
      Scanner in = new Scanner(new File("athlete_events.csv"));
      
      String headers = in.nextLine();
      
      for(int i = 0; i < 271116; i++) {
        String athleteCurrent = in.nextLine();

        String[] athleteCurrent_list = athleteCurrent.split(",");
        
        String id = athleteCurrent_list[0];
        
        String name = athleteCurrent_list[1];
        
        String sex = athleteCurrent_list[2];

        int age = 0;
        if (athleteCurrent_list[3].equals("NA")) {
          age = -1;
        } else {
          age = Integer.valueOf(athleteCurrent_list[3]);
        }

        int height = 0;
        if (athleteCurrent_list[4].getClass().getSimpleName() != "Integer") {
          height = -1;
        } else {
          height = Integer.valueOf(athleteCurrent_list[4]);
        }

        int weight = 0;
        if (athleteCurrent_list[5].getClass().getSimpleName() != "Integer") {
          weight = -1;
        } else {
          weight = Integer.valueOf(athleteCurrent_list[5]);
        }
        
        String team = athleteCurrent_list[6];
        
        String noc = athleteCurrent_list[7];
        
        String games = athleteCurrent_list[8];

        int year = 0;
        if (athleteCurrent_list[9].getClass().getSimpleName() != "Integer") {
          year = -1;
        } else {
          year = Integer.valueOf(athleteCurrent_list[9]);
        }
                
        String season = athleteCurrent_list[10];
        
        String city = athleteCurrent_list[11];
        
        String sport = athleteCurrent_list[12];
        
        String event = athleteCurrent_list[13];
        
        String medal = athleteCurrent_list[14];
        
        allAthletes[i] = new Athlete(name, sex, team, noc, games, season, city, sport, event, medal, age, height, weight, year, id);
        }
    } catch(IOException e) {
      System.out.println(e.getMessage());
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    //String newLine = System.getProperty("line.separator");

    String ascii = "       /|,\\\n" +
    "       )  (,\n" +
    "      (  , )\n" +
    "_______\\__/_______\n" +
    "`--.._      _..--'\n" +
    "      `\\  /'\n" +
    "        || \n" + 
    "        || \n" + 
    "        || \n" + 
    "        || \n";
    System.out.println("\n\n\n" + ascii);
    System.out.println("\nWelcome to Olympic Data Analysis!\n");
    
    int average = 0;
    int divider = 0;
    
    try {
      for (int i = 0; i < 271116; ++i) { 
        if (allAthletes[i].getAge() == -1) {
          divider++;
        }
      average += allAthletes[i].getAge(); 
      }
    } 

    catch (NullPointerException ernest) {
      divider++;
    }

    double div = 271116 - divider;

    // format to 2 decimal places
    System.out.println("The average age of all athletes is " + String.format("%.3f", average / div) + " years old");

      double div_medal = 271116;
      int average_medal = 0;
      try {
        for (int i = 1; i < 271116; ++i) { 
          // increment average medal only if the athlete has a unique id
          if (allAthletes[i].getMedal().length() > 3 && !allAthletes[i].getID().equals(allAthletes[i-1].getID())) {
            average_medal += 1;
          }
      } 

      } catch (NullPointerException ernest) {
        div_medal += 1;
      }

      System.out.println("About " + String.format("%.3f", average_medal * 100 / div_medal) + " percent of athletes win medals.");  

      // calculate the country with most medals as efficiently as possible
      // make a dictionary of countries and medals
      String[] countries = new String[215];
      int[] country_medals = new int[215];
      // iterate through all athletes, and add the country to the countries array if it is not already in the array
      try {
        for (int i = 0; i < 271116; ++i) {
          String temp = allAthletes[i].getNoc();
          boolean found = false;
          for (int j = 0; j < 215; ++j) {
            if (temp.equals(countries[j])) {
              found = true;
              break;
            }
          }
          if (!found) {
            for (int j = 0; j < 215; ++j) {
              if (countries[j] == null) {
                countries[j] = temp;
                break;
              }
            }
          }
        }
      } 
      catch (NullPointerException advay) {
      }

      // iterate through all athletes, and add 1 to the country_medals array for the country that the athlete is from
      try {
        for (int i = 0; i < 271116; ++i) {
          String temp = allAthletes[i].getNoc();
          for (int j = 0; j < 215; ++j) {
            if (temp.equals(countries[j])) {
              if (allAthletes[i].getMedal().length() > 3) {
                country_medals[j] += 1;
                break;
              } else {
                break;
              }
            }
          }
        }
      } catch (NullPointerException Matthew) {
      }

      // find the country with the most medals
      int top_country_medals = 0;
      String top_country = "";

      for (int i = 0; i < 215; ++i) {
        if (country_medals[i] > top_country_medals) {
          top_country_medals = country_medals[i];
          top_country = countries[i];
        }
      }
      // print the country with the most medals
      System.out.println("The country with the most medals is " + top_country + " with " + top_country_medals + " medals. \n");

      // prompt the user for a country and print the number of medals that country has
      Scanner prompt = new Scanner(System.in);
      // make input and output a never-ending loop unless the user types exit
      
      System.out.println("Enter a country's NOC (e.g USA, CHN, etc.) to see how many medals they have won.");
      System.out.println("To search for player ID, enter \"player\".");
      
      while (true) {
        String user_country = prompt.nextLine();
        // add quotes to the start and end of user_country
        user_country = "\"" + user_country + "\"";
        for (int i = 0; i < 215; ++i) {
          if (user_country.equals(countries[i])) {
            System.out.println("The country " + user_country + " has won " + country_medals[i] + " medals");
            break;
          } else if (user_country.length() < 3) {
            System.out.println("The NOC specified is not found in our database. Please check if you have entered your desired country correctly.");
            break;
          } else if ((!user_country.equals(countries[i])) && i == 214) {
            System.out.println("The NOC specified is not found in our database. Please check if you have entered your desired country correctly.");
            break;
          } else {
            if (user_country.equals("\"player\"")) {
              System.out.println("Enter a player's ID to see their data. Print \"exit\" to exit the program");
              String input1 = prompt.nextLine();
                if (input1.equals("exit")) {
                  System.out.println("Entering main programE...");
                  //prints message again to see
                  System.out.println("Enter a country's NOC (e.g USA, CHN, etc.) to see how many medals they have won.");
            System.out.println("To search for player ID, enter \"player\".");
            System.out.println("Print \"exit\" to exit the program");
            break;
          } else {
          while (true) {
            String user_id = prompt.nextLine();
            if (isNumeric(user_id)) {
              if (Integer.valueOf(user_id) < 1 || Integer.valueOf(user_id) > 135571) {
                System.out.println("Your ID was not found in our database. Please input an ID that fits the range of the dataset (from 1-135571)");
                continue;
              }
            }
            // wrap user_id in quotes
            user_id = "\"" + user_id + "\"";
            
            for (int x = 0; x < 271116; ++x) {
              if (user_id.equals(allAthletes[x].getID())) {
                
                int medals_athlete = getTotalMedals(user_id, allAthletes);
                System.out.println("The player with ID " + user_id + " is " + allAthletes[x].getAthlete() + " and is from " + allAthletes[x].getNoc() + " and has won " + medals_athlete + " medals.");
                // print out the athlete's sport, height, weight, year all on separate lines
                System.out.println("The athlete's sport is " + allAthletes[x].getSport());
                System.out.println("The athlete's team is " + allAthletes[x].getTeam());

                break;
              }
            }
          }
          }
          }
        }
      }
  }
}
}