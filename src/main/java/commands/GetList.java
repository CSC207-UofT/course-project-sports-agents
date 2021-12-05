package commands;


import constants.*;
import drivers_adapters.*;
import player.*;

import java.io.*;
import java.util.*;

/**
 * Return a list of available sports, valid stats for each sport, and available users for each
 * season and sport so that the user will have a background of the program.
 */
public class GetList implements Command{

    public String execute(){
        return "All Available sports: \n" + "Baseball\n" +
                "Hockey\n" +
                "Tennis\n";
    }

    public String execute(String sportName) throws Exception {
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

    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sportName = arguments.get(0);
        String season = arguments.get(1);
        List<String> listAllPlayers =  container.getAllPlayers(sportName, season);
        return formatGetListPlayers(listAllPlayers);
    }

    private String formatGetListPlayers(List<String> listAllPlayers) {
        StringBuilder output = new StringBuilder();
        output.append("All available players for the demanded sport and season:\n");
        for (int i = 0; i < listAllPlayers.size(); i++){
            if(i % 10 == 0){
                output.append("\n");
            }
            output.append(listAllPlayers.get(i));
            output.append(", ");

        }
        return output.toString();
    }


}
