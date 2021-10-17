##Progress Report
The report should include:
* a brief summary of your specification, CRC model, scenario walk-through, and skeleton program,
* open questions your group is struggling with,
* what has worked well so far with your design,
* and a brief summary of what each group member has been working on and plans to work on next.

#### Brief summary of our specification:
The sports app allows players to import and export statistics about 
a team and player, alongside being able to query, compare, and  
manipulate that 
data from within the app. Based on the data, the app can generate
mathematical predictions regarding the teams' and players' future 
performances. 

The user should also be able to run a fantasy league based on
the data about the loaded teams and players. They can schedule matches,
add members (their friends) to the league, 
have the members bet on the outcome of matches,
and evaluate how well each member is doing at predicting matches.

#### Brief summary of our CRC Model:
Our CRC model places most forms of data storage, the teams and players,
 as entities. Each sport has its own class of teams and players,
inheriting from an abstract Team and Player class.
Other entities collect these basic units of data so they
can be more easily searched. 

Statistics are computed by use case classes,
which generally handle a related set of functions (such as computing
statistics about team, 
comparing statistics for 2 or more players,
or processing all betting and member actions). 
Currently, each sport has its own use cases related to its statistics;
this will likely change in the future to an Abstract class for each
group of statistics with each sport extending those classes to 
calculate statistics specific to that sport.

The Framework and Drivers are relatively simple currently, with
the `SportsApp` class handling input and output then passing it to
the `CommandManager` class to be sent to the appropriate use case.


#### Brief summary of our scenario walk through
The user can query a pre-loaded Hockey dataset for a 
statistic about a player. This involves the 
`PlayerStatisticManager` use case manipulating a `PlayerList`
to search for the `Player` of interest.

Over 5 commands, the user can create an upcoming `Match`, 
add a `LeagueMember` to their fantasy league, 
record that `LeagueMember`'s bet on the `Match`,
resolve the `Match` and award correct and incorrect bets,
and view the `LeagueMember`'s new post-bet information. This involves 
the `LeagueMemberManager` manipulating `Match`s and `LeagueMember`s.

#### Brief summary of the skeleton program
Our skeleton program can currently perform the above functions.
It contains code to compute statistics for Hockey Teams,
Tennis Players, and Tennis Teams, but this has not been tested
because the current class relationships could be clarified
(likely with inheritance added).


####Open questions: 
How should we implement data retrieval for the team/player statistics? Should the data be already stored in the app, 
or retrieved from a file or retrieved online using an API?

Would it be possible for us to submit a .csv file with our program? Are there any particular restrictions about API
usage for the assignment?

How should use cases and entities for each sport be implemented? Should we use
abstract classes for both, creating a identically structured dependecy 
tree of classes for each sport?

How should we handle multiple seasons? Players can store multiple seasons
of data in multiple parameters or as items in a map, but teams
 with a different composition in each season are extremely complex to
work with.

Where do we go from here regarding the fantasy league aspect?
Should League Members be able to log in? Should we customize
the experience for each Member, for instance by letting them
select their favorite teams?


####What has worked well so far: 
We have been able to come up with a specification that has many features
of reporting statistics for different types of sports. We have identified
the correct layers of the clean architecture according the scenario walk through and
came up with a skeleton program that will be a demo of our program will
look like in the future.

Additionally, by regularly scheduling meetings and texting on Discord, we were able to track each other's progresses
and continuously work on the app to ensure our features are coherent and compatible with each other. This also made
asking questions really easy; if someone had a question/problem, they could ask it online, and someone would come
back to them and answer their question. So, collectively, our group is happy with how we have been communicating and 
planning our program. 

We have had lots of success with encapsulating code. Each person wrote their
own code and communicated with each other only about the method signatures 
and return types, but we were able to create a largely functional program with
little work in combining the parts of code together.

In terms of the code itself, we think that our class structure has been working really well, in particular the structure
of our teams and players classes. This type of implementation allows us to integrate different kinds of sports into the
app, which might have completely different statistics available. We are also happy that we were able to implement a
command interface, which allows different kind of classes with completely different purposes to be used as use cases.
It gives us a lot of flexibility and doesn't require us to write an abstract parent class, which would most-likely be
too general to be truly useful. 

####Brief summary of what each group member has been working on: 
We have all been working on the CRC cards as well as example use cases
for our application. We have been working on these together during our
meetings, as well as separately throughout the week. If someone had an
addition to make, we would make sure to first discuss this on Discord
through texting.

After our second meeting on Friday 8th October, we assigned each person
a section of a project in order to create our skeleton project.
Karim started working on the CommandManager as well as the main method.
Isaiah began working on the LeagueMember and LeagueMemberManager class to allow the main user to add
members to their list. Nazanin began implementing the PlayerStatManager,
and other player-focused stat classes, like predictor, and comparer.
Samuel started working on the commands.TeamStatManager (to allow the user to
get statistical data for teams), commands.TeamStatComparer (to allow the user
to compare statistical data for teams), commands.TeamStatPredictor, and team.team
classes. Vishali focused on working on the player.player classes,
which will store the necessary data to make statistical
manipulations possible. Finally, Jack started working on the Match class,
so that the user can make games and have the members make bets on them.
We wrote our implementations for these completely and merged them later
to find any errors and incoherency.
