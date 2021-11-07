package commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TennisPlayerStatComparerTest {
    String sport;
    String playerOne;
    String playerTwo;
    String playerThree;
    String playerFour;
    String competition;
    String stat;
    TennisPlayerStatComparer comparer;
    ArrayList<String> arguments;

    @Before
    public void setUp() {
        sport = "tennis";
        arguments = new ArrayList<>();
        arguments.add(sport);
        comparer = new TennisPlayerStatComparer();
    }

    @After
    public void tearDown() {
    }

    @Test (timeout = 500)
    public void TestExecuteTwoPlayers() throws Exception {
        playerOne = "Daniil Medvedev";
        playerTwo = "Jordan Thompson";
        arguments.add(playerOne);
        arguments.add(playerTwo);
        stat = "serve points";
        competition = "Brisbane";
        arguments.add(stat);
        arguments.add(competition);
        assertEquals("Brisbane\n" +
                        "From lowest to highest:\n" +
                        "Jordan Thompson: 98 serve points\n" +
                        "Daniil Medvedev: 311 serve points",
                 comparer.execute(arguments));
    }

    @Test (timeout = 500)
    public void TestExecuteMultiplePlayers() throws Exception {
        playerOne = "Daniel Evans";
        playerTwo = "Adrian Mannarino";
        playerThree = "Andreas Seppi";
        playerFour = "Lloyd Harris";
        stat = "first serves";
        competition = "Delray Beach";
        arguments.add(playerOne);
        arguments.add(playerTwo);
        arguments.add(playerThree);
        arguments.add(playerFour);
        arguments.add(stat);
        arguments.add(competition);
        assertEquals("Delray Beach\n" +
                "From lowest to highest:\n" +
                "Lloyd Harris: 85 first serves\n" +
                "Adrian Mannarino: 107 first serves\n" +
                "Andreas Seppi: 111 first serves\n" +
                "Daniel Evans: 246 first serves", comparer.execute(arguments));
    }
}