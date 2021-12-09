package commands;

import driversAdapters.DataContainer;

import java.util.ArrayList;

/**
 * Public interface Command used by all of our commands. Implements the Command Design Pattern.
 */
public interface Command {

    String execute(ArrayList<String> arguments, DataContainer container) throws Exception;

}