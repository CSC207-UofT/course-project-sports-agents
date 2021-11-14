package player;

import java.io.*;

public class BaseballPlayerList extends PlayerList<BaseballPlayer>{

    public BaseballPlayerList() throws Exception{
        String line;
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("baseball.csv"));
            br.readLine(); //skip the first line.

            while((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                if (!playerMap.containsKey(playerInfo[0]) ) {
                    BaseballPlayer playerToAdd = new BaseballPlayer(playerInfo[0], playerInfo[1],
                            playerInfo[2], playerInfo[3], Integer.parseInt(playerInfo[4]), Integer.parseInt(playerInfo[5]),
                            Integer.parseInt(playerInfo[6]), Integer.parseInt(playerInfo[7]),
                            Integer.parseInt(playerInfo[8]), Integer.parseInt(playerInfo[9]),
                            Integer.parseInt(playerInfo[10]), Double.parseDouble(playerInfo[11]));
                }else{
                    playerMap.get(playerInfo[0]).addRecord(playerInfo[1],
                            playerInfo[2], playerInfo[3], Integer.parseInt(playerInfo[4]),
                            Integer.parseInt(playerInfo[5]), Integer.parseInt(playerInfo[6]),
                            Integer.parseInt(playerInfo[7]), Integer.parseInt(playerInfo[8]),
                            Integer.parseInt(playerInfo[9]), Integer.parseInt(playerInfo[10]),
                            Double.parseDouble(playerInfo[11]));


                }
            }
            br.close();
        } catch (IOException e) {
            throw new Exception("File not found!");
        }


    }


}

