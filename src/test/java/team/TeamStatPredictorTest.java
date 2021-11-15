package team;

import java.util.ArrayList;

import commands.TeamStatComparer;
import commands.TeamStatManager;
import commands.TeamStatPredictor;
import org.junit.*;
import match.Match;
import player.Player;

public class TeamStatPredictorTest {
    TeamStatPredictor tsp;

    @Before
    public void setUp() throws Exception {
        ArrayList<Player> p = new ArrayList<Player>();
        ArrayList<Match> g  = new ArrayList<Match>();
        HockeyTeam t1 = new HockeyTeam("name", "city", p, g, 0, 0, 0, 0);
        HockeyTeam t2 = new HockeyTeam("name1", "city1", p, g, 3, 1, 1, 1);
        ArrayList<Team> t = new ArrayList<Team>();
        t.add(t1);
        t.add(t2);
        TeamManager tm = new TeamManager(t);
        TeamStatManager tsm = new TeamStatManager(tm);
        TeamStatComparer tsc = new TeamStatComparer(tsm);
        tsp = new TeamStatPredictor();
    }

    @Test(timeout = 50)
    public void test(){
//        assertEquals(2, tsp.compareTotalGamesPlayed("name", "name1"));
    }
}
