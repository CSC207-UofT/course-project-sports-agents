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
    public void testExecuteCountryPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis", "Barbora Krejcikova",
                "2016", "country"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        assertTrue((output1.contains("Barbora Krejcikova") && output1.contains("CZE")));

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis", "Sara Sorribes Tormo", "2016",
                "country"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        assertTrue((output2.contains("Sara Sorribes Tormo") && output2.contains("ESP")));

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis", "Sofia Kenin", "2016", "country"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        assertTrue((output3.contains("Sofia Kenin") && output3.contains("USA")));
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteCountryNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "country"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteCountryNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "2040", "country"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteRankPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "2017", "rank"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        assertTrue((output1.contains("Ashleigh Barty") && output1.contains("1")));


        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Naomi Osaka", "2016", "rank"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        assertTrue((output2.contains("Naomi Osaka") && output2.contains("13")));

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis",
                "Belinda Bencic", "2016", "rank"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        assertTrue((output3.contains("Belinda Bencic") && output3.contains("23")));
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2017", "rank"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "2030", "rank"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteMatchesPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis", "Shelby Rogers", "2017", "matches"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        assertTrue((output1.contains("Shelby Rogers") && output1.contains("42")));

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis", "Anett Kontaveit", "2016", "matches"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        assertTrue((output2.contains("Anett Kontaveit") && output2.contains("29")));

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("tennis", "Naomi Osaka", "2016", "matches"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        assertTrue((output3.contains("Naomi Osaka") && output3.contains("33")));
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteMatchesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2017", "matches"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteMatchesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "2030", "matches"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAcesPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Shelby Rogers", "2017", "aces"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        assertTrue((output1.contains("Shelby Rogers") && output1.contains("145")));

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Anett Kontaveit", "2016", "aces"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        assertTrue((output2.contains("Anett Kontaveit") && output2.contains("124")));

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis",
                "Angelique Kerber", "2016", "aces"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        assertTrue((output3.contains("Angelique Kerber") && output3.contains("104")));
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "aces"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Danielle Collins", "2030", "aces"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Barbora Krejcikova", "2016", "double faults"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        assertTrue((output1.contains("Barbora Krejcikova") && output1.contains("30")));

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Elise Mertens", "2016", "double faults"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        assertTrue((output2.contains("Elise Mertens") && output2.contains("28")));

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis",
                "Victoria Azarenka", "2017", "double faults"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        assertTrue((output3.contains("Victoria Azarenka") && output3.contains("28")));
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "double faults"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Danielle Collins", "1990", "double faults"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServePointsWonPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "2017", "serve points won"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        assertTrue((output1.contains("Jasmine Paolini") && output1.contains("0.415")));

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Petra Kvitova", "2017", "serve points won"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        assertTrue((output2.contains("Petra Kvitova") && output2.contains("0.623")));

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis",
                "Danielle Collins", "2016", "serve points won"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        assertTrue((output3.contains("Danielle Collins") && output3.contains("0.34")));
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServePointsWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "serve points won"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServePointsWonNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Danielle Collins", "1990", "serve points won"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPointsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Barbora Krejcikova", "2016", "break points saved"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                "      Name   break points saved \n" +
                "-------------------------------------------\n" +
                "Barbora Krejcikova       0.56 \n" +
                "-------------------------------------------";
        assertEquals(expected1, output1);
        assertTrue((output1.contains("Barbora Krejcikova") && output1.contains("0.56")));

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Paula Badosa", "2016", "break points saved"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        assertTrue((output2.contains("Paula Badosa") && output2.contains("0.56")));
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "break points saved"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paula Badosa", "2030", "break points saved"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServeGamesWonPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis", "Barbora Krejcikova",
                "2016", "serve games won"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        assertTrue((output1.contains("Barbora Krejcikova") && output1.contains("0.61")));

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("tennis", "Victoria Azarenka", "2017", "" +
                "serve games won"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        assertTrue((output2.contains("Victoria Azarenka") && output2.contains("0.672")));

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("tennis", "Ashleigh Barty", "2016",
                "serve games won"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        assertTrue((output3.contains("Ashleigh Barty") && output3.contains("0.85")));

    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "20192020", "goals"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }
}