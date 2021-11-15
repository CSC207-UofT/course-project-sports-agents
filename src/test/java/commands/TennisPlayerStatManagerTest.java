package commands;

import jdk.jshell.spi.ExecutionControlProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import player.TennisPlayerList;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TennisPlayerStatManagerTest {
    TennisPlayerList tennisPlayerList;
    String command;
    String sport;
    String playerOne;
    String competition;
    String stat;
    TennisPlayerStatManager manager;
    ArrayList<String> arguments;


    @Before
    public void setUp() throws Exception {
        command = "get_player_stat";
        sport = "tennis";
        tennisPlayerList = new TennisPlayerList();
        arguments = new ArrayList<>();
        arguments.add(command);
        arguments.add(sport);
        manager = new TennisPlayerStatManager(tennisPlayerList);
    }

    @After
    public void tearDown() {
    }

    @Test (timeout = 500)
    public void TestExecuteAces() throws Exception {
        playerOne = "Daniil Medvedev";
        stat = "Aces";
        competition = "Brisbane";
        arguments.add(playerOne);
        arguments.add(competition);
        arguments.add(stat);
        assertEquals("Daniil Medvedev: 46", manager.execute(arguments));
    }

    @Test (timeout = 500)
    public void TestExecuteAllStats() throws Exception {
        playerOne = "Kei Nishikori";
        stat = "All Stats";
        competition = "Australian Open";
        arguments.add(playerOne);
        arguments.add(competition);
        arguments.add(stat);
        assertEquals("Kei Nishikori: Age: 29\n" +
                "Nationality: JPN\n" +
                "Aces: 33\n" +
                "Double Faults: 13\n" +
                "Serve Points: 601\n" +
                "First Serves: 406\n" +
                "Break Points Saved: 18", manager.execute(arguments));
    }

    @Test (timeout = 500)
    public void TestExecuteDoubleFaults() throws Exception {
        playerOne = "Daniil Medvedev";
        stat = "Double Faults";
        competition = "Brisbane";
        arguments.add(playerOne);
        arguments.add(competition);
        arguments.add(stat);
        assertEquals("Daniil Medvedev: 12", manager.execute(arguments));
    }

    @Test (timeout = 500)
    public void TestExecuteServePoints() throws Exception {
        playerOne = "Daniil Medvedev";
        stat = "Serve Points";
        competition = "Brisbane";
        arguments.add(playerOne);
        arguments.add(competition);
        arguments.add(stat);
        assertEquals("Daniil Medvedev: 311", manager.execute(arguments));
    }

    @Test (timeout = 500)
    public void TestExecuteFirstServes() throws Exception {
        playerOne = "Daniil Medvedev";
        stat = "First Serves";
        competition = "Brisbane";
        arguments.add(playerOne);
        arguments.add(competition);
        arguments.add(stat);
        assertEquals("Daniil Medvedev: 189", manager.execute(arguments));
    }

    @Test (timeout = 500)
    public void TestExecuteAge() throws Exception {
        playerOne = "Daniil Medvedev";
        stat = "Age";
        competition = "Brisbane";
        arguments.add(playerOne);
        arguments.add(competition);
        arguments.add(stat);
        assertEquals("Daniil Medvedev: 23", manager.execute(arguments));
    }




}