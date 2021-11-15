package drivers_adapters;

import player.BaseballPlayer;
import player.HockeyPlayer;
import player.Player;
import team.Team;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CSVDataContainer implements DataContainer {

    private HashMap<String, Player> playerMap;
    private HashMap<String, Team> teamMap;

    @Override
    public Player getPlayer(String sport, String name) throws Exception {
        if (playerMap.containsKey(name)) {
            return playerMap.get(name);
        }
        switch (sport) {
            case "Hockey":
                getHockeyPlayer(name);
            case "Baseball":
                getBaseballPlayer(name);
            case "Tennis":
                getTennisPlayer(name);
        }
        return playerMap.get(name);
    }

    private void getTennisPlayer(String name) throws Exception {

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
                        BaseballPlayer newPlayer = new BaseballPlayer(playerInfo[0], playerInfo[1],
                                playerInfo[2], playerInfo[3], Integer.parseInt(playerInfo[4]), Integer.parseInt(playerInfo[5]),
                                Integer.parseInt(playerInfo[6]), Integer.parseInt(playerInfo[7]),
                                Integer.parseInt(playerInfo[8]), Integer.parseInt(playerInfo[9]),
                                Integer.parseInt(playerInfo[10]), Double.parseDouble(playerInfo[11]));
                        playerMap.put(name, newPlayer);
                        found = true;
                    } else {
                        ((BaseballPlayer) playerMap.get(playerInfo[0])).addRecord(playerInfo[1],
                                playerInfo[2], playerInfo[3], Integer.parseInt(playerInfo[4]),
                                Integer.parseInt(playerInfo[5]), Integer.parseInt(playerInfo[6]),
                                Integer.parseInt(playerInfo[7]), Integer.parseInt(playerInfo[8]),
                                Integer.parseInt(playerInfo[9]), Integer.parseInt(playerInfo[10]),
                                Double.parseDouble(playerInfo[11]));
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            throw new Exception("File not found!");
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
        } catch (IOException e) {
            throw new Exception("File not found!");
        }
    }

    @Override
    public Team getTeam(String sport, String name) {
        return null;
    }
}
