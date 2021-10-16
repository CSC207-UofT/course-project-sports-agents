import java.util.ArrayList;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    private Team t;

    @Before
    public void setUp() throws Exception {
        ArrayList<Player> p = new ArrayList<Player>();
        ArrayList<Game> g  = new ArrayList<Game>();
        t = new HockeyTeam("name", "city", p, g, 0, 0, 0, 0);
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

    //Test get set players

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
}
