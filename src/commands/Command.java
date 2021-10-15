package commands;

import java.util.ArrayList;

public interface Command {

    public String execute(ArrayList<String> arguments) throws Exception;

}