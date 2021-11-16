package team;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;

import match.Match;
import team.HockeyTeam;

public class HockeyTeamTest {
    private HockeyTeam t;

    @Before
    public void setUp() throws Exception {
        ArrayList<String> p = new ArrayList<String>();
        ArrayList<Match> g  = new ArrayList<Match>();
        t = new HockeyTeam("name", "city", p, g, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
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
    public void testGetGoalsFor(){
        assertEquals(0, t.getGoalsFor());
    }

    @Test(timeout = 50)
    public void testSetGoalsFor(){
        t.setGoalsFor(1);
        assertEquals(1, t.getGoalsFor());
    }

    @Test(timeout = 50)
    public void testGetGoalsAgainst(){
        assertEquals(0, t.getGoalsAgainst());
    }

    @Test(timeout = 50)
    public void testSetGoalsAgainst(){
        t.setGoalsAgainst(1);
        assertEquals(1, t.getGoalsAgainst());
    }

    @Test(timeout = 50)
    public void testGetFaceOffWinPercentage(){
        assertEquals(0f, t.getFaceOffWinPercentage(), 0);
    }

    @Test(timeout = 50)
    public void testSetFaceOffWinPercentage(){
        t.setFaceOffWinPercentage(1f);
        assertEquals(1f, t.getFaceOffWinPercentage(), 0);
    }

    @Test(timeout = 50)
    public void testGetShotsFor(){
        assertEquals(0, t.getShotsFor());
    }

    @Test(timeout = 50)
    public void testSetShotsFor(){
        t.setShotsFor(1);
        assertEquals(1, t.getShotsFor());
    }

    @Test(timeout = 50)
    public void testGetShotsAgainst(){
        assertEquals(0, t.getShotsAgainst());
    }

    @Test(timeout = 50)
    public void testSetShotsAgainst(){
        t.setShotsAgainst(1);
        assertEquals(1, t.getShotsAgainst());
    }

    @Test(timeout = 50)
    public void testGetRegulationWins(){
        assertEquals(0, t.getRegulationWins());
    }

    @Test(timeout = 50)
    public void testSetRegulationWins(){
        t.setRegulationWins(1);
        assertEquals(1, t.getRegulationWins());
    }

    @Test(timeout = 50)
    public void testGetRegulationPlusOvertimeWins(){
        assertEquals(0, t.getRegulationPlusOvertimeWins());
    }

    @Test(timeout = 50)
    public void testSetRegulationPlusOvertimeWins(){
        t.setRegulationPlusOvertimeWins(1);
        assertEquals(1, t.getRegulationPlusOvertimeWins());
    }

    @Test(timeout = 50)
    public void testGetShootoutGamesWon(){
        assertEquals(0, t.getShootoutGamesWon());
    }

    @Test(timeout = 50)
    public void testSetShootoutGamesWon(){
        t.setShootoutGamesWon(1);
        assertEquals(1, t.getShootoutGamesWon());
    }

    @Test(timeout = 50)
    public void testGetOvertimeLosses(){
        assertEquals(0, t.getOvertimeLosses());
    }

    @Test(timeout = 50)
    public void testSetOvertimeLosses(){
        t.setOvertimeLosses(1);
        assertEquals(1, t.getOvertimeLosses());
    }
}
