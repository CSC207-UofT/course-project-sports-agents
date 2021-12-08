package commands;

import driversAdapters.*;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;

public class GetListStatsTest {

    @Test
    public void testGetListStats() throws Exception {

        GetListStats getListStats = new GetListStats();
        List<String> sportNames = Arrays.asList("hockey", "baseball", "tennis");
        DataContainer dataContainer = new CSVDataContainer();
        ArrayList<String> arguments = new ArrayList<>();

        for (String sportName: sportNames) {

            switch (sportName){
                case "hockey":
                    String expectedHockey = "All available Stats For " + "hockey"+ "\n"+
                            "Team\n" + "Skater Shoots\n" + "Position\n" + "Games Played\n" +
                            "Goals\n" +"Assists\n" + "Points\n"+ "Shots\n"+ "Shooting Percentage\n";
                    arguments.add("hockey");
                    assertEquals(expectedHockey,
                            getListStats.execute(arguments, dataContainer));
                    arguments.remove("hockey");

                case "baseball":
                    arguments.add("baseball");
                    String expectedBaseball = "All available Stats For " + "baseball"+ "\n"+
                            "Team\n" + "Position\n" + "Games Played\n" + "At Bats\n" +
                            "Runs\n" +"Hits\n" + "Home Runs\n"+ "Runs Batted In\n"+ "Strike Outs\n"+
                            "Average\n";
                    assertEquals(expectedBaseball,
                            getListStats.execute(arguments, dataContainer));
                    arguments.remove("baseball");

                case "tennis":
                    arguments.add("tennis");
                    String expectedTennis = "All available Stats For " + "tennis"+ "\n"+
                            "Rank\n" + "Matches n\n" + "Aces\n" + "Double Faults\n" +
                            "Serve Points Won\n" +"Breakpoints Saved\n" + "Serve Games Won\n"+
                            "Return Games Won\n"+ " Break Points Converted\n" +
                            "Return Points Won\n";
                    assertEquals(expectedTennis,
                            getListStats.execute(arguments, dataContainer));
                    arguments.remove("tennis");
            }


        }

    }

}