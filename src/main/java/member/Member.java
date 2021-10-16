package member;

public class Member {
    private final String name;
    private int correctBets;
    private int incorrectBets;

    /**
     * Create a new Member with no bet history
     * @param name Member's name
     */
    public Member(String name) {
        this.name = name;
        this.correctBets = 0;
        this.incorrectBets = 0;
    }

    /**
     * @return the Member's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the number of correct bets the Member has made
     */
    public int getCorrectBets() {
        return this.correctBets;
    }

    /**
     * Record one of the Member's bets was correct
     */
    public void recordCorrectBet() {
        this.correctBets+= 1;
    }

    /**
     * @return the number of incorrect bets the Member has made
     */
    public int getIncorrectBets() {
        return this.incorrectBets;
    }

    /**
     * Record one of the Member's bets was incorrect
     */
    public void recordIncorrectBet() {
        this.incorrectBets += 1;
    }

    /**
     * @return a String representation of this Member
     */
    @Override
    public String toString() {
        return "Member " + this.name + " with " + this.correctBets +
                " correct bet(s) and " + this.incorrectBets +
                " incorrect bet(s)";
    }

    /**
     * Members are assumed to have unique names. Thus, compare based on name
     * @param other another object to compare this with
     * @return true if other is a Member with identical name
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }

        Member otherMember = (Member) other;
        return this.name.equals(otherMember.name);
    }

    /**
     * Override hashcode, for use in MemberManager
     * @return the hashcode for the name
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
