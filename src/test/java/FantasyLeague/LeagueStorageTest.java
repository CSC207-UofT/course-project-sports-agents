package FantasyLeague;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LeagueStorageTest {
    private HashMap<String, LeagueMember> leagueMemberMap;
    private HashMap<String, Match> matchMap;
    private LeagueStorage leagueStorage;

    @Before
    public void setUp() throws Exception {
        leagueMemberMap = new HashMap<>();
        LeagueMember member1 = new LeagueMember("John");
        leagueMemberMap.put("John", member1);
        LeagueMember member2 = new LeagueMember("Bob");
        leagueMemberMap.put("Bob", member2);

        matchMap = new HashMap<>();
        Match match1 = new Match("Red Team", "Blue Team");
        matchMap.put("Match 1", match1);
        Match match2 = new Match("Green Tean", "Orange Team");
        matchMap.put("Match 2", match2);

        leagueStorage = new LeagueStorage(leagueMemberMap, matchMap);
    }

    @Test
    public void testGetLeagueMemberMap() {
        assertEquals(leagueMemberMap, leagueStorage.getLeagueMemberMap());
    }

    @Test
    public void testGetMatchMap() {
        assertEquals(matchMap, leagueStorage.getMatchMap());
    }
}