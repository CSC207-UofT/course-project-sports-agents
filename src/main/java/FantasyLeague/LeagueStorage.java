package FantasyLeague;

import java.io.Serializable;
import java.util.HashMap;

public class LeagueStorage implements Serializable {

    public final HashMap<String, LeagueMember> LeagueMemberMap;
    public final HashMap<String, Match> MatchMap;

    /**
     * Serializable data class used to store your current fantasy league data
     * @param LeagueMemberMap a map containing the league's members
     * @param MatchMap a map containing the league's matches
     */

    public LeagueStorage(HashMap<String, LeagueMember> LeagueMemberMap, HashMap<String, Match> MatchMap) {
        this.LeagueMemberMap = LeagueMemberMap;
        this.MatchMap = MatchMap;
    }
}