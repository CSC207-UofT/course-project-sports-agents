package drivers_adapters;

import constants.Exceptions;
import player.BaseballPlayer;
import player.HockeyPlayer;
import player.Player;
import player.TennisPlayer;
import team.Team;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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
    public Team getTeam(String sport, String name) {
        // TODO: Implement this!
        return null;
    }
}
