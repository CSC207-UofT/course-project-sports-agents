import java.util.ArrayList;

import Team.Team;
import commannds.TeamStatComparer;
import commannds.TeamStatManager;
import commannds.TeamStatPredictor;
import org.junit.*;
import Player.Player;

import static org.junit.jupiter.api.Assertions.*;

public class TeamStatPredictorTest {
    TeamStatPredictor tsp;

    @Before
    public void setUp() throws Exception {
        ArrayList<Player> p = new ArrayList<Player>();
        ArrayList<Game> g  = new ArrayList<Game>();
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
        //assertEquals(2, tsc.compareTotalGamesPlayed("name", "name1"));
    }
}
