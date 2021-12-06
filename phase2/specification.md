## Sports Agents Application

The Sports Agents Application provides a way for users to
access statistics about sports, compare players and teams,
and form a Fantasy league by placing bets on the outcomes of future
matches.

Specifications:

The app will consider several sports: hockey, baseball, and tennis.
While each sport has different statistics, the app will 
provide a similar set of available operations on 
all statistics regardless of sport.

Users can examine the stored 
data in detail through the app. 
In addition to examining statistics for
players and teams individually, they can compare players in order
to determine which better has higher performance in a particular
area. Users can also request the app 
generate predictions of a player's future performance using 
linear regression or exponential regression models. Please note that 
due to unforeseen circumstances (one of our member leaving), we were not
able to implement similar functionality for the entire app.

The user of the app can register members for their fantasy league.
This fantasy league is a group of friends competing to predict
the outcomes of upcoming matches. Once upcoming matches are
input manually, on behalf of the league's members, the user 
can make predictions (called
bets) on the outcome of the upcoming matches. 
Each member will
have a history of their correct bets and incorrect bets. This can allow
the players to compete with each other. Additionally, the players can
use the functionality of the app in order to determine who they think
will win any given match.

The current set of upcoming matches and members can be saved
as a Java serialized object and later re-loaded to
restore the data on the fantasy league.