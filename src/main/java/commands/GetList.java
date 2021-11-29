package commands;


import constants.*;

import java.io.*;
import java.util.*;

/**
 * Return a list of available sports, valid stats for each sport, and available users for each
 * season and sport so that the user will have a background of the program.
 */
public class GetList {

    public List<String> getAllSports(){
        return (Arrays.asList("Baseball", "Hockey", "Tennis"));
    }

    public List<String> getAllStat(String sportName) throws Exception {
        switch (sportName.toLowerCase()){
            case "hockey":
                return Arrays.asList("Team", "Skater Shoots",
                        "Position", "Games Played", "Goals", "Assists",
                        "Points", "Shots", "Shooting Percentage");
            case "baseball":
                return Arrays.asList("Team",
                        "Position", "Games Played", "At Bats", "Runs",
                        "Hits", "Home Runs", "Runs Batted In", "Strike Outs", "Average");
            case "tennis":
                return Arrays.asList("Age", "Aces", "Double Faults",
                        "Serve Points", "First Serves", "Break Points Saved");
        }
        throw new Exception(Exceptions.WRONG_SPORT);
    }

    public List<String> getAllPlayers(String sportName, String season) throws Exception {
        switch (sportName.toLowerCase()){
            case "hockey":
                return getAllHockeyPlayers(season);
            case "baseball":
                return getAllBaseballPlayers(season);
            case "tennis":
                return null;
        }
        throw new Exception(Exceptions.WRONG_SPORT);
    }

    public List<String> getAllHockeyPlayers(String season) throws Exception {
        List<String> allPlayers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("hockey.csv"));
        br.readLine(); //skip the first line.
        String line;
        String splitBy = ",";

        while((line = br.readLine()) != null) {
            String[] playerInfo = line.split(splitBy);
            if (playerInfo[1].equals(season)){
                allPlayers.add(playerInfo[0]);
            }
        }
        return allPlayers;

    }

    public List<String> getAllBaseballPlayers(String season) throws Exception {
        List<String> allPlayers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("baseball.csv"));
        br.readLine(); //skip the first line.
        String line;
        String splitBy = ",";

        while((line = br.readLine()) != null) {
            String[] playerInfo = line.split(splitBy);
            if (playerInfo[2].equals(season)){
                allPlayers.add(playerInfo[0]);
            }
        }
        return allPlayers;

    }


}
