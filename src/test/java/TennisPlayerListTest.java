import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;

public class TennisPlayerListTest {
    TennisPlayerList tennisPlayerList;

    @Before
    public void setUp() throws FileNotFoundException {
        tennisPlayerList = new TennisPlayerList("2017 Brisbane International",
                new FileReader("src/main/sample_data/2017_Brisbane_International.csv"));
    }

    @After
    public void tearDown() {}

    @Test(timeout = 100)
    public void TestTrueContainsPlayer() {
        assertTrue(tennisPlayerList.containsPlayer("2017 Brisbane International", "Dominic Thiem"));

    }

    @Test(timeout = 50)
    public void TestFalseContainsPlayer() {
        assertFalse(tennisPlayerList.containsPlayer("2017 Brisbane International",
                "Serena Williams"));
    }

    @Test(timeout = 100)
    public void testTrueFindTennisPlayer() throws Exception {
        assertEquals("Name: Dominic Thiem\n" +
                        "Age: 28\n" +
                        "Nationality: Austrian\n" +
                        "Sets Won: 3\n" +
                        "Sets Lost: 2\n" +
                        "Games Won: 25\n" +
                        "Games Lost: 25",
                tennisPlayerList.findTennisPlayer("2017 Brisbane International",
                "Dominic Thiem"));
    }

    @Test(timeout = 100)
    public void testFindCompetitionWinner() {
        assertEquals("Name: Grigor Dimitrov\n" +
                        "Age: 30\n" +
                        "Nationality: Bulgarian\n" +
                        "Sets Won: 10\n" +
                        "Sets Lost: 2\n" +
                        "Games Won: 67\n" +
                        "Games Lost: 42",
                tennisPlayerList.findCompetitionWinner("2017 Brisbane International"));

    }

}