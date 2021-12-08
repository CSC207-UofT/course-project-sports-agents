# Demonstration

This file is a demonstration of our program's key features.

## Loading In

When you start the program, run the command `get_available_commands`
to get an idea of what commands our program supports.

To see what sports the program supports, run the command `get_sports`.

Let's focus on Tennis. To see what stats are available for Tennis,
run the command `get_stats --sport tennis`. 

Side note on commands: All commands ignore case. A phrase is a single
word or series of words separated by spaces and surrounded by double 
quotation marks `""`. Placing a single word in double quotations has
no effect, but removing the quotations from a multi-word phrase will 
make the program view it as two or more phrases. The flags `--flag`
can be given in any order, so `get_players_list --sport hockey 
--season 2020-2021` is considered the same as `get_players_list 
--season 2020-2021 --sport hockey`. The flags can be omitted, though
this will assume that the phrases are provided in the default order
given by `get_available_commands`.

Find some tennis players from the season 2016 using the command
`get_players_list --sport tennis --season 2016`.

Available Tennis seasons are: `2016` and `2017`.

Available Hockey seasons are: `2016-2017`, `2017-2018`, `2018-2019`,
`2019-2020`, and `2020-2021`.

Available Baseball seasons are: `2016-2017`, `2017-2018`, `2018-2019`,
`2019-2020`, and `2020-2021`.

In the future, we would the ability to check available seasons as 
a command.

Pick some tennis players form the list, here the first one 
`Ashleigh Barty`, `Karolina Pliskova` from the middle, and the 
last one `Ioana Minca`. 

Side Note: The first two players have data for all given seasons, but 
some players (including Ioana Minca) do not have data for all seasons. If the latter is the case,
commands concerning their data for seasons they were not in will warn
that an invalid season was provided.

## Generating Player Statistics

To find the number of aces by Ashleigh Barty in 2016, run the 
command 
`get_player_stat --sport tennis --player-name "Ashleigh Barty" --season 2016 --stat Aces`. 
This will give the statistic, formatted
in test as a table. You can check other statistics for other players
and other seasons with this command.

To compare the frequency of serve games won for the three players, run the command
`compare_player_stat --sport tennis --player-names "Ashleigh Barty" "Karolina Pliskova" "Ioana Minca" --season 2016 --stat "Serve Games Won"`.

To predict the frequency of Return Points Won for Ioana Minca in her next season, 
run the command 
`predict_player_stat --sport tennis --player-name "Karolina Pliskova" --stat "Return Points Won"`.

Try the program out by running similar commands with other sports, other
players, and other statistics!

## Generating Team Statistics

Due to time constraints and the departure of a group member, 
only Hockey Teams are implemented and there is no help feature to
view all teams or team statistics. 

For Hockey, team statistics are: `Games Played`, `Games Won`, `Games Lost`,
`Overtime Losses`, `Points`, `Goals For`, `Goals Against`, `Shots For per Game`,
`Shots Against per Game`, and `Faceoff Win Percentage`.

For Hockey, some teams include: `Tampa Bay Lightning`, `Washington Capitals`,
`Nashville Predators`.

For Hockey, the seasons are: `2016-2017`, `2017-2018`, `2018-2019`,
`2019-2020`, `2020-2021`, and `2021-2022`.

As an example to view the number of points scored by Tampa Bay Lightning
in 2020-2021, run the command 
`get_team_stat --sport hockey --team-name "Tampa Bay Lightning" --season 2020-2021 --stat Points`.

## Fantasy League

Let's say Paul Gries and Steve Engles have started a fantasy sports 
league. 

Begin by adding them to the league with the commands 
`add_member --member-name "Paul Gries"` and 
`add_member --member-name "Steve Engles"`.

The Big Game is coming up between the Orange Team and the Pink Team. Record
that it is happening with the command 
`create_match --match-name "The Big Game" --team-1-name "Team Orange" --team-2-name "Team Pink"`.

Paul thinks the Pink Team will win, so he bets on that outcome with the command
`bet --member-name "Paul Gries" --match-name "The Big Game" --winner-name "Team Pink"`.
Steve begs to differ, and bets the other way with the command
`bet --member-name "Steve Engles" --match-name "The Big Game" --winner-name "Team Orange"`.

After a very close game, the Pink Team won. Resolve the match's outcome and award correct
and incorrect bets with the command 
`resolve_match --match-name "The Big Game" --winner-name "Team Pink"`.

Check that Paul has 1 correct bet and Steve has 1 incorrect bet with the commands
`member_info --member-name "Paul Gries"` and 
`member_info --member-name "Steve Engles"`.

Save the fantasy league for later use with the command
`save --path demoLeague`. Load the league from this file with
the command `load --path demoLeague`.