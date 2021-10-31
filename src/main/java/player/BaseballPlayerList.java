package player;

import java.io.*;
import java.util.*;

public class BaseballPlayerList {
    private final HashMap<String, List<BaseballPlayer>> playerMap = new HashMap<>();

    public BaseballPlayerList() {
        String line;
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("baseball.csv"));
            br.readLine(); //skip the first line.
            List<String> seasons = Arrays.asList("2016-2017", "2017-2018", "2018-2019","2019-2020", "2020-2021");
            for (String season: seasons){
                this.playerMap.put(season, new ArrayList<>());} //adding seasons as keys with empty lists as values

            while((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                for (String season: seasons){
                    if (playerInfo[2].equals(season)){ //adding player.Player object to the corresponding season
                        this.playerMap.get(season).add(new BaseballPlayer(playerInfo[0], playerInfo[1],
                                playerInfo[2], playerInfo[3], playerInfo[4], playerInfo[5], playerInfo[6],
                                playerInfo[7], playerInfo[8], playerInfo[9], playerInfo[10], playerInfo[11], playerInfo[12]));
                    }
                }

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, List<BaseballPlayer>> getPlayerMap() {
        return this.playerMap;
    }
}
