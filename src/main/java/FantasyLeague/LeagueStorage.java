package FantasyLeague;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Store a map of league members and a map of matches
 */
public class LeagueStorage implements Serializable {

    private final HashMap<String, LeagueMember> LeagueMemberMap;
    private final HashMap<String, Match> MatchMap;

    /**
     * Create a league storage with the specified LeagueMemberMap and MatchMap
     * @param LeagueMemberMap LeagueMemberMap to store
     * @param MatchMap MatchMap to store
     */
    public LeagueStorage(HashMap<String, LeagueMember> LeagueMemberMap, HashMap<String, Match> MatchMap) {
        this.LeagueMemberMap = LeagueMemberMap;
        this.MatchMap = MatchMap;
    }

    public HashMap<String, LeagueMember> getLeagueMemberMap() {
        return this.LeagueMemberMap;
    }

    public HashMap<String, Match> getMatchMap() {
        return this.MatchMap;
    }
}