package drivers_adapters;

import constants.Exceptions;
import player.BaseballPlayer;
import player.HockeyPlayer;
import player.Player;
import player.TennisPlayer;
import team.HockeyTeam;
import team.Team;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVDataContainer implements DataContainer {

    // Attributes were made public for easier testing
    public final HashMap<String, Player> playerMap;
    public final HashMap<String, Team> teamMap;

    public CSVDataContainer() {
        playerMap = new HashMap<>();
        teamMap = new HashMap<>();
    }

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

    private void getTennisPlayer(String name) throws Exception {
        String line;
        String splitBy = ",";
        boolean found = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("tennis.csv"));
            br.readLine(); //skip the first line

            while ((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                if (playerInfo[0].equals(name)) {
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
                        TennisPlayer player = (TennisPlayer) playerMap.get(playerInfo[1]);
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

    private void getBaseballPlayer(String name) throws Exception {
        String line;
        String splitBy = ",";
        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("baseball.csv"));
            br.readLine(); //skip the first line.

            while((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                if (playerInfo[0].equals(name)) {
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
                        ((BaseballPlayer) playerMap.get(playerInfo[0])).addRecord(playerInfo[2],
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

    private void getHockeyPlayer(String name) throws Exception {
        String line;
        String splitBy = ",";
        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("hockey.csv"));
            br.readLine(); //skip the first line.

            while((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);

                if (playerInfo[0].equals(name)) {
                    if (!found) {
                        HockeyPlayer newPlayer = new HockeyPlayer(playerInfo[0], playerInfo[1],
                                playerInfo[2], playerInfo[3], playerInfo[4], Integer.valueOf(playerInfo[5]),
                                Integer.valueOf(playerInfo[6]), Integer.valueOf(playerInfo[7]),
                                Integer.valueOf(playerInfo[8]), Integer.valueOf(playerInfo[9]),
                                Double.valueOf(playerInfo[10]));
                        playerMap.put(name, newPlayer);
                        found = true;
                    } else {
                        ((HockeyPlayer) playerMap.get(playerInfo[0])).addRecord(playerInfo[1],
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

    @Override
    public Team getTeam(String sport, String name) throws Exception {
        if (teamMap.containsKey(name)) {
            return teamMap.get(name);
        }
        switch (sport.toLowerCase()) {
            case "hockey":
                getHockeyTeam(name);
                break;
        }
        return teamMap.get(name);
    }

    private void getHockeyTeam(String name) throws Exception {
        String line;
        String splitBy = ",";
        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("hockey_teams.csv"));
            br.readLine(); //skip the first line.

            while((line = br.readLine()) != null) {
                String[] teamInfo = line.split(splitBy);

                if (teamInfo[0].equals(name)) {
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
                        ((HockeyTeam) teamMap.get(teamInfo[0])).addRecord(teamInfo[1], Integer.valueOf(teamInfo[2]),
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

    public List<String> getAllPlayersForAllSports() throws IOException {
        List<String> allNames = new ArrayList<>();
        allNames.addAll(getAllHockeyPlayers());
        allNames.addAll(getAllBaseballPlayers());
        allNames.addAll(getAllTennisPlayers());

        return allNames;

    }
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
