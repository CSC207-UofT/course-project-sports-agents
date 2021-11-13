package helpers;

import constants.Exceptions;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerInvalidStatsChecker {

    public static final ArrayList<String> invalidStats = (ArrayList<String>) Arrays.asList("name", "season", "team", "skater shoots", "position");

    public static void checkStat(String stat) throws Exception {
        if (invalidStats.contains(stat)) {
            throw new Exception(Exceptions.INVALID_STATISTIC);
        }
    }

}
