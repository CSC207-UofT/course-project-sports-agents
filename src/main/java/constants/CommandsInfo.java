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
    }

    public static class ComparePlayerStatInfo {
        public static final String keyword = "compare_player_stat";
        public static final List<String> argNames =
                Arrays.asList("--sport", "--player-names", "--season", "--stat");
        public static final List<String> multiArgNames = List.of("--player-names");
    }

    public static class PredictPlayerStatInfo {
        public static final String keyword = "predict_player_stat";
        public static final List<String> argNames =
                Arrays.asList("--sport", "--player-name", "--seasons", "--stat");
        public static final List<String> multiArgNames = List.of("--seasons");
    }

    public static List<String> manageLeagueKeywords =
            Arrays.asList("add_member", "create_match", "bet", "resolve_match",
                    "member_info", "save", "load");

    public static class AddMemberInfo {
        public static final String keyword = "add_member";
        public static final List<String> argNames =
                List.of("--member-name");
        public static final List<String> multiArgNames = List.of();
    }

    public static class CreateMatchInfo {
        public static final String keyword = "create_match";
        public static final List<String> argNames =
                Arrays.asList("--match-name", "--team-1-name", "--team-2-name");
        public static final List<String> multiArgNames = List.of();
    }

    public static class BetInfo {
        public static final String keyword = "bet";
        public static final List<String> argNames =
                Arrays.asList("--member-name", "--match-name", "--winner-name");
        public static final List<String> multiArgNames = List.of();
    }

    public static class ResolveMatchInfo {
        public static final String keyword = "resolve_match";
        public static final List<String> argNames =
                Arrays.asList("--match-name", "--winner-name");
        public static final List<String> multiArgNames = List.of();
    }

    public static class MemberInfoInfo {
        public static final String keyword = "member_info";
        public static final List<String> argNames =
                List.of("--member-name");
        public static final List<String> multiArgNames = List.of();
    }

    public static class SaveInfo {
        public static final String keyword = "save";
        public static final List<String> argNames =
                List.of("--path");
        public static final List<String> multiArgNames = List.of();
    }

    public static class LoadInfo {
        public static final String keyword = "load";
        public static final List<String> argNames =
                List.of("--path");
        public static final List<String> multiArgNames = List.of();
    }
}
