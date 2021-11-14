package team;

import player.*;

import java.io.*;

public class BaseballTeamList extends TeamList<BaseballPlayer> {

    public BaseballTeamList() throws Exception{
        String line;
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("baseball.csv"));
            br.readLine(); //skip the first line.

            while((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                String team = playerInfo[1];
                String season = playerInfo[2];

                BaseballPlayer playerToAdd = new BaseballPlayer(playerInfo[0], playerInfo[1],
                        playerInfo[2], playerInfo[3], Integer.parseInt(playerInfo[4]), Integer.parseInt(playerInfo[5]),
                        Integer.parseInt(playerInfo[6]), Integer.parseInt(playerInfo[7]),
                        Integer.parseInt(playerInfo[8]), Integer.parseInt(playerInfo[9]),
                        Integer.parseInt(playerInfo[10]), Double.parseDouble(playerInfo[11]));


                if (!teamMap.containsKey(new Pair(team, season))){
                    addTeam(team, season);

                }
                if (playerToAdd.getStatTeam(season).equals(team)){
                    teamMap.get(new Pair(team, season)).add(playerToAdd);
                }

            }

            br.close();
        } catch (IOException e) {
            throw new Exception("File not found!");
        }
    }

}
