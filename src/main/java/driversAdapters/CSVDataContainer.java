package driversAdapters;

import constants.Exceptions;
import sports.baseball.BaseballPlayer;
import sports.hockey.HockeyPlayer;
import sports.Player;
import sports.tennis.TennisPlayer;
import sports.hockey.HockeyTeam;
import sports.Team;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVDataContainer implements DataContainer {

    // Attributes were made public for easier testing
    public final HashMap<String, Player> playerMap;
    public final HashMap<String, Team> teamMap;

    /**
     * A CSV data container retrieves data from the CSV files and outputs appropriate classes to the user
     * It stores the classes in playerMap and teamMap HashMaps, meaning that if a user already looked up a player
     * or a team, then DataContainer will not have to look them up in the data again
     */
    public CSVDataContainer() {
        playerMap = new HashMap<>();
        teamMap = new HashMap<>();
    }

    /**
     * get the player from a particular sport based on their name from the data
     * @param sport sport of the player
     * @param name name of the player
     * @return the appropriate player class
     * @throws Exception whenever a data file is not found, or something else goes wrong
     */
    @Override
    public Player getPlayer(String sport, String name) throws Exception {
        if (playerMap.containsKey(name)) {
            return playerMap.get(name);
        }
        switch (sport) {
            case "hockey":
                getHockeyPlayer(name);
                break;
            case "baseball":
                getBaseballPlayer(name);
                break;
            case "tennis":
                getTennisPlayer(name);
                break;
        }
        return playerMap.get(name);
    }

    /**
     * get a tennis player based on their name
     * @param name of the player
     * @throws Exception whenever a file is not found
     */
    private void getTennisPlayer(String name) throws Exception {
        String line;
        String splitBy = ",";
        boolean found = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("tennis.csv"));
            br.readLine(); //skip the first line

            while ((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                if (playerInfo[1].equalsIgnoreCase(name)) {
                    if (!(found)) {
                        TennisPlayer player = new TennisPlayer(playerInfo[1], playerInfo[2], playerInfo[0],
                                Integer.parseInt(playerInfo[3]), Integer.parseInt(playerInfo[4]),
                                Integer.parseInt(playerInfo[5]), Integer.parseInt(playerInfo[6]),
                                Double.parseDouble(playerInfo[7]), Double.parseDouble(playerInfo[8]),
                                Double.parseDouble(playerInfo[9]), Double.parseDouble(playerInfo[10]),
                                Double.parseDouble(playerInfo[11]), Double.parseDouble(playerInfo[12]));
                        playerMap.put(name, player);
                        found = true;
                    } else {
                        TennisPlayer player = (TennisPlayer) playerMap.get(name);
                        player.addRecord(playerInfo[0], Integer.parseInt(playerInfo[3]),
                                Integer.parseInt(playerInfo[4]), Integer.parseInt(playerInfo[5]),
                                Integer.parseInt(playerInfo[6]), Double.parseDouble(playerInfo[7]),
                                Double.parseDouble(playerInfo[8]), Double.parseDouble(playerInfo[9]),
                                Double.parseDouble(playerInfo[10]), Double.parseDouble(playerInfo[11]),
                                Double.parseDouble(playerInfo[12]));
                    }
                }
            }
            br.close();
            if (!(found)) {
                throw new Exception(Exceptions.PLAYER_NOT_FOUND);
            }
        } catch (IOException e) {
            throw new Exception(Exceptions.FILE_NOT_FOUND);
        }
    }

    /**
     * Get a baseball player from the baseball file based on their name
     * @param name of the player
     * @throws Exception whenever the file is not found
     */

    private void getBaseballPlayer(String name) throws Exception {
        String line;
        String splitBy = ",";
        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("baseball.csv"));
            br.readLine(); //skip the first line.

            while((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                if (playerInfo[0].toLowerCase().equals(name)) {
                    if (!found) {
                        BaseballPlayer newPlayer = new BaseballPlayer(playerInfo[0], playerInfo[2],
                                playerInfo[1], playerInfo[3], Integer.parseInt(playerInfo[4]),
                                Integer.parseInt(playerInfo[5]), Integer.parseInt(playerInfo[6]),
                                Integer.parseInt(playerInfo[7]), Integer.parseInt(playerInfo[8]),
                                Integer.parseInt(playerInfo[9]), Integer.parseInt(playerInfo[10]),
                                Double.parseDouble(playerInfo[11]));
                        playerMap.put(name, newPlayer);
                        found = true;
                    } else {
                        ((BaseballPlayer) playerMap.get(name)).addRecord(playerInfo[2],
                                playerInfo[1], playerInfo[3], Integer.parseInt(playerInfo[4]),
                                Integer.parseInt(playerInfo[5]), Integer.parseInt(playerInfo[6]),
                                Integer.parseInt(playerInfo[7]), Integer.parseInt(playerInfo[8]),
                                Integer.parseInt(playerInfo[9]), Integer.parseInt(playerInfo[10]),
                                Double.parseDouble(playerInfo[11]));
                    }
                }
            }
            br.close();
            if (!found) {
                throw new Exception(Exceptions.PLAYER_NOT_FOUND);
            }
        } catch (IOException e) {
            throw new Exception(Exceptions.FILE_NOT_FOUND);
        }
    }

    /**
     * Get a hockey player from the hockey file based on their name
     * @param name of the player
     * @throws Exception whenever the hockey.csv file isn't found
     */
    private void getHockeyPlayer(String name) throws Exception {
        String line;
        String splitBy = ",";
        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("hockey.csv"));
            br.readLine(); //skip the first line.

            while((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);

                if (playerInfo[0].toLowerCase().equals(name)) {
                    if (!found) {
                        HockeyPlayer newPlayer = new HockeyPlayer(playerInfo[0], playerInfo[1],
                                playerInfo[2], playerInfo[3], playerInfo[4], Integer.valueOf(playerInfo[5]),
                                Integer.valueOf(playerInfo[6]), Integer.valueOf(playerInfo[7]),
                                Integer.valueOf(playerInfo[8]), Integer.valueOf(playerInfo[9]),
                                Double.valueOf(playerInfo[10]));
                        playerMap.put(name, newPlayer);
                        found = true;
                    } else {
                        ((HockeyPlayer) playerMap.get(name)).addRecord(playerInfo[1],
                                playerInfo[2], playerInfo[3], playerInfo[4], Integer.valueOf(playerInfo[5]),
                                Integer.valueOf(playerInfo[6]), Integer.valueOf(playerInfo[7]),
                                Integer.valueOf(playerInfo[8]), Integer.valueOf(playerInfo[9]),
                                Double.valueOf(playerInfo[10]));
                    }
                }
            }
            br.close();
            if (!found) {
                throw new Exception(Exceptions.PLAYER_NOT_FOUND);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new Exception(Exceptions.FILE_NOT_FOUND);
        }
    }

    /**
     * Call the appropriate helper methods to retrieve the right team based on the sport and their name
     * @param sport name of the sport
     * @param name name of the team
     * @return the appropriate team from the appropriate sport
     * @throws Exception whenever the appropraite files cannot be found
     */
    @Override
    public Team getTeam(String sport, String name) throws Exception {
        if (teamMap.containsKey(name)) {
            return teamMap.get(name);
        }
        switch (sport.toLowerCase()) {
            case "hockey":
                getHockeyTeam(name);
                break;
            case "baseball":
                throw new Exception(Exceptions.WRONG_SPORT);
        }
        return teamMap.get(name);
    }

    /**
     * Get a hockey team from the file based on their name
     * @param name name of the team
     * @throws Exception whenever the hockey_teams.csv file cannot be found
     */
    private void getHockeyTeam(String name) throws Exception {
        String line;
        String splitBy = ",";
        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("hockey_teams.csv"));
            br.readLine(); //skip the first line.

            while ((line = br.readLine()) != null) {
                String[] teamInfo = line.split(splitBy);

                if (teamInfo[0].toLowerCase().equals(name)) {
                    if (!found) {
                        HockeyTeam newTeam = new HockeyTeam(teamInfo[0], teamInfo[1], Integer.valueOf(teamInfo[2]),
                                Integer.valueOf(teamInfo[6]), Integer.valueOf(teamInfo[3]),
                                Integer.valueOf(teamInfo[4]), Integer.valueOf(teamInfo[5]),
                                Integer.valueOf(teamInfo[7]), Integer.valueOf(teamInfo[8]),
                                Double.valueOf(teamInfo[9]), Double.valueOf(teamInfo[10]),
                                Double.valueOf(teamInfo[11]));
                        teamMap.put(name, newTeam);
                        found = true;
                    } else {
                        ((HockeyTeam) teamMap.get(teamInfo[0].toLowerCase())).addRecord(teamInfo[1], Integer.valueOf(teamInfo[2]),
                                Integer.valueOf(teamInfo[6]), Integer.valueOf(teamInfo[3]),
                                Integer.valueOf(teamInfo[4]), Integer.valueOf(teamInfo[5]),
                                Integer.valueOf(teamInfo[7]), Integer.valueOf(teamInfo[8]),
                                Double.valueOf(teamInfo[9]), Double.valueOf(teamInfo[10]),
                                Double.valueOf(teamInfo[11]));
                    }
                }
            }
            br.close();
            if (!found) {
                throw new Exception(Exceptions.TEAM_NOT_FOUND);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new Exception(Exceptions.FILE_NOT_FOUND);
        }
    }

    /**
     * Get all of the players from a particular sport
     * @param sport sport
     * @param season season for which to get the players
     * @return returns a list of names of the players
     * @throws Exception whenever a data file cannot be found
     */
    public List<String> getAllPlayers(String sport, String season) throws Exception {
        switch (sport.toLowerCase()) {
            case "hockey":
                return getAllHockeyPlayers(season);
            case "baseball":
                return getAllBaseballPlayers(season);
            case "tennis":
                return getAllTennisPlayers(season);
        }
        return null;
    }

    /**
     * Gets the names of all the hockey players who played in a particular season
     * @param season season for which to query
     * @return list of all the hockey players who played during the season
     * @throws Exception whenever the hockey.csv file cannot be found
     */
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
        br.close();
        return allPlayers;

    }

    /**
     * Gets the names of all the baseball players who played in a particular season
     * @param season season
     * @return list of all the baseball players who played during the season
     * @throws Exception whenever the baseball.csv file cannot be found
     */
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
        br.close();
        return allPlayers;

    }

    /**
     * get the names of all of the tennis players who played in the given season
     * @param season season
     * @return the names of the tennis players who played in the given season
     * @throws Exception whenever the tennis.csv file cannot be found
     */
    public List<String> getAllTennisPlayers(String season) throws Exception {

        List<String> allPlayers = new ArrayList<>();
        String line;
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader("tennis.csv"));
        br.readLine(); //skip the first line

        while ((line = br.readLine()) != null) {
            String[] playerInfo = line.split(splitBy);
            if (playerInfo[0].equals(season)) {
                allPlayers.add(playerInfo[1]);
            }
        }
        br.close();
        return allPlayers;

    }

    /**
     * Get the names for all players in all the sports
     * @return the list of all the players in all the sports
     * @throws IOException whenever the appropriate data files cannot be found
     */
    public List<String> getAllPlayersForAllSports() throws IOException {
        List<String> allNames = new ArrayList<>();
        allNames.addAll(getAllHockeyPlayers());
        allNames.addAll(getAllBaseballPlayers());
        allNames.addAll(getAllTennisPlayers());

        return allNames;

    }

    /**
     * Get the names for all players in hockey for all seasons
     * @return the list of hockey players in the data
     * @throws IOException whenever hockey.csv file cannot be found
     */
    public List<String> getAllHockeyPlayers() throws IOException {
        List<String> allHockeyNames = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("hockey.csv"));
        br.readLine(); //skip the first line.
        String line;
        String splitBy = ",";

        while((line = br.readLine()) != null) {
            String[] playerInfo = line.split(splitBy);
            if (!allHockeyNames.contains(playerInfo[0].toLowerCase()+ ": Hockey")){
                allHockeyNames.add(playerInfo[0].toLowerCase()+ ": Hockey");}
        }
        return allHockeyNames;

    }

    /**
     * Get the names for all players in baseball for all seasons
     * @return the list of baseball players in the data
     * @throws IOException whenever hockey.csv file cannot be found
     */
    public List<String> getAllBaseballPlayers() throws IOException {
        List<String> allBaseballNames = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("baseball.csv"));
        br.readLine(); //skip the first line.
        String line;
        String splitBy = ",";

        while((line = br.readLine()) != null) {
            String[] playerInfo = line.split(splitBy);
            if (!allBaseballNames.contains(playerInfo[0].toLowerCase()+ ": Baseball")){
                allBaseballNames.add(playerInfo[0].toLowerCase()+ ": Baseball");}
        }
        return allBaseballNames;

    }

    /**
     * Get the names for all players in tennis for all seasons
     * @return the list of tennis players in the data
     * @throws IOException whenever hockey.csv file cannot be found
     */
    public List<String> getAllTennisPlayers() throws IOException {
        List<String> allTennisNames = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("tennis.csv"));
        br.readLine(); //skip the first line.
        String line;
        String splitBy = ",";

        while((line = br.readLine()) != null) {
            String[] playerInfo = line.split(splitBy);
            if (!allTennisNames.contains(playerInfo[1].toLowerCase()+ ": Tennis")){
                allTennisNames.add(playerInfo[1].toLowerCase()+ ": Tennis");}
        }
        return allTennisNames;
    }
}
