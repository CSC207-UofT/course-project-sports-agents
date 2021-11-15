package commands;

import drivers_adapters.CSVDataContainer;
import drivers_adapters.DataContainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import player.HockeyPlayer;

import java.util.ArrayList;
import java.util.Arrays;


public class HockeyPlayerStatManagerTest {
    HockeyPlayerStatManager hockeyPlayerStatManager;
    DataContainer container;

    @Before
    public void setUp() throws Exception {
        HockeyPlayer player1 = new HockeyPlayer("Auston Matthews",
                "20202021", "TOR", "L", "C",
                52, 41, 25, 66, 222,
                18.5);
        HockeyPlayer player2 = new HockeyPlayer("Mikko Rantanen",
                "20202021", "COL", "L", "R",
                52, 30, 36, 66, 177,
                17.0);
        HockeyPlayer player3 = new HockeyPlayer("Ryan O'Reilly",
                "20202021", "STL", "L", "C",
                56, 24, 30, 54, 129,
                18.6);
        this.hockeyPlayerStatManager = new HockeyPlayerStatManager();
        CSVDataContainer container = new CSVDataContainer();
        container.playerMap.put("Player 1", player1);
        container.playerMap.put("Player 2", player2);
        container.playerMap.put("Player 3", player3);
        this.container = container;

    }

    @Test(timeout = 100)
    public void testExecuteTeamPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Team"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "Auston Matthews: TOR";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Hockey",
                "Mikko Rantanen", "20202021", "Team"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "Mikko Rantanen: COL";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Hockey",
                "Ryan O'Reilly", "20202021", "Team"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "Ryan O'Reilly: STL";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteTeamNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Paul Gries", "20202021", "Team"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteTeamNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20182019", "Team"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteSkaterShootsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Skater Shoots"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "Auston Matthews: L";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Hockey",
                "Mikko Rantanen", "20202021", "Skater Shoots"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "Mikko Rantanen: L";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Hockey",
                "Ryan O'Reilly", "20202021", "Skater Shoots"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "Ryan O'Reilly: L";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteSkaterShootsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Paul Gries", "20202021", "Skater Shoots"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteSkaterShootsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20182019", "Skater Shoots"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecutePositionPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Position"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "Auston Matthews: C";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Hockey",
                "Mikko Rantanen", "20202021", "Position"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "Mikko Rantanen: R";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Hockey",
                "Ryan O'Reilly", "20202021", "Position"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "Ryan O'Reilly: C";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePositionNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Paul Gries", "20202021", "Position"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePositionNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20182019", "Position"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteGamesPlayedPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Games Played"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "Auston Matthews: 52";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Hockey",
                "Mikko Rantanen", "20202021", "Games Played"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "Mikko Rantanen: 52";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Hockey",
                "Ryan O'Reilly", "20202021", "Games Played"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "Ryan O'Reilly: 56";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Paul Gries", "20202021", "Games Played"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20182019", "Games Played"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteGoalsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Goals"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "Auston Matthews: 41";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Hockey",
                "Mikko Rantanen", "20202021", "Goals"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "Mikko Rantanen: 30";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Hockey",
                "Ryan O'Reilly", "20202021", "Goals"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "Ryan O'Reilly: 24";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Paul Gries", "20202021", "Goals"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20182019", "Goals"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAssistsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Assists"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "Auston Matthews: 25";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Hockey",
                "Mikko Rantanen", "20202021", "Assists"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "Mikko Rantanen: 36";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Hockey",
                "Ryan O'Reilly", "20202021", "Assists"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "Ryan O'Reilly: 30";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Paul Gries", "20202021", "Assists"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20182019", "Assists"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecutePointsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Points"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "Auston Matthews: 66";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Hockey",
                "Mikko Rantanen", "20202021", "Points"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "Mikko Rantanen: 66";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Hockey",
                "Ryan O'Reilly", "20202021", "Points"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "Ryan O'Reilly: 54";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Paul Gries", "20202021", "Points"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20182019", "Points"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteShotsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Shots"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "Auston Matthews: 222";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Hockey",
                "Mikko Rantanen", "20202021", "Shots"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "Mikko Rantanen: 177";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Hockey",
                "Ryan O'Reilly", "20202021", "Shots"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "Ryan O'Reilly: 129";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShotsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Paul Gries", "20202021", "Shots"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 200, expected = Exception.class)
    public void testExecuteShotsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20182019", "Shots"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteShootingPercentagePasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Shooting Percentage"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "Auston Matthews: 18.5";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Hockey",
                "Mikko Rantanen", "20202021", "Shooting Percentage"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "Mikko Rantanen: 17.0";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Hockey",
                "Ryan O'Reilly", "20202021", "Shooting Percentage"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "Ryan O'Reilly: 18.6";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Paul Gries", "20202021", "Shooting Percentage"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20182019", "Shooting Percentage"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Hockey",
                "Auston Matthews", "20202021", "Age"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }
}