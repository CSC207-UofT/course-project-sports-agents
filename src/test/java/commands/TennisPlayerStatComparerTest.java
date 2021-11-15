package commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import player.TennisPlayerList;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TennisPlayerStatComparerTest {
    TennisPlayerList tennisPlayerList;
    String command;
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
    public void setUp() throws Exception {
        command = "player_compare_stat";
        sport = "tennis";
        arguments = new ArrayList<>();
        arguments.add(command);
        arguments.add(sport);
        tennisPlayerList = new TennisPlayerList();
        comparer = new TennisPlayerStatComparer(tennisPlayerList);
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
        stat = "Serve Points";
        competition = "Brisbane";
        arguments.add(competition);
        arguments.add(stat);
        assertEquals("From best to worst:\n" +
                        "Daniil Medvedev: 311\n" +
                        "Jordan Thompson: 98",
                 comparer.execute(arguments));
    }

    @Test (timeout = 500)
    public void TestExecuteMultiplePlayers() throws Exception {
        playerOne = "Daniel Evans";
        playerTwo = "Adrian Mannarino";
        playerThree = "Andreas Seppi";
        playerFour = "Lloyd Harris";
        stat = "First Serves";
        competition = "Delray Beach";
        arguments.add(playerOne);
        arguments.add(playerTwo);
        arguments.add(playerThree);
        arguments.add(playerFour);
        arguments.add(competition);
        arguments.add(stat);
        assertEquals("From best to worst:\n" +
                "Daniel Evans: 246\n" +
                "Andreas Seppi: 111\n" +
                "Adrian Mannarino: 107\n" +
                "Lloyd Harris: 85", comparer.execute(arguments));
    }
}