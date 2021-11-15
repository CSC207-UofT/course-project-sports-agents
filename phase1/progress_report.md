# Progress Report

## Open questions your group is struggling with
- Should teams store player names for every season? How should we deal with
players that switch teams between seasons? Should those players be stored in
both teams for that season?
- What other use cases should we consider for the fantasy league aspect of our app?
- Are there any other ways we can predict the future performance of a player or a team?
What regression models would you recommend?
- The design of each sport having a separate StatManager, StatComparer, and Stat
Predictor ensures we follow the single responsibility principle and can change
the behavior or one command but not the others. However, it also creates a shotgun
surgery problem, as adding a new statistic to a sport requires changing the
sport's Player, StatManager, StatComparer, and StatPredictor classes. What is the
best way to resolve this?
- We currently assume the CSV data files are present, and throw Exceptions otherwise.
Should we allow users to specify the name of the data file being used?


## What has worked well so far with your design
We were able to expand our program to another sport, baseball. Similar to
Hockey and Tennis, we got a csv file for baseball players and made new classes
for getting stats, comparing, and predicting. We were also able to save the data that
was already retrieved by the app, meaning we do not have to retrieve the same data
over and over again. Additionally, 
by implementing new abstract classes we have greatly reduced redundant code. Establishing
these hierarchies in our classes has also made it easier to expand our program to include
other sports. Moreover, similar to our success with the Command design pattern in Phase 0, 
implementing the facade design pattern was very successful in Phase 1. Using the facade
design pattern has allowed us to easily incorporate the use case classes for all three
sports in the `CommandManager` class. This makes the code more structured and allows us 
to easily expand into the future by simply adding new classes into the respective facades.


## A summary of what each group member has been working on and plans to work on Next

First, all members continued working on previous code from phase 0 to improve readibility, and reduce redundant code. 
Similar to phase 0, the group has been having regular weekly meetings outside of our practical session, which has
helped all group members stay updated.  

Nazanin has worked on baseball stat manager, comparer, and predictor. She has also worked on DataContainer
for teams and players which demonstrates some form of data persistence. Karim worked on the `LeagueMemberManager`,
`LeagueStorage` and `LeagueMember` classes. `LeagueMember`, `Match` `LeagueStorage` are now serializable, and the `LeagueStorage`
class will also demonstrate data persistence, meaning that the user can save their league and load it back after they have closed
the app. Additionally, Karim helped Nazanin worked on the DataContainer implementation. Jack continued working on the `Match` class, which is needed
for the user to create games and make bets. Isaiah worked on the PlayerStat Facade classes, and the PlayerStat abstract
classes. The Facade classes store a use case class for each sport. For example, the `PlayerStatManagerFacade` class
stores `HockeyPlayerStatManager`, `TennisPlayerStatManager`, and `BaseballPlayerStatManager`. The `PlayerStatManagerFacade`
class will call on the correct StatManager class depending on which sport the user is interested in. Vishali continued working 
on the TennisPlayer classes, and the PlayerStatPredictor classes, which use linear regression to make predictions for the next season. 
Samuel continued working on the TeamStat classes. The `TeamStatManager` class will report the value of a given stat for a given team. The 
`TeamStatComparer` class will compare two teams and report which team had the higher value for a stat. Finally, the `TeamStatPredictor` class
will report the predicted winner between two teams by comparing the teams' win rates and rank.
