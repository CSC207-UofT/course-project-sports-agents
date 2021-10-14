package member;

import commands.*;
import java.util.HashMap;

public class MemberManager implements Command {
    // MemberMap stores the Members of the fantasy league
    public HashMap<String, Member> MemberMap;
    // GameMap stores the ongoing Games of the fantasy league
    public HashMap<String, Match> MatchMap;

    /**
     * Create a new MemberManager with no Members and no Games
     */
    public MemberManager() {
        this.MemberMap = new HashMap<String, Member>();
        this.MatchMap = new HashMap<String, Match>();
    }

    public String execute(String[] command) throws Exception {
        return switch (command[0]) {
            case "add_member" -> addMember(command);
            case "create_match" -> createMatch(command);
            case "bet" -> bet(command);
            case "resolve_match" -> resolveMatch(command);
            default -> throw new Exception("Invalid Command provided!");
        };
    }

    /**
     * Add a new Member to the fantasy league
     * @param command String Array of form {"add_member", <member name>}
     * @return a confirmation if the Member was added
     * @throws Exception if a Member with the same name already exists
     */
    private String addMember(String[] command) throws Exception {
        String memberName = command[1];
        if (this.MemberMap.containsKey(memberName)) {
            throw new Exception(memberName + " is already an existing Member!");
        }
        Member addedMember = new Member(memberName);
        this.MemberMap.put(memberName, addedMember);
        return "New " + addedMember + " successfully added.";
    }

    /**
     * Create a new Match for players to bet on
     * @param command String Array of form {"create_match", <match name>,
     *                <team 1 name>, <team 2 name>}
     * @return a confirmation if the Match was created
     * @throws Exception if a Match with the same name already exists
     */
    private String createMatch(String[] command) throws Exception {
        String matchName = command[1];
        if (this.MatchMap.containsKey(matchName)) {
            throw new Exception(matchName + " is already an existing Match!");
        }
        String team1Name = command[2];
        String team2name = command[3];
        // TODO: Verify that the given teams exist

        Match createdMatch = new Match(matchName, team1Name, team2name);
        this.MatchMap.put(matchName, createdMatch);
        return "New " + createdMatch + " successfully created.";
    }

    /**
     * Record a Member bet on the outcome of a Match
     * @param command String Array of form {"bet", <member name>,
     *                <match name>, <predicted winning team>}
     * @return a confirmation if the bet is recorded
     * @throws Exception if the Member does not exist, the Match does not
     * exist, or the team is not competing in the Match
     */
    private String bet(String[] command) throws Exception {
        String memberName = command[1];
        verifyMember(memberName);
        Member bettingMember = this.MemberMap.get(memberName);

        String matchName = command[2];
        verifyMatch(matchName);
        Match targetMatch = this.MatchMap.get(matchName);

        String favoredTeamName = command[3];
        targetMatch.recordBet(bettingMember, favoredTeamName);
        return memberName + " has successfully placed a bet that " +
                favoredTeamName + " will win " + matchName;
    }

    /**
     * Resolve a Match's outcome and award Members according to their bets
     * @param command String Array of form {"resolve_match", <match name>,
     *                <winning team name>}
     * @return a confirmation if the Match's outcome is resolved
     * @throws Exception if the Match does not exist
     */
    private String resolveMatch(String[] command) throws Exception {
        String matchName = command[1];
        veryifyMatch(matchName);
        Match targetMatch = this.MatchMap.get(matchName);

        String winningTeam = command[2];
        targetMatch.resolve(winningTeam);
        this.MatchMap.remove(matchName);
        return matchName + " was successfully resolved with " +
                winningTeam + " as the victors.";
    }

    /**
     * Verify that the given Member exists
     * @param memberName the possible Member's name
     * @throws Exception if there is no Member with the given name
     */
    private void verifyMember(String memberName) throws Exception {
        if (!this.MemberMap.containsKey(memberName)) {
            throw new Exception(memberName + " is not an existing Member!");
        }
    }

    /**
     * Verify that the given Match exists
     * @param matchName the possible Match's name
     * @throws Exception if there is no Match with the given name
     */
    private void verifyMatch(String matchName) throws Exception {
        if (!this.MatchMap.containsKey(matchName)) {
            throw new Exception(matchName + " is not an existing Match!");
        }
    }
}
