import commannds.TennisPlayerStatComparer;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TennisPlayerStatComparerTest {
    String playerOne;
    String playerTwo;
    String competition;
    String stat;
    TennisPlayerStatComparer comparer;
    ArrayList<String> arguments;

    @Before
    public void setUp() {
        playerOne = "Nick Kyrgios";
        playerTwo = "Jordan Thompson";
        stat = "serve points";
        competition = "Brisbane";
        arguments = new ArrayList<>();
        arguments.add(playerOne);
        arguments.add(playerTwo);
        arguments.add(stat);
        arguments.add(competition);
        comparer = new TennisPlayerStatComparer();
    }

    @After
    public void tearDown() {
    }

    @Test (timeout = 500)
    public void TestExecute() throws Exception {
        assertEquals("Maximum:\n" +
                        "Name: Nick Kyrgios\n" +
                        "Age: 24\n" +
                        "Nationality: AUS\n" +
                        "Aces: 57\n" +
                        "Double Faults: 9\n" +
                        "Serve Points: 199\n" +
                        "First Serves: 139\n" +
                        "Break Points Saved: 3\n" +
                        "\n" +
                        "Minimum:\n" +
                        "Name: Jordan Thompson\n" +
                        "Age: 25\n" +
                        "Nationality: AUS\n" +
                        "Aces: 6\n" +
                        "Double Faults: 2\n" +
                        "Serve Points: 98\n" +
                        "First Serves: 68\n" +
                        "Break Points Saved: 3",
                 comparer.execute(arguments));
    }

}