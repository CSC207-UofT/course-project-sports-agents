package commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TennisPlayerStatPredictorTest {
    String sport;
    String playerName;
    String stat;
    ArrayList<String> arguments;
    TennisPlayerStatPredictor predictor;

    @Before
    public void setUp() {
        sport = "Tennis";
        playerName = "Novak Djokovic";
        stat = "aces";
        arguments = new ArrayList<>();
        arguments.add(sport);
        arguments.add(playerName);
        arguments.add(stat);
        predictor = new TennisPlayerStatPredictor();
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void TestPredictorExecute() throws Exception {
        assertEquals("Predicted aces in next season/competition: 25",
                predictor.execute(arguments));
    }
}
