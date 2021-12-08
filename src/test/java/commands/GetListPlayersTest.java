package commands;

import driversAdapters.*;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;

public class GetListPlayersTest {

    @Test
    public void getListPlayersTest() throws Exception {
        GetListPlayers getListPlayers = new GetListPlayers();
        List<String> sportNames = Arrays.asList("hockey", "baseball", "tennis");
        DataContainer dataContainer = new CSVDataContainer();
        ArrayList<String> arguments = new ArrayList<>();

        for (String sportName: sportNames) {

            switch (sportName){
                case "hockey":
                    String expectedHockey = "All available players for the demanded sport and season:\n\n" +
                            "Zdeno Chara, Joe Thornton, Jason Spezza, Duncan Keith, Ryan Suter," +
                            " Jeff Carter, Dustin Brown, Zach Parise, Ryan Getzlaf, Brent Burns,";
                    arguments.add("hockey");
                    arguments.add("2020-2021");
                    assertEquals(expectedHockey,
                            getListPlayers.execute(arguments, dataContainer).substring(0, 191));
                    arguments.remove("hockey");
                    arguments.remove("2020-2021");

                case "baseball":
                    String expectedBaseball = "All available players for the demanded sport and season:\n\n" +
                            "Whit Merrifield, Jose Abreu, Dansby Swanson, Francisco Lindor," +
                            " Trevor Story, Cesar Hernandez, Trea Turner, Rafael Devers," +
                            " Marcell Ozuna, Manny Machado,";
                    arguments.add("baseball");
                    arguments.add("2020-2021");
                    assertEquals(expectedBaseball,
                            getListPlayers.execute(arguments, dataContainer).substring(0, 209));
                    arguments.remove("baseball");
                    arguments.remove("2020-2021");


                case "tennis":
                    String expectedTennis = "All available players for the demanded sport and season:\n\n" +
                            "Ashleigh Barty, Barbora Krejcikova, Karolina Pliskova, Garbine Mugurza," +
                            " Maria Sakkari, Ons Jabeur, Anett Kontaveit, Paula Badosa," +
                            " Anastasia Pavlyuchenkova, Sofia Kenin,";
                    arguments.add("tennis");
                    arguments.add("2016");
                    assertEquals(expectedTennis,
                            getListPlayers.execute(arguments, dataContainer).substring(0, 226));
                    arguments.remove("tennis");
                    arguments.remove("2016");

            }


        }

    }

}