package commands;

import java.util.List;
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

import match.Match;
import commands.TeamStatComparer;
import commands.HockeyTeamStatComparer;
import commands.TeamStatManager;
import commands.HockeyTeamStatManager;
import team.TeamManager;
import team.TeamStats;
import team.Team;
import team.HockeyTeam;

public class HockeyTeamStatComparerTest {
    private TeamStatComparer tsc;

    @Before
    public void setUp() throws Exception {
        List<String> p = new ArrayList<String>();
        List<Match> g  = new ArrayList<Match>();
        Team t1 = new HockeyTeam("name", "city", p, g, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Team t2 = new HockeyTeam("name1", "city1", p, g, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        List<Team> t = new ArrayList<Team>();
        t.add(t1);
        t.add(t2);
        TeamManager tm = new TeamManager(t);
        TeamStatManager tsm = new HockeyTeamStatManager(tm);
        tsc = new HockeyTeamStatComparer(tsm);
    }

    @Test()
    public void testCompareStats(){
        assertEquals(2, tsc.compareStats("name", "name1", TeamStats.WINS));
    }

    @Test(timeout = 50)
    public void testCompareStats2(){
        assertEquals(2, tsc.compareStats("name", "name1", TeamStats.SHOTS_FOR));
    }
}
