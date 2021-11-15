## Sports Agents Application

The Sports Agents Application provides a way for users to
access statistics about sports, compare players and teams,
and form a Fantasy league by placing bets on the outcomes of future
matches.

Specifications:

The app will consider several sports, currently hockey, tennis, 
and baseball.
While each sport has different statistics, the app will 
provide a similar set of available operations on 
all statistics regardless of sport.

Users can upload data on sports players and teams by running
a command on the command line to load data from a file. 
In the future, this will be expanded to allow
accessing data from the web via an API. 
Loaded data is stored for future querying,
examination, or computations. Users can examine the stored 
data in detail through the app. 
In addition to examining statistics for
players and teams individually, they can compare players
and teams with each other. Comparisons of teams are used by the 
app to predict which team is more likely to win an
upcoming match.
Users can also request the app 
generate predictions of a player's future performance using 
linear regression or exponential regression models.

The user of the app can register members of their fantasy league.
This fantasy league is a group of friends competing to predict
the outcomes of upcoming matches. Once upcoming matches are
input manually, on behalf of the league's members the user 
can make predictions (called
bets) on the outcome of the upcoming matches. 
Each member will
have a history of their correct bets and incorrect bets. In the
future, this will allow rankings within the league as members
compete with each other to make the most correct predictions.

The current set of upcoming matches and members can be saved
as a Java serialized object and later re-loaded to
restore the data on the fantasy league.

Future features to implement include:
* Exporting the player and team data and predictions
to a spreadsheet or other file format.
* Provide a web app or similar GUI
* Expand on statistics provided for each sport
* Offer more prediction services using more complex models
