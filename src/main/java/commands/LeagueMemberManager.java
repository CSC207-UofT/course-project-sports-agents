package commands;

import constants.Exceptions;
import leagueMember.LeagueMember;
import match.Match;

import java.util.HashMap;
import java.util.ArrayList;

public class LeagueMemberManager implements Command {
    // MemberMap stores the League Members of the fantasy league
    public final HashMap<String, LeagueMember> LeagueMemberMap;
    // GameMap stores the ongoing Games of the fantasy league
    public final HashMap<String, Match> MatchMap;

    /**
     * Create a new MemberManager with no Members and no Games
     */
    public LeagueMemberManager() {
        this.LeagueMemberMap = new HashMap<>();
        this.MatchMap = new HashMap<>();
    }

    public String execute(ArrayList<String> arguments) throws Exception {
        switch (arguments.get(0)) {
            case "add_member":
                return addMember(arguments);
            case "create_match":
                return createMatch(arguments);
            case "bet":
                return bet(arguments);
            case "resolve_match":
                return resolveMatch(arguments);
            case "member_info":
                return memberInfo(arguments);
            default:
                throw new Exception(Exceptions.WRONG_COMMAND);
        }
    }

    /**
     * Add a new League Member to the fantasy league
     * @param arguments String Array of form {"add_member", <member name>}
     * @return a confirmation if the Member was added
     * @throws Exception if a Member with the same name already exists
     */
    private String addMember(ArrayList<String> arguments) throws Exception {
        String leagueMemberName = arguments.get(1);
        if (this.LeagueMemberMap.containsKey(leagueMemberName)) {
            throw new Exception(Exceptions.MEMBER_EXISTS);
        }
        LeagueMember addedLeagueMember = new LeagueMember(leagueMemberName);
        this.LeagueMemberMap.put(leagueMemberName, addedLeagueMember);
        return "New " + addedLeagueMember + " successfully added.";
    }

    /**
     * Create a new Match for players to bet on
     * @param arguments String Array of form {"create_match", <match name>,
     *                <team 1 name>, <team 2 name>}
     * @return a confirmation if the Match was created
     * @throws Exception if a Match with the same name already exists
     */
    private String createMatch(ArrayList<String> arguments) throws Exception {
        String matchName = arguments.get(1);
        if (this.MatchMap.containsKey(matchName)) {
            throw new Exception(Exceptions.MATCH_EXISTS);
        }
        String team1Name = arguments.get(2);
        String team2name = arguments.get(3);
        // TODO: Verify that the given teams exist

        Match createdMatch = new Match(team1Name, team2name);
        this.MatchMap.put(matchName, createdMatch);
        return "New " + createdMatch + " successfully created.";
    }

    /**
     * Record a League Member's bet on the outcome of a Match
     * @param arguments String Array of form {"bet", <member name>,
     *                <match name>, <predicted winning team>}
     * @return a confirmation if the bet is recorded
     * @throws Exception if the League Member does not exist, the Match does
     * not exist, or the team is not competing in the Match
     */
    private String bet(ArrayList<String> arguments) throws Exception {
        String leagueMemberName = arguments.get(1);
        verifyMember(leagueMemberName);
        LeagueMember bettingLeagueMember = this.LeagueMemberMap.get(leagueMemberName);

        String matchName = arguments.get(2);
        verifyMatch(matchName);
        Match targetMatch = this.MatchMap.get(matchName);

        String favoredTeamName = arguments.get(3);
        targetMatch.addBet(bettingLeagueMember, favoredTeamName);
        return leagueMemberName + " has successfully placed a bet that " +
                favoredTeamName + " will win " + matchName;
    }

    /**
     * Resolve a Match's outcome and award League Members according to their bets
     * @param arguments String Array of form {"resolve_match", <match name>,
     *                <winning team name>}
     * @return a confirmation if the Match's outcome is resolved
     * @throws Exception if the Match does not exist
     */
    private String resolveMatch(ArrayList<String> arguments) throws Exception {
        String matchName = arguments.get(1);
        verifyMatch(matchName);
        Match targetMatch = this.MatchMap.get(matchName);

        String winningTeam = arguments.get(2);
        targetMatch.resolve(winningTeam);
        this.MatchMap.remove(matchName);
        return matchName + " was successfully resolved with " +
                winningTeam + " as the victors.";
    }

    /**
     * Return information on a given League Member
     * @param arguments String array for form {"member_info", <member name>}
     * @return a string representation of the member
     * @throws Exception if the League Member does not exist
     */
    private String memberInfo(ArrayList<String> arguments) throws Exception {
        String memberName = arguments.get(1);
        verifyMember(memberName);
        LeagueMember targetLeagueMember = this.LeagueMemberMap.get(memberName);
        return targetLeagueMember.toString();
    }

    /**
     * Verify that the given League Member exists
     * @param leagueMemberName the possible League Member's name
     * @throws Exception if there is no League Member with the given name
     */
    private void verifyMember(String leagueMemberName) throws Exception {
        if (!this.LeagueMemberMap.containsKey(leagueMemberName)) {
            throw new Exception(Exceptions.NO_MEMBER);
        }
    }

    /**
     * Verify that the given Match exists
     * @param matchName the possible Match's name
     * @throws Exception if there is no Match with the given name
     */
    private void verifyMatch(String matchName) throws Exception {
        if (!this.MatchMap.containsKey(matchName)) {
            throw new Exception(Exceptions.NO_MATCH);
        }
    }
}
