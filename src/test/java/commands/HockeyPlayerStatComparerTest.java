package commands;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import player.HockeyPlayer;
import player.PlayerList;

import java.util.Arrays;
import java.util.List;

public class HockeyPlayerStatComparerTest {
    HockeyPlayerStatComparer hockeyPlayerStatComparer;

    @Before
    public void setUp() throws Exception {
        HockeyPlayer player1 = new HockeyPlayer("Player 1",
                "20202021", "TOR","L", "C",
                50,40,60,50,40,
                50.0);
        HockeyPlayer player2 = new HockeyPlayer("Player 2",
                "20202021", "COL", "L", "R",
                50,50,50,40,60,
                60.0);
        HockeyPlayer player3 = new HockeyPlayer("Player 3",
                "20202021", "STL", "L", "C",
                50,60,40,60,50,
                40.0);
        PlayerList<HockeyPlayer> hockeyPlayerList = new PlayerList<HockeyPlayer>();
        hockeyPlayerList.addPlayer(player1);
        hockeyPlayerList.addPlayer(player2);
        hockeyPlayerList.addPlayer(player3);
        this.hockeyPlayerStatComparer = new HockeyPlayerStatComparer(hockeyPlayerList);
    }

    @Test(timeout = 100)
    public void testExecuteGamesPlayedPasses() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20202021", "Games Played");
        String output = this.hockeyPlayerStatComparer.execute(arguments);
        String expected = "From best to worst:\n" +
                          "Player 3: 50\n" +
                          "Player 2: 50\n" +
                          "Player 1: 50\n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Paul Gries", "Player 2",
                "Player 3", "20202021", "Games Played");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20192020", "Games Played");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteGoalsPasses() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20202021", "Goals");
        String output = this.hockeyPlayerStatComparer.execute(arguments);
        String expected = "From best to worst:\n" +
                          "Player 3: 60\n" +
                          "Player 2: 50\n" +
                          "Player 1: 40\n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Paul Gries", "Player 2",
                "Player 3", "20202021", "Goals");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20192020", "Goals");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteAssistsPasses() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20202021", "Assists");
        String output = this.hockeyPlayerStatComparer.execute(arguments);
        String expected = "From best to worst:\n" +
                          "Player 1: 60\n" +
                          "Player 2: 50\n" +
                          "Player 3: 40\n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Paul Gries", "Player 2",
                "Player 3", "20202021", "Assists");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20192020", "Assists");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecutePointsPasses() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20202021", "Points");
        String output = this.hockeyPlayerStatComparer.execute(arguments);
        String expected = "From best to worst:\n" +
                          "Player 3: 60\n" +
                          "Player 1: 50\n" +
                          "Player 2: 40\n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Paul Gries", "Player 2",
                "Player 3", "20202021", "Points");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20192020", "Points");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteShotsPasses() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20202021", "Shots");
        String output = this.hockeyPlayerStatComparer.execute(arguments);
        String expected = "From best to worst:\n" +
                          "Player 2: 60\n" +
                          "Player 3: 50\n" +
                          "Player 1: 40\n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShotsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Paul Gries", "Player 2",
                "Player 3", "20202021", "Shots");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShotsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20192020", "Shots");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteShootingPercentagePasses() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20202021", "Shooting Percentage");
        String output = this.hockeyPlayerStatComparer.execute(arguments);
        String expected = "From best to worst:\n" +
                          "Player 2: 60.0\n" +
                          "Player 1: 50.0\n" +
                          "Player 3: 40.0\n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Paul Gries", "Player 2",
                "Player 3", "20202021", "Shooting Percentage");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20192020", "Shooting Percentage");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        List<String> arguments = Arrays.asList("compare_player_stat",
                "Hockey", "Player 1", "Player 2",
                "Player 3", "20202021", "Name");
        String fail = this.hockeyPlayerStatComparer.execute(arguments);
    }
}