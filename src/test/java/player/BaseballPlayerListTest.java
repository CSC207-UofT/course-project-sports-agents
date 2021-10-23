package player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class BaseballPlayerListTest {
    BaseballPlayerList baseballPlayers;

    @Before
    public void setup() {
        baseballPlayers = new BaseballPlayerList();
    }

    @After
    public void tearDown() {}

    @Test(timeout = 100)
    public void testFindBaseballPlayer() throws Exception {
        assertEquals("Name: Juan Soto\n" +
                "Team: WSH\n" +
                "Position: LF\n" +
                "Games Played: 151\n" +
                "Hits: 157\n" +
                "Home Runs: 29\n" +
                "Walks: 145\n" +
                "Strikeouts: 93\n" +
                "Wins Above Replacement: 7.0",
                baseballPlayers.findBaseballPlayer("2021", "Juan Soto").toString());
    }
}
