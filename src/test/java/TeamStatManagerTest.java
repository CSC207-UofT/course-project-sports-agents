import java.util.ArrayList;

import Team.Team;
import commands.TeamStatManager;
import org.junit.*;
import Player.Player;

import static org.junit.jupiter.api.Assertions.*;

public class TeamStatManagerTest {
    private TeamStatManager tsm;

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
        tsm = new TeamStatManager(tm);
    }

    @Test(timeout = 50)
    public void testGetTotalGamesPlayed(){
        assertEquals(0, tsm.getTotalGamesPlayed("name"));
        assertEquals(3, tsm.getTotalGamesPlayed("name1"));
    }

    @Test(timeout = 50)
    public void testGetWins(){
        assertEquals(0, tsm.getWins("name"));
        assertEquals(1, tsm.getWins("name1"));
    }

    @Test(timeout = 50)
    public void testGetLosses(){
        assertEquals(0, tsm.getLosses("name"));
        assertEquals(1, tsm.getLosses("name1"));
    }

    @Test(timeout = 50)
    public void testGetTies(){
        assertEquals(0, tsm.getTies("name"));
        assertEquals(1, tsm.getTies("name1"));
    }

    @Test(timeout = 50)
    public void testGetWinRate(){
        assertEquals(0, tsm.getWinRate("name"));
        assertEquals((float) 1 / 3 * 100, tsm.getWinRate("name1"));
    }

    @Test(timeout = 50)
    public void testGetLossRate(){
        assertEquals(0, tsm.getLossRate("name"));
        assertEquals((float) 1 / 3 * 100, tsm.getLossRate("name1"));
    }
}
