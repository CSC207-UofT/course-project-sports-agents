import java.util.ArrayList;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class TeamManagerTest {
    private TeamManager tm;

    @Before
    public void setUp() throws Exception {
        ArrayList<Player> p = new ArrayList<Player>();
        ArrayList<Game> g  = new ArrayList<Game>();
        HockeyTeam t1 = new HockeyTeam("name", "city", p, g, 0, 0, 0, 0);
        HockeyTeam t2 = new HockeyTeam("name1", "city1", p, g, 1, 1, 1, 1);
        ArrayList<Team> t = new ArrayList<Team>();
        t.add(t1);
        t.add(t2);
        tm = new TeamManager(t);
    }

    @Test(timeout = 50)
    public void testGetTeams(){
        ArrayList<Player> p = new ArrayList<Player>();
        ArrayList<Game> g  = new ArrayList<Game>();
        HockeyTeam t1 = new HockeyTeam("name", "city", p, g, 0, 0, 0, 0);
        HockeyTeam t2 = new HockeyTeam("name1", "city1", p, g, 1, 1, 1, 1);
        ArrayList<Team> t = new ArrayList<Team>();
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
        ArrayList<Player> p = new ArrayList<Player>();
        ArrayList<Game> g  = new ArrayList<Game>();
        Team t = new HockeyTeam("hi", "hello", p, g, 5, 5, 5, 5);
        tm.createTeam("hockey", "hi", "hello", p, g, 5, 5, 5, 5);
        assertEquals(t.getName(), tm.getTeams().get(2).getName());
        assertEquals(t.getHomeCity(), tm.getTeams().get(2).getHomeCity());
        assertEquals(t.getTotalGamesPlayed(), tm.getTeams().get(2).getTotalGamesPlayed());
        assertEquals(t.getWins(), tm.getTeams().get(2).getWins());
        assertEquals(t.getLosses(), tm.getTeams().get(2).getLosses());
        assertEquals(t.getTies(), tm.getTeams().get(2).getTies());
    }
}
