package team;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;

import match.Match;
import team.BaseballTeam;

public class BaseballTeamTest {
    private BaseballTeam t;

    @Before
    public void setUp() throws Exception {
        ArrayList<String> p = new ArrayList<String>();
        ArrayList<Match> g  = new ArrayList<Match>();
        t = new BaseballTeam("name", "city", p, g, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
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
    public void testGetGamesStarted(){
        assertEquals(0, t.getGamesStarted());
    }

    @Test(timeout = 50)
    public void testSetGamesStarted(){
        t.setGamesStarted(1);
        assertEquals(1, t.getGamesStarted());
    }

    @Test(timeout = 50)
    public void testGetCompleteGames(){
        assertEquals(0, t.getCompleteGames());
    }

    @Test(timeout = 50)
    public void testSetCompleteGames(){
        t.setCompleteGames(1);
        assertEquals(1, t.getCompleteGames());
    }

    @Test(timeout = 50)
    public void testGetShutouts(){
        assertEquals(0, t.getShutouts());
    }

    @Test(timeout = 50)
    public void testSetShutouts(){
        t.setShutouts(1);
        assertEquals(1, t.getShutouts());
    }

    @Test(timeout = 50)
    public void testGetSaves(){
        assertEquals(0, t.getSaves());
    }

    @Test(timeout = 50)
    public void testSetSaves(){
        t.setSaves(1);
        assertEquals(1, t.getSaves());
    }

    @Test(timeout = 50)
    public void testGetSaveOpportunities(){
        assertEquals(0, t.getSaveOpportunities());
    }

    @Test(timeout = 50)
    public void testSetSaveOpportunities(){
        t.setSaveOpportunities(1);
        assertEquals(1, t.getSaveOpportunities());
    }

    @Test(timeout = 50)
    public void testGetInningsPitched(){
        assertEquals(0, t.getInningsPitched());
    }

    @Test(timeout = 50)
    public void testSetInningsPitched(){
        t.setInningsPitched(1);
        assertEquals(1, t.getInningsPitched());
    }

    @Test(timeout = 50)
    public void testGetHitsAllowed(){
        assertEquals(0, t.getHitsAllowed());
    }

    @Test(timeout = 50)
    public void testSetHitsAllowed(){
        t.setHitsAllowed(1);
        assertEquals(1, t.getHitsAllowed());
    }

    @Test(timeout = 50)
    public void testGetRunsAllowed(){
        assertEquals(0, t.getRunsAllowed());
    }

    @Test(timeout = 50)
    public void testSetRunsAllowed(){
        t.setRunsAllowed(1);
        assertEquals(1, t.getRunsAllowed());
    }

    @Test(timeout = 50)
    public void testGetEarnedRuns(){
        assertEquals(0, t.getEarnedRuns());
    }

    @Test(timeout = 50)
    public void testSetEarnedRuns(){
        t.setEarnedRuns(1);
        assertEquals(1, t.getEarnedRuns());
    }

    @Test(timeout = 50)
    public void testGetHomeRunsAllowed(){
        assertEquals(0, t.getHomeRunsAllowed());
    }

    @Test(timeout = 50)
    public void testSetHomeRunsAllowed(){
        t.setHomeRunsAllowed(1);
        assertEquals(1, t.getHomeRunsAllowed());
    }

    @Test(timeout = 50)
    public void testGetHitBatsmen(){
        assertEquals(0, t.getHitBatsmen());
    }

    @Test(timeout = 50)
    public void testSetHitBatsmen(){
        t.setHitBatsmen(1);
        assertEquals(1, t.getHitBatsmen());
    }

    @Test(timeout = 50)
    public void testGetAtBats(){
        assertEquals(0, t.getAtBats());
    }

    @Test(timeout = 50)
    public void testSetAtBats(){
        t.setAtBats(1);
        assertEquals(1, t.getAtBats());
    }

    @Test(timeout = 50)
    public void testGetRuns(){
        assertEquals(0, t.getRuns());
    }

    @Test(timeout = 50)
    public void testSetRuns(){
        t.setRuns(1);
        assertEquals(1, t.getRuns());
    }

    @Test(timeout = 50)
    public void testGetHits(){
        assertEquals(0, t.getHits());
    }

    @Test(timeout = 50)
    public void testSetHits(){
        t.setHits(1);
        assertEquals(1, t.getHits());
    }

    @Test(timeout = 50)
    public void testGetDoubles(){
        assertEquals(0, t.getDoubles());
    }

    @Test(timeout = 50)
    public void testSetDoubles(){
        t.setDoubles(1);
        assertEquals(1, t.getDoubles());
    }

    @Test(timeout = 50)
    public void testGetTriples(){
        assertEquals(0, t.getTriples());
    }

    @Test(timeout = 50)
    public void testSetTriples(){
        t.setTriples(1);
        assertEquals(1, t.getTriples());
    }

    @Test(timeout = 50)
    public void testGetHomeRuns(){
        assertEquals(0, t.getHomeRuns());
    }

    @Test(timeout = 50)
    public void testSetHomeRuns(){
        t.setHomeRuns(1);
        assertEquals(1, t.getHomeRuns());
    }

    @Test(timeout = 50)
    public void testGetRunBattedIn(){
        assertEquals(0, t.getRunBattedIn());
    }

    @Test(timeout = 50)
    public void testSetRunBattedIn(){
        t.setRunBattedIn(1);
        assertEquals(1, t.getRunBattedIn());
    }

    @Test(timeout = 50)
    public void testGetWalks(){
        assertEquals(0, t.getWalks());
    }

    @Test(timeout = 50)
    public void testSetWalks(){
        t.setWalks(1);
        assertEquals(1, t.getWalks());
    }

    @Test(timeout = 50)
    public void testGetStrikeouts(){
        assertEquals(0, t.getStrikeouts());
    }

    @Test(timeout = 50)
    public void testSetStrikeouts(){
        t.setStrikeouts(1);
        assertEquals(1, t.getStrikeouts());
    }

    @Test(timeout = 50)
    public void testGetStolenBases(){
        assertEquals(0, t.getStolenBases());
    }

    @Test(timeout = 50)
    public void testSetStolenBases(){
        t.setStolenBases(1);
        assertEquals(1, t.getStolenBases());
    }

    @Test(timeout = 50)
    public void testGetCaughtStealing(){
        assertEquals(0, t.getCaughtStealing());
    }

    @Test(timeout = 50)
    public void testSetCaughtStealing(){
        t.setCaughtStealing(1);
        assertEquals(1, t.getCaughtStealing());
    }
}
