package sports.tennis;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TennisPlayerStatManagerTest {
    TennisPlayerStatManager tennisPlayerStatManager;
    DataContainer container;

    @Before
    public void setUp() throws Exception {
        tennisPlayerStatManager = new TennisPlayerStatManager();
        this.container = new CSVDataContainer();
    }

    @Test(timeout = 100)
    public void testExecuteRankPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "2016", "Rank"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                "      Name                 rank \n" +
                "-------------------------------------------\n" +
                "Ashleigh Barty          1 \n" +
                "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Naomi Osaka", "2016", "Rank"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                "      Name                 rank \n" +
                "-------------------------------------------\n" +
                "Naomi Osaka         13 \n" +
                "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis",
                "Belinda Bencic", "2016", "Rank"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                "      Name                 rank \n" +
                "-------------------------------------------\n" +
                "Belinda Bencic         23 \n" +
                "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2020", "Rank"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "2020", "Rank"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAcesPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Shelby Rogers", "2017", "Aces"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                "      Name                 aces \n" +
                "-------------------------------------------\n" +
                "Shelby Rogers        145 \n" +
                "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Anett Kontaveit", "2016", "Aces"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                "      Name                 aces \n" +
                "-------------------------------------------\n" +
                "Anett Kontaveit        124 \n" +
                "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis",
                "Angelique Kerber", "2016", "Aces"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                "      Name                 aces \n" +
                "-------------------------------------------\n" +
                "Angelique Kerber        104 \n" +
                "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "Aces"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "2020", "Aces"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Barbora Krejcikova", "2016", "Double Faults"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                "      Name        double faults \n" +
                "-------------------------------------------\n" +
                "Barbora Krejcikova         30 \n" +
                "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Elise Mertens", "2016", "Double Faults"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                "      Name        double faults \n" +
                "-------------------------------------------\n" +
                "Elise Mertens         28 \n" +
                "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis",
                "Victoria Azarenka", "2017", "Double Faults"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                "      Name        double faults \n" +
                "-------------------------------------------\n" +
                "Victoria Azarenka         28 \n" +
                "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "Double Faults"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "1990", "Double Faults"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServePointsWonPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "2017", "Serve Points won"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                "      Name     serve points won \n" +
                "-------------------------------------------\n" +
                "Jasmine Paolini      0.415 \n" +
                "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Petra Kvitova", "2017", "Serve Points won"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                "      Name     serve points won \n" +
                "-------------------------------------------\n" +
                "Petra Kvitova      0.623 \n" +
                "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis",
                "Danielle Collins", "2016", "Serve Points won"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                "      Name     serve points won \n" +
                "-------------------------------------------\n" +
                "Danielle Collins       0.34 \n" +
                "-------------------------------------------";
        assertEquals(expected3, output3);
    }


    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPointsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Barbora Krejcikova", "2016", "Break Points Saved"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                "      Name   break points saved \n" +
                "-------------------------------------------\n" +
                "Barbora Krejcikova       0.56 \n" +
                "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Paula Badosa", "2016", "Break Points Saved"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                "      Name   break points saved \n" +
                "-------------------------------------------\n" +
                "Paula Badosa       0.56 \n" +
                "-------------------------------------------";
        assertEquals(expected2, output2);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "20202021", "Break Points Saved"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "20192020", "Break Points Saved"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "20192020", "Goals"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }
}