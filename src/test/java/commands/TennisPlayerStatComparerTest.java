package commands;

import commands.TennisPlayerStatComparer;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TennisPlayerStatComparerTest {
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
        playerOne = "Nick Kyrgios";
        playerTwo = "Jordan Thompson";
        arguments = new ArrayList<>();
        arguments.add(playerOne);
        arguments.add(playerTwo);
        comparer = new TennisPlayerStatComparer();
    }

    @After
    public void tearDown() {
    }

    @Test (timeout = 500)
    public void TestExecuteTwoPlayers() throws Exception {
        stat = "serve points";
        competition = "Brisbane";
        arguments.add(stat);
        arguments.add(competition);
        assertEquals("Brisbane\n" +
                        "From lowest to highest:\n" +
                        "Jordan Thompson: 98 serve points\n" +
                        "Nick Kyrgios: 199 serve points",
                 comparer.execute(arguments));
    }

    @Test (timeout = 500)
    public void TestExecuteMultiplePlayers() throws Exception {
        playerThree = "Andreas Seppi";
        playerFour = "Lloyd Harris";
        stat = "first serves";
        competition = "Delray Beach";
        arguments.add(playerThree);
        arguments.add(playerFour);
        arguments.add(stat);
        arguments.add(competition);
        assertEquals("Delray Beach\n" +
                "From lowest to highest:\n" +
                "Jordan Thompson: 71 first serves\n" +
                "Lloyd Harris: 85 first serves\n" +
                "Nick Kyrgios: 109 first serves\n" +
                "Andreas Seppi: 111 first serves", comparer.execute(arguments));
    }
}