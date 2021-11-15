package leagueMember;

import match.Match;

import java.io.Serializable;
import java.util.HashMap;

public class LeagueStorage implements Serializable {

    public HashMap<String, LeagueMember> LeagueMemberMap;
    public HashMap<String, Match> MatchMap;

    public LeagueStorage(HashMap<String, LeagueMember> LeagueMemberMap, HashMap<String, Match> MatchMap) {
        this.LeagueMemberMap = LeagueMemberMap;
        this.MatchMap = MatchMap;
    }
}
