package player;

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
                if (!playerMap.containsKey(playerInfo[0]) ) {
                    HockeyPlayer playerToAdd = new HockeyPlayer(playerInfo[0], playerInfo[1],
                            playerInfo[2], playerInfo[3], playerInfo[4], Integer.valueOf(playerInfo[5]),
                            Integer.valueOf(playerInfo[6]), Integer.valueOf(playerInfo[7]),
                            Integer.valueOf(playerInfo[8]), Integer.valueOf(playerInfo[9]),
                            Double.valueOf(playerInfo[10]));
                    addPlayer(playerToAdd);
                }else{
                    playerMap.get(playerInfo[0]).addRecord(playerInfo[1],
                            playerInfo[2], playerInfo[3], playerInfo[4], Integer.valueOf(playerInfo[5]),
                            Integer.valueOf(playerInfo[6]), Integer.valueOf(playerInfo[7]),
                            Integer.valueOf(playerInfo[8]), Integer.valueOf(playerInfo[9])
                            , Double.valueOf(playerInfo[10]));
                }
            }

            br.close();
        } catch (IOException e) {
            throw new Exception("File not found!");
        }
    }
}
