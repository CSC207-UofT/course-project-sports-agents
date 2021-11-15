package player;

import team.*;

import java.io.*;

public class HockeyPlayerList extends PlayerList<HockeyPlayer>{

    public HockeyPlayerList() throws Exception{
        String line;
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("hockey.csv"));
            br.readLine(); //skip the first line.

            while((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                String team = playerInfo[1];
                String season = playerInfo[2];

                HockeyPlayer playerToAdd = new HockeyPlayer(playerInfo[0], playerInfo[1],
                        playerInfo[2], playerInfo[3], playerInfo[4], Integer.valueOf(playerInfo[5]),
                        Integer.valueOf(playerInfo[6]), Integer.valueOf(playerInfo[7]),
                        Integer.valueOf(playerInfo[8]), Integer.valueOf(playerInfo[9]),
                        Double.valueOf(playerInfo[10]));


                if (!playerMap.containsKey(playerInfo[0]) ) {
                    addPlayer(playerToAdd);
                }else{
                    playerMap.get(playerInfo[0]).addRecord(playerInfo[1],
                            playerInfo[2], playerInfo[3], playerInfo[4], Integer.valueOf(playerInfo[5]),
                            Integer.valueOf(playerInfo[6]), Integer.valueOf(playerInfo[7]),
                            Integer.valueOf(playerInfo[8]), Integer.valueOf(playerInfo[9])
                            , Double.valueOf(playerInfo[10]));
                }

//                if (!teamMap.containsKey(new Pair(team, season))){
//                    addTeam(team, season);
//
//                }
//                if (playerToAdd.getStatTeam(season).equals(team)){
//                    teamMap.get(new Pair(team, season)).add(playerToAdd);
//                }


            }

            br.close();
        } catch (IOException e) {
            throw new Exception("File not found!");
        }
    }
}
