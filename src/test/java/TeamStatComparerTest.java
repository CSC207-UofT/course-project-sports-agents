import java.util.ArrayList;

import Team.Team;
import commannds.TeamStatComparer;
import commannds.TeamStatManager;
import org.junit.*;
import Player.Player;

import static org.junit.jupiter.api.Assertions.*;

public class TeamStatComparerTest {
    private TeamStatComparer tsc;

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
        tsc = new TeamStatComparer(tsm);
    }

    @Test(timeout = 50)
    public void testCompareTotalGamesPlayed(){
        assertEquals(2, tsc.compareTotalGamesPlayed("name", "name1"));
    }

    @Test(timeout = 50)
    public void testCompareWins(){
        assertEquals(2, tsc.compareWins("name", "name1"));
    }

    @Test(timeout = 50)
    public void testCompareLosses(){
        assertEquals(2, tsc.compareLosses("name", "name1"));
    }

    @Test(timeout = 50)
    public void testGetTies(){
        assertEquals(2, tsc.compareTies("name", "name1"));
    }

    @Test(timeout = 50)
    public void testCompareWinRate(){
        assertEquals(2, tsc.compareWinRate("name", "name1"));
    }

    @Test(timeout = 50)
    public void testGetLossRate(){
        assertEquals(2, tsc.compareLossRate("name", "name1"));
    }
}
