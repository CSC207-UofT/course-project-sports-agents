package commands;

import drivers_adapters.DataContainer;

import java.util.ArrayList;

public interface Command {

    String execute(ArrayList<String> arguments, DataContainer container) throws Exception;

}