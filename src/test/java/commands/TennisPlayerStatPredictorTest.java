package commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import player.TennisPlayerList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TennisPlayerStatPredictorTest {
    TennisPlayerList tennisPlayerList;
    String command;
    String sport;
    String playerName;
    String stat;
    List<String> arguments;
    TennisPlayerStatPredictor predictor;


    @Before
    public void setUp() throws Exception {
        command = "predict_player_stat";
        sport = "Tennis";
        playerName = "Novak Djokovic";
        tennisPlayerList = new TennisPlayerList();
        arguments = new ArrayList<>();
        arguments.add(command);
        arguments.add(sport);
        arguments.add(playerName);
        predictor = new TennisPlayerStatPredictor(tennisPlayerList);
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void TestPredictorExecuteAces() throws Exception {
        stat = "Aces";
        arguments.add(stat);
        assertEquals("Previous Statistics:\n" +
                        "Doha: 24.0\n" +
                        "Australian Open: 45.0\n" +
                        "Indian Wells Masters: 5.0\n" +
                        "Miami Masters: 19.0\n" +
                        "Monte Carlo Masters: 8.0\n" +
                        "Madrid Masters: 16.0\n" +
                        "Rome Masters: 18.0\n" +
                        "Roland Garros: 31.0\n" +
                        "Wimbledon: 59.0\n" +
                        "Cincinnati Masters: 34.0\n" +
                        "US Open: 19.0\n" +
                        "Tokyo: 38.0\n" +
                        "Shanghai Masters: 20.0\n" +
                        "Paris Masters: 22.0\n" +
                        "Tour Finals: 15.0\n" +
                        "Prediction for next season: 25",
                predictor.execute(arguments));
    }

    @Test(timeout = 500)
    public void TestPredictorExecuteFirstServes() throws Exception {
        stat = "First Serves";
        arguments.add(stat);
        assertEquals("Previous Statistics:\n" +
                        "Doha: 208.0\n" +
                        "Australian Open: 356.0\n" +
                        "Indian Wells Masters: 74.0\n" +
                        "Miami Masters: 139.0\n" +
                        "Monte Carlo Masters: 145.0\n" +
                        "Madrid Masters: 171.0\n" +
                        "Rome Masters: 269.0\n" +
                        "Roland Garros: 371.0\n" +
                        "Wimbledon: 491.0\n" +
                        "Cincinnati Masters: 176.0\n" +
                        "US Open: 188.0\n" +
                        "Tokyo: 159.0\n" +
                        "Shanghai Masters: 140.0\n" +
                        "Paris Masters: 193.0\n" +
                        "Tour Finals: 128.0\n" +
                        "Prediction for next season: 182",
                predictor.execute(arguments));
    }

}
