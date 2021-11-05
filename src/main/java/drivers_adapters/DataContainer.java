package drivers_adapters;

import player.*;

import java.util.*;

public class DataContainer {

    /**
     * loadedFiles is a map from loaded sports to their data.
     */
    protected HashMap<String, HashMap> loadedFiles;

    /**
     * Load the csv file of the given sport name.
     * @param sportName is the name of the sport.
     */
    public void load(String sportName) {
        if ("Hockey".equals(sportName)) {
            save("Hockey", new HockeyPlayerList().getPlayerMap());

        }else if ("Baseball".equals(sportName)){
            save("Baseball", new BaseballPlayerList().getPlayerMap());

        }else if ("Tennis".equals(sportName)){
            save("Tennis", new TennisPlayerList().getAllTennisPlayers());
        }

    }

    /**
     * Save the csv file for sport to be passed right away.
     * @param sportName is the name of the sport.
     * @param loadedFile is the csv file for sport.
     */

    public void save(String sportName, HashMap loadedFile){
        loadedFiles.put(sportName, loadedFile);

    }

    /**
     * If the sport has already been loaded and saved, pass it right away. Other wise load it and then pass it.
     * @param sportName is the name of the sport.
     * @return the data for sport.
     */

    public HashMap getData(String sportName){
        if (!loadedFiles.containsKey(sportName)){
            load(sportName);
        }
        return loadedFiles.get(sportName);
    }

}
