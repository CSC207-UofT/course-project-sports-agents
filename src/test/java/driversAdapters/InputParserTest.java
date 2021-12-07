package driversAdapters;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

public class InputParserTest {

    @Test
    public void testParseGetPlayerStat() {
        String shortInput = "get_player_stat hockey \"auston matthews\" " +
                            "2020-2021 \"games played\"";
        String verboseInput = "get_player_stat --sport hockey " +
                              "--player-name \"auston matthews\" " +
                              "--season 2020-2021 " +
                              "--stat \"games played\"";
        String verboseInputReordered = "get_player_stat --stat \"games played\" " +
                               "--season 2020-2021 " +
                               "--player-name \"auston matthews\" " +
                               "--sport hockey";
        String keyword = "get_player_stat";
        List<String> arguments = Arrays.asList("hockey", "auston matthews",
                "2020-2021", "games played");

        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());

        InputParser verboseParserReordered = new InputParser(verboseInputReordered);
        assertEquals(keyword, verboseParserReordered.getKeyword());
        assertEquals(arguments, verboseParserReordered.getArguments());
    }

    @Test
    public void testParseComparePlayerStat() {
        String shortInput = "compare_player_stat hockey " +
                            "\"auston matthews\" \"brad marchand\" " +
                            "2020-2021 \"games played\"";
        String verboseInput = "compare_player_stat --sport hockey " +
                              "--player-names \"auston matthews\" \"brad marchand\" " +
                              "--season 2020-2021 " +
                              "--stat \"games played\"";
        String verboseInputReordered = "compare_player_stat --stat \"games played\" " +
                               "--season 2020-2021 " +
                               "--player-names \"auston matthews\" \"brad marchand\" " +
                               "--sport hockey";
        String verboseInputMultiName = "compare_player_stat --sport hockey " +
                                       "--player-names \"auston matthews\" \"brad marchand\" " +
                                       "\"paul gries\"" +
                                       "--season 2020-2021 " +
                                       "--stat \"games played\"";
        String keyword = "compare_player_stat";
        List<String> arguments = Arrays.asList("hockey", "auston matthews",
                "brad marchand", "2020-2021", "games played");
        List<String> argumentsMultiName = Arrays.asList("hockey", "auston matthews",
                "brad marchand", "paul gries", "2020-2021", "games played");

        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());

        InputParser verboseParserReordered = new InputParser(verboseInputReordered);
        assertEquals(keyword, verboseParserReordered.getKeyword());
        assertEquals(arguments, verboseParserReordered.getArguments());

        InputParser verboseParserMultiName = new InputParser(verboseInputMultiName);
        assertEquals(keyword, verboseParserMultiName.getKeyword());
        assertEquals(argumentsMultiName, verboseParserMultiName.getArguments());
    }

    @Test
    public void testParsePredictPlayerStat() {
        String shortInput = "predict_player_stat hockey " +
                            "\"auston matthews\" " +
                            "\"games played\"";
        String verboseInput = "predict_player_stat --sport hockey " +
                              "--player-name \"auston matthews\" " +
                              "--stat \"games played\"";
        String verboseInputReordered = "predict_player_stat --stat \"games played\" " +
                                       "--player-name \"auston matthews\" " +
                                       "--sport hockey";
        String keyword = "predict_player_stat";
        List<String> arguments = Arrays.asList("hockey", "auston matthews", "games played");


        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());

        InputParser verboseParserReordered = new InputParser(verboseInputReordered);
        assertEquals(keyword, verboseParserReordered.getKeyword());
        assertEquals(arguments, verboseParserReordered.getArguments());
    }

    @Test
    public void testParseAddMember() {
        String shortInput = "add_member \"paul gries\"";
        String verboseInput = "add_member --member-name \"paul gries\"";
        String keyword = "add_member";
        List<String> arguments = Arrays.asList("add_member", "paul gries");

        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());
    }

    @Test
    public void testParseCreateMatch() {
        String shortInput = "create_match \"super bowl\" \"red team\" \"blue team\"";
        String verboseInput = "create_match --match-name \"super bowl\" " +
                              "--team-1-name \"red team\" " +
                              "--team-2-name \"blue team\"";
        String verboseInputReordered = "create_match --team-2-name \"blue team\" " +
                                       "--team-1-name \"red team\" " +
                                       "--match-name \"super bowl\"";
        String keyword = "create_match";
        List<String> arguments = Arrays.asList("create_match", "super bowl", "red team",
                "blue team");

        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());

        InputParser verboseParserReordered = new InputParser(verboseInputReordered);
        assertEquals(keyword, verboseParserReordered.getKeyword());
        assertEquals(arguments, verboseParserReordered.getArguments());
    }

    @Test
    public void testParseBet() {
        String shortInput = "bet \"paul gries\" \"super bowl\" \"red team\"";
        String verboseInput = "bet --member-name \"paul gries\" " +
                              "--match-name \"super bowl\" " +
                              "--winner-name \"red team\"";
        String verboseInputReordered = "bet --winner-name \"red team\" " +
                                       "--match-name \"super bowl\" " +
                                       "--member-name \"paul gries\"";
        String keyword = "bet";
        List<String> arguments = Arrays.asList("bet", "paul gries", "super bowl",
                "red team");

        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());

        InputParser verboseParserReordered = new InputParser(verboseInputReordered);
        assertEquals(keyword, verboseParserReordered.getKeyword());
        assertEquals(arguments, verboseParserReordered.getArguments());
    }

    @Test
    public void testParseResolveMatch() {
        String shortInput = "resolve_match \"super bowl\" \"red team\"";
        String verboseInput = "resolve_match --match-name \"super bowl\" " +
                              "--winner-name \"red team\"";
        String verboseInputReordered = "resolve_match --match-name \"super bowl\" " +
                                       "--winner-name \"red team\"";
        String keyword = "resolve_match";
        List<String> arguments = Arrays.asList("resolve_match", "super bowl", "red team");

        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());

        InputParser verboseParserReordered = new InputParser(verboseInputReordered);
        assertEquals(keyword, verboseParserReordered.getKeyword());
        assertEquals(arguments, verboseParserReordered.getArguments());
    }

    @Test
    public void testParseMemberInfo() {
        String shortInput = "member_info \"paul gries\"";
        String verboseInput = "member_info \"paul gries\"";
        String keyword = "member_info";
        List<String> arguments = Arrays.asList("member_info", "paul gries");

        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());
    }

    @Test
    public void testParseSave() {
        String shortInput = "save dir1/dir2/file";
        String verboseInput = "save --path dir1/dir2/file";
        String keyword = "save";
        List<String> arguments = List.of("save", "dir1/dir2/file");

        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());
    }

    @Test
    public void testParseLoad() {
        String shortInput = "load dir1/dir2/file";
        String verboseInput = "load --path dir1/dir2/file";
        String keyword = "load";
        List<String> arguments = List.of("load", "dir1/dir2/file");

        InputParser shortParser = new InputParser(shortInput);
        assertEquals(keyword, shortParser.getKeyword());
        assertEquals(arguments, shortParser.getArguments());

        InputParser verboseParser = new InputParser(verboseInput);
        assertEquals(keyword, verboseParser.getKeyword());
        assertEquals(arguments, verboseParser.getArguments());
    }

    @Test
    public void testParsePoorlyFormattedVerbose() {
        String goodVerboseInput = "get_player_stat --sport \"hockey\"" +
                                       "--player-name \"auston matthews\" " +
                                       "--season 2020-2021 " +
                                       "--stat \"games played\"";
        String noSpaceVerboseInput = "get_player_stat --sport\"hockey\"" +
                                     "--player-name\"auston matthews\"" +
                                     "--season\"2020-2021\"" +
                                     "--stat\"games played\"";
        String keyword = "get_player_stat";
        List<String> arguments = Arrays.asList("hockey", "auston matthews",
                "2020-2021", "games played");

        InputParser goodVerboseParser = new InputParser(goodVerboseInput);
        assertEquals(keyword, goodVerboseParser.getKeyword());
        assertEquals(arguments, goodVerboseParser.getArguments());

        InputParser noSpaceVerboseParser = new InputParser(noSpaceVerboseInput);
        assertEquals(keyword, noSpaceVerboseParser.getKeyword());
        assertEquals(arguments, noSpaceVerboseParser.getArguments());
    }

    @Test
    public void testParseAllQuotes() {
        String verboseInput = "get_player_stat --sport \"hockey\"" +
                              "--player-name \"auston matthews\" " +
                              "--season 2020-2021 " +
                              "--stat \"games played\"";
        String allQuotesVerboseInput = "\"get_player_stat\" \"--sport\"\"hockey\"" +
                                       "\"--player-name\"\"auston matthews\"" +
                                       "\"--season\"\"2020-2021\"" +
                                       "\"--stat\"\"games played\"";
        String keyword = "get_player_stat";
        List<String> arguments = Arrays.asList("hockey", "auston matthews",
                "2020-2021", "games played");

        InputParser goodVerboseParser = new InputParser(verboseInput);
        assertEquals(keyword, goodVerboseParser.getKeyword());
        assertEquals(arguments, goodVerboseParser.getArguments());

        InputParser noSpaceVerboseParser = new InputParser(allQuotesVerboseInput);
        assertEquals(keyword, noSpaceVerboseParser.getKeyword());
        assertEquals(arguments, noSpaceVerboseParser.getArguments());
    }
}