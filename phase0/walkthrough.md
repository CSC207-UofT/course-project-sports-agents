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

Scenario 2: The user makes a user, makes a game, and bets on it.

As above, the first command, 
`member_manager create_match "Semifinal 1" "Red Team" "Blue Team"`, 
is passed from the
command line to `SportsApp` to 
`CommandManager` which parses it and chooses a relevant use case -
here, the `MemberManager` - and calls its `execute` method.
The `execute` method calls the private `createMatch` method to create
and store a new `Match` object in the `MemberManager`, then passes back
a conformation message up to `CommandManager` to `SportsApp` to the user.

The second command, `member_manager add_member "Paul Gries"`, is 
passed to the `MemberManager`'s `execute` method exactly as described
above. The `execute` method calls the private `addMember` method to
create and store a new `Member` object in the `MemberManager`,
then passes a conformation message to the user as described above.

The third command,
`member_manager bet "Paul Gries" "Semifinal 1" "Blue Team"`, 
is passed from the command line to the `MemberManager`'s `execute`
method. The `execute` method calls the private `bet` method to have the
`Match` for Semifinal 1 record `Member` Paul Gries bet the Blue Team will win.
The conformation message is passed back to the user.Adde
