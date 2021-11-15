# Progress Report

## Open questions your group is struggling with
Should teams store player objects for every season?
What other use cases should we consider for the fantasy league aspect of our app?

## What has worked well so far with your design
We were able to expand our program to another sport, baseball. Similar to
Hockey and Tennis, we got a csv file for baseball players and made new classes
for getting stats, comparing, and predicting. We were also able to save the loaded
csv files and passes them so that there won't be any need to reload them. Additionally, 
by implementing new abstract classes we have greatly reduced redundat code. Establishing
these heirarchies in our classes has also made it easier to expand our program to include
other sports. Moreover, similar to our success with the Command design pattern in Phase 0, 
implementing the facade design pattern was very successful in Phase 1. Using the facade
design pattern has allowed us to easily incorporate the use case classes for all three
sports in the CommandManager class.

## A summary of what each group member has been working on and plans to work on next Presentation

First, all members continued working on previous code from phase 0 to improve readibility, and reduce redundant code. 
Similar to phase 0, the group has been having regular weekly meetings outside of our practical session, which has
helped all group members stay updated.
Nazanin has worked on baseball stat manager, comparer, and predictor. She has also worked on DataContainer
for teams and players which demonstrates some form of data persistence. Karim worked on the LeagueMemberManager,
LeagueStorage and LeagueMember classes. LeagueMember and LeagueStorage are serializable, and the LeagueStorage
class will also demonstrate data persistance. Jack continued working on the Match class, which is needed
for the user to create games and make bets. Isaiah worked on the PlayerStat Facade classes, and the PlayerStat abstract
classes. The Facade classes store a use case class for each sport. For example, the PlayerStatManagerFacade class
stores HockeyPlayerStatManager, TennisPlayerStatManager, and BaseballPlayerStatManager. The PlayerStatManagerFacade
class will call on the correct StatManager class depending on which sport the user is interested in. Vishali continued working 
on the TennisPlayer classes, and the PlayerStatPredictor classes, which use linear regression to make predictions for the next season. 
Samuel continued working on the TeamStat classes. The TeamStatManager class will report the value of a given stat for a given team. The 
TeamStatComparer class will compare two teams and report which team had the higher value for a stat. Finally, the TeamStatPredictor class
will report the predicted winner between two teams by comparing the teams' win rates and rank.
