package commands;

import java.util.ArrayList;
import java.util.List;

public interface Command {

    public String execute(ArrayList<String> arguments) throws Exception;

}