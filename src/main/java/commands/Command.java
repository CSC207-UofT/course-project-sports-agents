package commands;

import java.util.List;

public interface Command {

    public String execute(List<String> arguments) throws Exception;

}