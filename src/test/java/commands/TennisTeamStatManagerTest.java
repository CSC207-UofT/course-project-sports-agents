package commands;

import java.util.List;
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

import match.Match;
import commands.TennisTeamStatManager;
import team.TeamManager;
import team.TeamStats;
import team.Team;
import team.TennisTeam;

public class TennisTeamStatManagerTest {
    private TennisTeamStatManager tsm;

    @Before
    public void setUp() throws Exception {
        List<String> p = new ArrayList<String>();
        List<Match> g  = new ArrayList<Match>();
        Team t1 = new TennisTeam("name", "city", p, g, 0, 0, 0, 0, 0, 0, 0);
        Team t2 = new TennisTeam("name1", "city1", p, g, 3, 1, 1, 1, 1, 1, 1);
        List<Team> t = new ArrayList<Team>();
        t.add(t1);
        t.add(t2);
        TeamManager tm = new TeamManager(t);
        tsm = new TennisTeamStatManager(tm);
    }

    @Test(timeout = 50)
    public void testGetStat(){
        assertEquals(0, tsm.getStat("name", TeamStats.WINS), 0);
    }

    @Test(timeout = 50)
    public void testParseStat(){
        assertEquals(TeamStats.WINS, tsm.parseStat("wins"));
    }

    @Test(timeout = 50)
    public void testGetStat2(){
        assertEquals(0, tsm.getStat("name", TeamStats.TOURNAMENT_WINS), 0);
    }

    @Test(timeout = 50)
    public void testParseStat2(){
        assertEquals(TeamStats.TOURNAMENT_WINS, tsm.parseStat("tournament wins"));
    }
}
