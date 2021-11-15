package commands;

import drivers_adapters.DataContainer;

import java.util.ArrayList;
import java.util.List;

public interface Command {

    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception;

}