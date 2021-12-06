package commands;

import drivers_adapters.*;

import java.util.*;

public class GetListSports implements Command{
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        return "All Available sports: \n" + "Baseball\n" +
                "Hockey\n" +
                "Tennis\n";    }
}
