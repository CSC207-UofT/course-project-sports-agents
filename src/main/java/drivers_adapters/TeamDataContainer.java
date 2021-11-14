package drivers_adapters;

import player.*;
import team.*;

import java.util.*;

public class TeamDataContainer {
    /**
     * loadedFiles is a map from loaded sports to their data.
     */
    protected HashMap<String, TeamList> loadedFiles;

    /**
     * Load the csv file of the given sport name.
     * @param sportName is the name of the sport.
     */
    public void load(String sportName) throws Exception {
        switch (sportName) {
            case "Hockey":
                save("Hockey", new HockeyTeamList());
            case "Baseball":
                save("Baseball", new BaseballTeamList());

        }

    }

    /**
     * Save the csv file for sport to be passed right away.
     * @param sportName is the name of the sport.
     * @param loadedFile is the csv file for sport.
     */

    public void save(String sportName, TeamList loadedFile){
        loadedFiles.put(sportName, loadedFile);

    }

    /**
     * If the sport has already been loaded and saved, pass it right away. Otherwise load it and then pass it.
     * @param sportName is the name of the sport.
     * @return the data for sport.
     */

    public TeamList getData(String sportName) throws Exception {
        if (!loadedFiles.containsKey(sportName)){
            load(sportName);
        }
        return loadedFiles.get(sportName);
    }

}
