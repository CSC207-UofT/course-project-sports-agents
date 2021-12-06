package commands;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
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
        String expected1 = "-------------------------------------------\n" +
                           "      Name                 Team \n" +
                           "-------------------------------------------\n" +
                           "  Player 1        TOR \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "team"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name                 Team \n" +
                           "-------------------------------------------\n" +
                           "  Player 2        COL \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "team"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name                 Team \n" +
                           "-------------------------------------------\n" +
                           "  Player 3        STL \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteTeamNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "team"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteTeamNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "team"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteSkaterShootsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "skater shoots"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name        Skater Shoots \n" +
                           "-------------------------------------------\n" +
                           "  Player 1          L \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "skater shoots"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name        Skater Shoots \n" +
                           "-------------------------------------------\n" +
                           "  Player 2          L \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "skater shoots"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name        Skater Shoots \n" +
                           "-------------------------------------------\n" +
                           "  Player 3          L \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteSkaterShootsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "skater shoots"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteSkaterShootsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "skater shoots"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecutePositionPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "position"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name             Position \n" +
                           "-------------------------------------------\n" +
                           "  Player 1          C \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "position"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name             Position \n" +
                           "-------------------------------------------\n" +
                           "  Player 2          R \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "position"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name             Position \n" +
                           "-------------------------------------------\n" +
                           "  Player 3          C \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePositionNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "position"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePositionNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "position"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteGamesPlayedPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "games played"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name         Games Played \n" +
                           "-------------------------------------------\n" +
                           "  Player 1         52 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "games played"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name         Games Played \n" +
                           "-------------------------------------------\n" +
                           "  Player 2         52 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "games played"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name         Games Played \n" +
                           "-------------------------------------------\n" +
                           "  Player 3         56 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "games played"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "games played"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteGoalsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "goals"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name                Goals \n" +
                           "-------------------------------------------\n" +
                           "  Player 1         41 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "goals"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name                Goals \n" +
                           "-------------------------------------------\n" +
                           "  Player 2         30 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "goals"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name                Goals \n" +
                           "-------------------------------------------\n" +
                           "  Player 3         24 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "goals"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "goals"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAssistsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "assists"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name              Assists \n" +
                           "-------------------------------------------\n" +
                           "  Player 1         25 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "assists"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name              Assists \n" +
                           "-------------------------------------------\n" +
                           "  Player 2         36 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "assists"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name              Assists \n" +
                           "-------------------------------------------\n" +
                           "  Player 3         30 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "assists"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "assists"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecutePointsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "points"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name               Points \n" +
                           "-------------------------------------------\n" +
                           "  Player 1         66 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "points"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name               Points \n" +
                           "-------------------------------------------\n" +
                           "  Player 2         66 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "points"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name               Points \n" +
                           "-------------------------------------------\n" +
                           "  Player 3         54 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "points"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "points"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteShotsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "shots"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name                Shots \n" +
                           "-------------------------------------------\n" +
                           "  Player 1        222 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "shots"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name                Shots \n" +
                           "-------------------------------------------\n" +
                           "  Player 2        177 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "shots"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name                Shots \n" +
                           "-------------------------------------------\n" +
                           "  Player 3        129 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShotsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "shots"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 200, expected = Exception.class)
    public void testExecuteShotsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "shots"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteShootingPercentagePasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "shooting percentage"));
        String output1 = this.hockeyPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name  Shooting Percentage \n" +
                           "-------------------------------------------\n" +
                           "  Player 1       18.5 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("hockey",
                "player 2", "2020-2021", "shooting percentage"));
        String output2 = this.hockeyPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name  Shooting Percentage \n" +
                           "-------------------------------------------\n" +
                           "  Player 2       17.0 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("hockey",
                "player 3", "2020-2021", "shooting percentage"));
        String output3 = this.hockeyPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name  Shooting Percentage \n" +
                           "-------------------------------------------\n" +
                           "  Player 3       18.6 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "paul gries", "2020-2021", "shooting percentage"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2018-2019", "shooting percentage"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey",
                "player 1", "2020-2021", "age"));
        String fail = this.hockeyPlayerStatManager.execute(arguments, container);
    }
}