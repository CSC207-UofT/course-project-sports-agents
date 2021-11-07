package commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TennisPlayerStatManagerTest {
    String sport;
    String playerOne;
    String competition;
    String stat;
    TennisPlayerStatManager manager;
    ArrayList<String> arguments;


    @Before
    public void setUp() {
        sport = "tennis";
        arguments = new ArrayList<>();
        arguments.add(sport);
        manager = new TennisPlayerStatManager();
    }

    @After
    public void tearDown() {
    }

    @Test (timeout = 500)
    public void TestExecuteOneCompetition() throws Exception {
        playerOne = "Daniil Medvedev";
        stat = "aces";
        competition = "Brisbane";
        arguments.add(playerOne);
        arguments.add(stat);
        arguments.add(competition);
        assertEquals("Brisbane: 46", manager.execute(arguments));
    }

    @Test (timeout = 500)
    public void TestExecuteMultipleCompetitions() throws Exception {
        playerOne = "Daniil Medvedev";
        stat = "all stats";
        competition = "Brisbane";
        arguments.add(playerOne);
        arguments.add(stat);
        arguments.add(competition);
        arguments.add("Australian Open");
        arguments.add("Sofia");
        arguments.add("Rotterdam");
        assertEquals("Brisbane:\n" +
                "Name: Daniil Medvedev\n" +
                "Age: 23\n" +
                "Nationality: RUS\n" +
                "Aces: 46\n" +
                "Double Faults: 12\n" +
                "Serve Points: 311\n" +
                "First Serves: 189\n" +
                "Break Points Saved: 18\n" +
                "\n" +
                "Australian Open:\n" +
                "Name: Daniil Medvedev\n" +
                "Age: 23\n" +
                "Nationality: RUS\n" +
                "Aces: 42\n" +
                "Double Faults: 13\n" +
                "Serve Points: 364\n" +
                "First Serves: 232\n" +
                "Break Points Saved: 16\n" +
                "\n" +
                "Sofia:\n" +
                "Name: Daniil Medvedev\n" +
                "Age: 23\n" +
                "Nationality: RUS\n" +
                "Aces: 28\n" +
                "Double Faults: 8\n" +
                "Serve Points: 228\n" +
                "First Serves: 123\n" +
                "Break Points Saved: 9\n" +
                "\n" +
                "Rotterdam:\n" +
                "Name: Daniil Medvedev\n" +
                "Age: 23\n" +
                "Nationality: RUS\n" +
                "Aces: 21\n" +
                "Double Faults: 7\n" +
                "Serve Points: 277\n" +
                "First Serves: 169\n" +
                "Break Points Saved: 12", manager.execute(arguments));
    }

}