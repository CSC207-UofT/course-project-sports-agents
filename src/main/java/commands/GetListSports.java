package commands;


import driversAdapters.DataContainer;

import java.util.*;

public class GetListSports implements Command {

    /**
     * Return the list of sports
     *
     * @param arguments a string array of arguments. Should be empty here
     * @param container a container of sport data
     * @return the list of available sports
     * @throws Exception should not throw exception
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        return "All Available sports: \n" + "Baseball\n" +
               "Hockey\n" +
               "Tennis\n";
    }
}
