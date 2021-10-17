Scenario 1: The user queries the pre-loaded statistic database
about a player's statistic in a current season.

The app, running from the `SportsApp` class, reads the user's
input of `stats_player "Auston Matthews" "games played" "20202021"`
typed at the command line. It passes this to the
`CommandManager` class's `execute` method.
The `CommandManager` class uses its `parse` method to split the
input into the 4 arguments, then finds the
relevant use case class to handle the input -
here, `PlayerStatManager`. All use case classes
implement the `Command` interface, which defines their `execute`
method which is called on the arguments. The `PlayerStatManager`'s
`execute` method creates a `PlayerList`, which on initialization
loads a dataset of Hockey Player data from a CSV file by
creating `HockeyPlayer` objects with the relevant data.
The `PlayerList` is queried for the relevant `HockeyPlayer`, which.
is then queried for the given statistic. The statistic is formatted
into a string, passed back up to `CommandManager`,
and printed to the user by `SportsApp`.

Scenario 2: The user makes a user, makes a game, bets on it, resolves 
the game, and checks that user's history.

As above, the first command,
`member_manager create_match "Semifinal 1" "Red Team" "Blue Team"`,
is passed from the
command line to `SportsApp` to
`CommandManager` which parses it and chooses a relevant use case -
here, the `MemberManager` - and calls its `execute` method.
The `execute` method calls the private `createMatch` method to create
and store a new `Match` object in the `MemberManager`, then passes back
a conformation message up to `CommandManager` to `SportsApp` to the user.

All following commands operate similarly, only with a different
private method called. For space, only the new private 
method is described and the passing of the command to 
`MemberManager`'s `execute and the passing of the response to
`CommandManager` to `SportsApp` to the user is omitted.

The second command, `member_manager add_member "Paul Gries"`, 
leads to `MemberManager` using the private `addMember` method to
create and store a new `Member` object in the `MemberManager`.

The third command, 
`member_manager bet "Paul Gries" "Semifinal 1" "Blue Team"`,
leads to `MemberManager` using the private `bet` method have the
`Match` Semifinal 1 record `Member` Paul Gries bets Blue Team will 
win.

The fourth command,
`member_manager resolve_match "Semifinal 1" "Blue Team"`,
leads to `MemberManager` using the private `resolveMatch` method to
direct the `Match` for Semifinal 1 to update all users who bet on its 
outcome. The `MemberManager` then drops that Match, as it has ended.

The fifth command,
`member_manager member_info "Paul Gries"`,
leads to `MemberManager` using the private `memberInfo` method to
access the information about `Member` Paul Gries, which is passed back
to the user who sees he made one successful bet!