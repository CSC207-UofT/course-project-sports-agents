package commands;

import constants.*;
import driversAdapters.DataContainer;

import java.util.*;

public class GetListStats implements Command{
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sportName = arguments.get(1);
        switch (sportName.toLowerCase()){
            case "hockey":
                return "All available Stats For " + sportName+ "\n"+
                        "Team\n" + "Skater Shoots\n" + "Position\n" + "Games Played\n" +
                        "Goals\n" +"Assists\n" + "Points\n"+ "Shots\n"+ "Shooting Percentage\n";

            case "baseball":
                return "All available Stats For " + sportName+ "\n"+
                        "Team\n" + "Position\n" + "Games Played\n" + "At Bats\n" +
                        "Runs\n" +"Hits\n" + "Home Runs\n"+ "Runs Batted In\n"+ "Strike Outs\n"+
                        "Average\n";

            case "tennis":
                return "All available Stats For " + sportName+ "\n"+
                        "Rank\n" + "Matches n\n" + "Aces\n" + "Double Faults\n" +
                        "Serve Points Won\n" +"Breakpoints Saved\n" + "Serve Games Won\n"+
                        "Return Games Won\n"+ " Break Points Converted\n" +
                        "Return Points Won\n";
        }
        throw new Exception(Exceptions.WRONG_SPORT);

    }



}
