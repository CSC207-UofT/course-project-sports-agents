package team;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;

import match.Match;
import team.TennisTeam;

public class TennisTeamTest {
    private TennisTeam t;

    @Before
    public void setUp() throws Exception {
        List<String> p = new ArrayList<String>();
        List<Match> g  = new ArrayList<Match>();
        t = new TennisTeam("name", "city", p, g, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test(timeout = 50)
    public void testGetName(){
        assertEquals("name", t.getName());
    }

    @Test(timeout = 50)
    public void testSetName(){
        t.setName("hi");
        assertEquals("hi", t.getName());
    }

    @Test(timeout = 50)
    public void testGetHomeCity(){
        assertEquals("city", t.getHomeCity());
    }

    @Test(timeout = 50)
    public void testSetHomeCity(){
        t.setHomeCity("hi");
        assertEquals("hi", t.getHomeCity());
    }

    @Test(timeout = 50)
    public void testGetPlayers(){
        assertEquals("city", t.getHomeCity());
    }

    @Test(timeout = 50)
    public void testSetPlayers(){
        List<String> p = new ArrayList<String>();
        p.add("playerName");
        t.setPlayers(p);
        assertEquals(p, t.getPlayers());
    }

    //Test get set games

    @Test(timeout = 50)
    public void testGetTotalGamesPlayed(){
        assertEquals(0, t.getTotalGamesPlayed());
    }

    @Test(timeout = 50)
    public void testSetTotalGamesPlayed(){
        t.setTotalGamesPlayed(1);
        assertEquals(1, t.getTotalGamesPlayed());
    }

    @Test(timeout = 50)
    public void testGetWins(){
        assertEquals(0, t.getWins());
    }

    @Test(timeout = 50)
    public void testSetWins(){
        t.setWins(1);
        assertEquals(1, t.getWins());
    }

    @Test(timeout = 50)
    public void testGetLosses(){
        assertEquals(0, t.getLosses());
    }

    @Test(timeout = 50)
    public void testSetLosses(){
        t.setLosses(1);
        assertEquals(1, t.getLosses());
    }

    @Test(timeout = 50)
    public void testGetTies(){
        assertEquals(0, t.getTies());
    }

    @Test(timeout = 50)
    public void testSetTies(){
        t.setTies(1);
        assertEquals(1, t.getTies());
    }

    @Test(timeout = 50)
    public void testGetRank(){
        assertEquals(0, t.getRank());
    }

    @Test(timeout = 50)
    public void testSetRank(){
        t.setRank(1);
        assertEquals(1, t.getRank());
    }

    @Test(timeout = 50)
    public void testGetTotalTournamentsPlayed(){
        assertEquals(0, t.getTotalTournamentsPlayed());
    }

    @Test(timeout = 50)
    public void testSetTotalTournamentsPlayed(){
        t.setTotalTournamentsPlayed(1);
        assertEquals(1, t.getTotalTournamentsPlayed());
    }

    @Test(timeout = 50)
    public void testGetTournamentWins(){
        assertEquals(0, t.getTournamentWins());
    }

    @Test(timeout = 50)
    public void testSetTournamentWins(){
        t.setTournamentWins(1);
        assertEquals(1, t.getTournamentWins());
    }
}
