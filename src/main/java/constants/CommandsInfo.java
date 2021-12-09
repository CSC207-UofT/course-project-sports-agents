package constants;

import java.util.Arrays;
import java.util.List;

/**
 * A class to store information about available commands.
 * Used when parsing input.
 */
public class CommandsInfo {
    // TODO: All Command Info classes have the same instance static final variables.
    // Inheritance and interfaces do not play nice with static final variables,
    // but making inheritance between them might be a good idea.

    public static class GetPlayerStatInfo {
        public static final String keyword = "get_player_stat";
        public static final List<String> argNames =
                Arrays.asList("--sport", "--player-name", "--season", "--stat");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "get a given statistic for a given player";
        public static final String usage =
                "get_player_stat --sport [sport] --player-name [player name] --season [season] --stat [stat]";
    }

    public static class ComparePlayerStatInfo {
        public static final String keyword = "compare_player_stat";
        public static final List<String> argNames =
                Arrays.asList("--sport", "--player-names", "--season", "--stat");
        public static final List<String> multiArgNames = List.of("--player-names");
        public static final String description =
                "compare two or more players based on a statistic";
        public static final String usage =
                "compare_player_stat --sport [sport] --player-names [player 1] [player 2] ... --season [season] --stat [stat]";
    }

    public static class PredictPlayerStatInfo {
        public static final String keyword = "predict_player_stat";
        public static final List<String> argNames =
                Arrays.asList("--sport", "--player-name", "--stat");
        public static final List<String> multiArgNames = List.of("--seasons");
        public static final String description =
                "predict a player's performance based on past performance";
        public static final String usage =
                "predict_player_stat --sport [sport] --player-name [player name] --seasons [season 1] [season 2] ... --stat [stat]";
    }

    // The commands handled by the FantasyLeagueManager
    public static final List<String> manageLeagueKeywords =
            Arrays.asList("add_member", "create_match", "bet", "resolve_match",
                    "member_info", "save", "load");

    public static class AddMemberInfo {
        public static final String keyword = "add_member";
        public static final List<String> argNames =
                List.of("--member-name");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "add a member to your fantasy league";
        public static final String usage =
                "add_member --member-name [member name]";
    }

    public static class CreateMatchInfo {
        public static final String keyword = "create_match";
        public static final List<String> argNames =
                Arrays.asList("--match-name", "--team-1-name", "--team-2-name");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "create a match in your fantasy league";
        public static final String usage =
                "create_match --match-name [match name] --team-1-name [team 1 name] --team-2-name [team 2 name]";
    }

    public static class BetInfo {
        public static final String keyword = "bet";
        public static final List<String> argNames =
                Arrays.asList("--member-name", "--match-name", "--winner-name");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "bet on the outcome of a given match on behalf of a member";
        public static final String usage =
                "bet --member-name [member name] --match-name [match name] --winner-name [winning team name]";
    }

    public static class ResolveMatchInfo {
        public static final String keyword = "resolve_match";
        public static final List<String> argNames =
                Arrays.asList("--match-name", "--winner-name");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "resolve a match based on the real-life outcome";
        public static final String usage =
                "resolve_match --match-name [match name] --winner-name [winning team name]";
    }

    public static class MemberInfoInfo {
        public static final String keyword = "member_info";
        public static final List<String> argNames =
                List.of("--member-name");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "get information about a member in your fantasy league";
        public static final String usage =
                "member_info --member-name [member name]";
    }

    public static class SaveInfo {
        public static final String keyword = "save";
        public static final List<String> argNames =
                List.of("--path");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "save your fantasy league for later use";
        public static final String usage =
                "save --path [file to save to]";
    }

    public static class LoadInfo {
        public static final String keyword = "load";
        public static final List<String> argNames =
                List.of("--path");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "load the previous iteration of your fantasy league";
        public static final String usage =
                "load --path [file to load from]";
    }

    public static class GetListPlayersInfo {
        public static final String keyword = "get_players_list";
        public static final List<String> argNames = List.of("--sport", "--season");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "get a list of available players for a sport and a season";
        public static final String usage =
                "get_players_list --sport [sport] --season [season]";
    }

    public static class GetListSportsInfo {
        public static final String keyword = "get_sports";
        public static final List<String> argNames = List.of();
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "get a list of all of the sports available";
        public static final String usage =
                "get_sports";
    }

    public static class GetListStatsInfo {
        public static final String keyword = "get_stats";
        public static final List<String> argNames = List.of("--sport");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "get a list of all of the stats available for a sport";
        public static final String usage =
                "get_stats --sport [sport]";
    }

    public static class SearchInfo {
        public static final String keyword = "search";
        public static final List<String> argNames = List.of("--player");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "search for a player with a similar name in the data";
        public static final String usage =
                "search --player [incomplete player name]";
    }

    public static class AvailableCommandsInfo {
        public static final String keyword = "get_available_commands";
        public static final List<String> argNames = List.of();
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "get a list of all available commands";
        public static final String usage =
                "get_available_commands";
    }

    public static class GetTeamStatInfo {
        public static final String keyword = "get_team_stat";
        public static final List<String> argNames =
                List.of("--sport", "--team-name", "--season", "--stat");
        public static final List<String> multiArgNames = List.of();
        public static final String description =
                "get a given statistic for a given team";
        public static final String usage =
                "get_team_stat --sport [sport] --team-name [team name] --season [season] --stat [stat]";
    }


}
