package team;

import player.*;

import java.util.*;

public class TeamList <T extends Player>{

    protected HashMap<Pair, List<T>> teamMap;

    public TeamList(){
        this.teamMap = new HashMap<>();
    }

    /**
     * Add a pair of teamName and season to the PlayerList
     * @param teamName the team to add
     * @param season to add
     */
    public void addTeam(String teamName, String season) {
        this.teamMap.put(new TeamList.Pair(teamName, season), new ArrayList<>());
    }

    /**
     * Return the Players of the given team, if one exists
     * @param teamName name to search for
     * @return Players of the given team
     * @throws Exception if no such team exists
     */
    public List<T> getTeam(String teamName, String season) throws Exception {
        if (this.teamMap.containsKey(new Pair(teamName, season))) {
            return this.teamMap.get(new Pair(teamName, season));
        }
        throw new Exception("The requested Player does not exist!");
    }


    public HashMap<Pair, List<T>> getPlayerMap() {
        return teamMap;
    }


    public static class Pair{
        String pair1;
        String pair2;
        Pair(String pair1, String pair2){
            this.pair1 = pair1;
            this.pair2 = pair2;
        }
    }

}
