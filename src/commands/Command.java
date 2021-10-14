package commands;

import java.util.ArrayList;

public interface Command throws Exception{

    public String execute(ArrayList<String> arguments);

}