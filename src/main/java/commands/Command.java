package commands;

import java.util.ArrayList;

public interface Command {

    String execute(ArrayList<String> arguments) throws Exception;

}