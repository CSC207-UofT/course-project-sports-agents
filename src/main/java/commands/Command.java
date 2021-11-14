package commands;

import java.util.*;

public interface Command {

    public String execute(List<String> arguments) throws Exception;

}