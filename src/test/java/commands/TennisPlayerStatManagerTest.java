package commands;

import commands.TennisPlayerStatManager;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TennisPlayerStatManagerTest {
    String playerOne;
    String competition;
    String stat;
    TennisPlayerStatManager manager;
    ArrayList<String> arguments;

    @Before
    public void setUp() {
        playerOne = "Daniil Medvedev";
        stat = "aces";
        competition = "Brisbane";
        arguments = new ArrayList<>();
        arguments.add(playerOne);
        arguments.add(stat);
        arguments.add(competition);
        manager = new TennisPlayerStatManager();
    }

    @After
    public void tearDown() {
    }

    @Test (timeout = 50)
    public void TestExecute() throws Exception {
        assertEquals("Brisbane: 46", manager.execute(arguments));
    }

}