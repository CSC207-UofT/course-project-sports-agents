package commands;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import player.HockeyPlayer;
import player.HockeyPlayerList;
import player.PlayerList;

import java.util.Arrays;
import java.util.List;


public class HockeyPlayerStatManagerTest {
    HockeyPlayerStatManager hockeyPlayerStatManager;

    @Before
    public void setUp() throws Exception {
        HockeyPlayer player1 = new HockeyPlayer("Auston Matthews",
                "20202021", "TOR","L", "C",
                52,41,25,66,222,
                18.5);
        HockeyPlayer player2 = new HockeyPlayer("Mikko Rantanen",
                "20202021", "COL", "L", "R",
                52,30,36,66,177,
                17.0);
        HockeyPlayer player3 = new HockeyPlayer("Ryan O'Reilly",
                "20202021", "STL", "L", "C",
                56,24,30,54,129,
                18.6);
        HockeyPlayerList hockeyPlayerList = new HockeyPlayerList();
        hockeyPlayerList.addPlayer(player1);
        hockeyPlayerList.addPlayer(player2);
        hockeyPlayerList.addPlayer(player3);
        this.hockeyPlayerStatManager = new HockeyPlayerStatManager(hockeyPlayerList);
    }

    @Test(timeout = 100)
    public void testExecuteTeamPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Team");
        String output1 = this.hockeyPlayerStatManager.execute(arguments1);
        String expected1 = "Auston Matthews: TOR";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat", "Hockey",
                "Mikko Rantanen", "20202021", "Team");
        String output2 = this.hockeyPlayerStatManager.execute(arguments2);
        String expected2 = "Mikko Rantanen: COL";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat", "Hockey",
                "Ryan O'Reilly", "20202021", "Team");
        String output3 = this.hockeyPlayerStatManager.execute(arguments3);
        String expected3 = "Ryan O'Reilly: STL";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteTeamNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Paul Gries", "20202021", "Team");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteTeamNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20192020", "Team");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteSkaterShootsPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Skater Shoots");
        String output1 = this.hockeyPlayerStatManager.execute(arguments1);
        String expected1 = "Auston Matthews: L";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat", "Hockey",
                "Mikko Rantanen", "20202021", "Skater Shoots");
        String output2 = this.hockeyPlayerStatManager.execute(arguments2);
        String expected2 = "Mikko Rantanen: L";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat", "Hockey",
                "Ryan O'Reilly", "20202021", "Skater Shoots");
        String output3 = this.hockeyPlayerStatManager.execute(arguments3);
        String expected3 = "Ryan O'Reilly: L";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteSkaterShootsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Paul Gries", "20202021", "Skater Shoots");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteSkaterShootsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20192020", "Skater Shoots");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecutePositionPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Position");
        String output1 = this.hockeyPlayerStatManager.execute(arguments1);
        String expected1 = "Auston Matthews: C";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat", "Hockey",
                "Mikko Rantanen", "20202021", "Position");
        String output2 = this.hockeyPlayerStatManager.execute(arguments2);
        String expected2 = "Mikko Rantanen: R";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat", "Hockey",
                "Ryan O'Reilly", "20202021", "Position");
        String output3 = this.hockeyPlayerStatManager.execute(arguments3);
        String expected3 = "Ryan O'Reilly: C";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePositionNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Paul Gries", "20202021", "Position");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePositionNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20192020", "Position");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteGamesPlayedPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Games Played");
        String output1 = this.hockeyPlayerStatManager.execute(arguments1);
        String expected1 = "Auston Matthews: 52";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat", "Hockey",
                "Mikko Rantanen", "20202021", "Games Played");
        String output2 = this.hockeyPlayerStatManager.execute(arguments2);
        String expected2 = "Mikko Rantanen: 52";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat", "Hockey",
                "Ryan O'Reilly", "20202021", "Games Played");
        String output3 = this.hockeyPlayerStatManager.execute(arguments3);
        String expected3 = "Ryan O'Reilly: 56";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Paul Gries", "20202021", "Games Played");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20192020", "Games Played");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteGoalsPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Goals");
        String output1 = this.hockeyPlayerStatManager.execute(arguments1);
        String expected1 = "Auston Matthews: 41";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat", "Hockey",
                "Mikko Rantanen", "20202021", "Goals");
        String output2 = this.hockeyPlayerStatManager.execute(arguments2);
        String expected2 = "Mikko Rantanen: 30";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat", "Hockey",
                "Ryan O'Reilly", "20202021", "Goals");
        String output3 = this.hockeyPlayerStatManager.execute(arguments3);
        String expected3 = "Ryan O'Reilly: 24";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Paul Gries", "20202021", "Goals");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20192020", "Goals");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteAssistsPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Assists");
        String output1 = this.hockeyPlayerStatManager.execute(arguments1);
        String expected1 = "Auston Matthews: 25";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat", "Hockey",
                "Mikko Rantanen", "20202021", "Assists");
        String output2 = this.hockeyPlayerStatManager.execute(arguments2);
        String expected2 = "Mikko Rantanen: 36";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat", "Hockey",
                "Ryan O'Reilly", "20202021", "Assists");
        String output3 = this.hockeyPlayerStatManager.execute(arguments3);
        String expected3 = "Ryan O'Reilly: 30";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Paul Gries", "20202021", "Assists");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20192020", "Assists");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecutePointsPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Points");
        String output1 = this.hockeyPlayerStatManager.execute(arguments1);
        String expected1 = "Auston Matthews: 66";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat", "Hockey",
                "Mikko Rantanen", "20202021", "Points");
        String output2 = this.hockeyPlayerStatManager.execute(arguments2);
        String expected2 = "Mikko Rantanen: 66";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat", "Hockey",
                "Ryan O'Reilly", "20202021", "Points");
        String output3 = this.hockeyPlayerStatManager.execute(arguments3);
        String expected3 = "Ryan O'Reilly: 54";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Paul Gries", "20202021", "Points");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20192020", "Points");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteShotsPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Shots");
        String output1 = this.hockeyPlayerStatManager.execute(arguments1);
        String expected1 = "Auston Matthews: 222";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat", "Hockey",
                "Mikko Rantanen", "20202021", "Shots");
        String output2 = this.hockeyPlayerStatManager.execute(arguments2);
        String expected2 = "Mikko Rantanen: 177";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat", "Hockey",
                "Ryan O'Reilly", "20202021", "Shots");
        String output3 = this.hockeyPlayerStatManager.execute(arguments3);
        String expected3 = "Ryan O'Reilly: 129";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShotsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Paul Gries", "20202021", "Shots");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShotsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20192020", "Shots");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100)
    public void testExecuteShootingPercentagePasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Shooting Percentage");
        String output1 = this.hockeyPlayerStatManager.execute(arguments1);
        String expected1 = "Auston Matthews: 18.5";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat", "Hockey",
                "Mikko Rantanen", "20202021", "Shooting Percentage");
        String output2 = this.hockeyPlayerStatManager.execute(arguments2);
        String expected2 = "Mikko Rantanen: 17.0";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat", "Hockey",
                "Ryan O'Reilly", "20202021", "Shooting Percentage");
        String output3 = this.hockeyPlayerStatManager.execute(arguments3);
        String expected3 = "Ryan O'Reilly: 18.6";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Paul Gries", "20202021", "Shooting Percentage");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20192020", "Shooting Percentage");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat", "Hockey",
                "Auston Matthews", "20202021", "Age");
        String fail = this.hockeyPlayerStatManager.execute(arguments);
    }
}