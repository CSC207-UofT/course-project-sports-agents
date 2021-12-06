package commands;

import driversAdapters.DataContainer;

import java.util.ArrayList;

public interface Command {

    String execute(ArrayList<String> arguments, DataContainer container) throws Exception;

}