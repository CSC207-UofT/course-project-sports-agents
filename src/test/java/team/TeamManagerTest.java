package team;

import java.util.List;
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

import match.Match;
import team.Team;
import team.TennisTeam;

public class TeamManagerTest {
    private TeamManager tm;

    @Before
    public void setUp() throws Exception {
        List<String> p = new ArrayList<String>();
        List<Match> g  = new ArrayList<Match>();
        Team t1 = new TennisTeam("name", "city", p, g, 0, 0, 0, 0, 0, 0, 0);
        Team t2 = new TennisTeam("name1", "city1", p, g, 1, 1, 1, 1, 1, 1, 1);
        List<Team> t = new ArrayList<Team>();
        t.add(t1);
        t.add(t2);
        tm = new TeamManager(t);
    }

    @Test(timeout = 50)
    public void testGetTeams(){
        List<String> p = new ArrayList<String>();
        List<Match> g  = new ArrayList<Match>();
        Team t1 = new TennisTeam("name", "city", p, g, 0, 0, 0, 0, 0, 0, 0);
        Team t2 = new TennisTeam("name1", "city1", p, g, 1, 1, 1, 1, 1, 1, 1);
        List<Team> t = new ArrayList<Team>();
        t.add(t1);
        t.add(t2);
        assertEquals(t.get(0).getName(), tm.getTeams().get(0).getName());
        assertEquals(t.get(0).getHomeCity(), tm.getTeams().get(0).getHomeCity());
        assertEquals(t.get(0).getTotalGamesPlayed(), tm.getTeams().get(0).getTotalGamesPlayed());
        assertEquals(t.get(0).getWins(), tm.getTeams().get(0).getWins());
        assertEquals(t.get(0).getLosses(), tm.getTeams().get(0).getLosses());
        assertEquals(t.get(0).getTies(), tm.getTeams().get(0).getTies());

        assertEquals(t.get(1).getName(), tm.getTeams().get(1).getName());
        assertEquals(t.get(1).getHomeCity(), tm.getTeams().get(1).getHomeCity());
        assertEquals(t.get(1).getTotalGamesPlayed(), tm.getTeams().get(1).getTotalGamesPlayed());
        assertEquals(t.get(1).getWins(), tm.getTeams().get(1).getWins());
        assertEquals(t.get(1).getLosses(), tm.getTeams().get(1).getLosses());
        assertEquals(t.get(1).getTies(), tm.getTeams().get(1).getTies());
    }

    @Test(timeout = 50)
    public void testCreateTeam(){
        List<String> p = new ArrayList<String>();
        List<Match> g  = new ArrayList<Match>();
        Team t = new TennisTeam("name", "city", p, g, 0, 0, 0, 0, 0, 0, 0);
        tm.createTeam(t);
        assertEquals(t.getName(), tm.getTeams().get(2).getName());
        assertEquals(t.getHomeCity(), tm.getTeams().get(2).getHomeCity());
        assertEquals(t.getTotalGamesPlayed(), tm.getTeams().get(2).getTotalGamesPlayed());
        assertEquals(t.getWins(), tm.getTeams().get(2).getWins());
        assertEquals(t.getLosses(), tm.getTeams().get(2).getLosses());
        assertEquals(t.getTies(), tm.getTeams().get(2).getTies());
    }
}
