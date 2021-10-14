import org.junit.*;

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
        assertTrue(tennisPlayerList.containsPlayer("2017 Brisbane International",
                "Dominic Thiem"));

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

    @Test(timeout = 200)
    public void testFindPlayerNewCompetitions() throws Exception {
        tennisPlayerList.addTournament("2017 Aircel Chennai Open",
                new FileReader("src/main/sample_data/2017_Aircel_Chennai_Open.csv"));

        assertEquals("Name: Daniil Medvedev\n" +
                        "Age: 25\n" +
                        "Nationality: Russian\n" +
                        "Sets Won: 8\n" +
                        "Sets Lost: 3\n" +
                        "Games Won: 60\n" +
                        "Games Lost: 44",
                tennisPlayerList.findTennisPlayer("2017 Aircel Chennai Open",
                    "Daniil Medvedev"));
    }

    @Test(timeout = 200)
    public void testFindWinnerMultipleCompetitions() throws Exception {
        tennisPlayerList.addTournament("2017 Aircel Chennai Open",
                new FileReader("src/main/sample_data/2017_Aircel_Chennai_Open.csv"));

        assertEquals("Name: Roberto Bautista Agut\n" +
                        "Age: 33\n" +
                        "Nationality: Spanish\n" +
                        "Sets Won: 8\n" +
                        "Sets Lost: 1\n" +
                        "Games Won: 50\n" +
                        "Games Lost: 32",
                tennisPlayerList.findCompetitionWinner("2017 Aircel Chennai Open"));

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