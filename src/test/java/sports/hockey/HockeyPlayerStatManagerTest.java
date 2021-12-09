package sports.hockey;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;


public class HockeyPlayerStatManagerTest {
    HockeyPlayerStatManager hockeyPlayerStatManager;
    DataContainer container;

    @Before
    public void setUp() throws Exception {
        HockeyPlayer player1 = new HockeyPlayer("Player 1",
                "2020-2021", "TOR", "L", "C",
                52, 41, 25, 66, 222,
                18.5);
        HockeyPlayer player2 = new HockeyPlayer("Player 2",
                "2020-2021", "COL", "L", "R",
                52, 30, 36, 66, 177,
                17.0);
        HockeyPlayer player3 = new HockeyPlayer("Player 3",
                "2020-2021", "STL", "L", "C",
                56, 24, 30, 54, 129,
                18.6);
        this.hockeyPlayerStatManager = new HockeyPlayerStatManager();
        CSVDataContainer container = new CSVDataContainer();
        container.playerMap.put("player 1", player1);
        container.playerMap.put("player 2", player2);
        container.playerMap.put("player 3", player3);
        this.container = container;

    }

    @Test(timeout = 100)
    public void testExecuteTeamPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "team"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(140, 143);
        String expected1 = "TOR";
        assertEquals(expected1, outputSub1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "team"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String outputSub2 = output2.substring(140, 143);
        String expected2 = "COL";
        assertEquals(expected2, outputSub2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "team"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String outputSub3 = output3.substring(140, 143);
        String expected3 = "STL";
        assertEquals(expected3, outputSub3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteTeamNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "team"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteTeamNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "team"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteSkaterShootsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "skater shoots"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(142, 143);
        String expected1 = "L";
        assertEquals(expected1, outputSub1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "skater shoots"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String outputSub2 = output2.substring(142, 143);
        String expected2 = "L";
        assertEquals(expected2, outputSub2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "skater shoots"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String outputSub3 = output3.substring(142, 143);
        String expected3 = "L";
        assertEquals(expected3, outputSub3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteSkaterShootsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "skater shoots"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteSkaterShootsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "skater shoots"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecutePositionPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "position"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String outputsub1 = output1.substring(142, 143);
        String expected1 = "C";
        assertEquals(expected1, outputsub1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "position"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String outputChar2 = output2.substring(142, 143);
        String expected2 = "R";
        assertEquals(expected2, outputChar2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "position"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String outputChar3 = output3.substring(142, 143);
        String expected3 = "C";
        assertEquals(expected3, outputChar3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePositionNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "position"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePositionNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "position"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteGamesPlayedPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "games played"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(141, 143);
        String expected1 = "52";
        assertEquals(expected1, outputSub1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "games played"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String outputSub2 = output2.substring(141, 143);
        String expected2 = "52";
        assertEquals(expected2, outputSub2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "games played"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String outputSub3 = output3.substring(141, 143);
        String expected3 = "56";
        assertEquals(expected3, outputSub3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "games played"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "games played"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteGoalsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "goals"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(141, 143);
        String expected1 = "41";
        assertEquals(expected1, outputSub1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "goals"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String outputSub2 = output2.substring(141, 143);
        String expected2 = "30";
        assertEquals(expected2, outputSub2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "goals"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String outputSub3 = output3.substring(141, 143);
        String expected3 = "24";
        assertEquals(expected3, outputSub3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "goals"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "goals"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAssistsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "assists"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(141, 143);
        String expected1 = "25";
        assertEquals(expected1, outputSub1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "assists"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String outputSub2 = output2.substring(141, 143);
        String expected2 = "36";
        assertEquals(expected2, outputSub2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "assists"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String outputSub3 = output3.substring(141, 143);
        String expected3 = "30";
        assertEquals(expected3, outputSub3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "assists"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "assists"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecutePointsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "points"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(141, 143);
        String expected1 = "66";
        assertEquals(expected1, outputSub1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "points"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String outputSub2 = output2.substring(141, 143);
        String expected2 = "66";
        assertEquals(expected2, outputSub2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "points"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String outputSub3 = output3.substring(141, 143);
        String expected3 = "54";
        assertEquals(expected3, outputSub3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "points"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "points"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteShotsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "shots"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(140, 143);
        String expected1 = "222";
        assertEquals(expected1, outputSub1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "shots"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String outputSub2 = output2.substring(140, 143);
        String expected2 = "177";
        assertEquals(expected2, outputSub2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "shots"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String outputSub3 = output3.substring(140, 143);
        String expected3 = "129";
        assertEquals(expected3, outputSub3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShotsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "shots"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 200, expected = Exception.class)
    public void testExecuteShotsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "shots"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteShootingPercentagePasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "shooting percentage"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(139, 143);
        String expected1 = "18.5";
        assertEquals(expected1, outputSub1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "shooting percentage"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String outputSub2 = output2.substring(139, 143);
        String expected2 = "17.0";
        assertEquals(expected2, outputSub2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "shooting percentage"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String outputSub3 = output3.substring(139, 143);
        String expected3 = "18.6";
        assertEquals(expected3, outputSub3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "shooting percentage"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "shooting percentage"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "age"));
        this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteWithPlayersInCsvFile() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "zdeno chara", "2020-2021", "games played"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        assertTrue(output1.contains("Zdeno Chara"));
        assertTrue(output1.contains("55"));

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "corey perry", "2020-2021", "skater shoots"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        assertTrue(output2.contains("Corey Perry"));
        assertTrue(output2.contains("R"));
    }
}