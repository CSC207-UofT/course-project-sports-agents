##Progress Report
The report should include:

* a brief summary of your specification, CRC model, scenario walk-through, and skeleton program,
* open questions your group is struggling with,
* what has worked well so far with your design,
* and a brief summary of what each group league_member has been working on and plans to work on next.

#### Brief summary of our specification:
As mentioned in the specification, a user should be able to import/export data for a sports team/Player
and be able to retrieve within the app. Additionally, based on the data, the app should be able to 
predict the outcome of a match. The user should also be able to create matches and members, who 
can bet on the matches and attempt to predict the outcome of the match themselves; the app will track
how well a league_member can predict a match.

#### Brief summary of our CRC Model:
The CRC model classifies the classes to entities, use cases, controller and presenters, and user interface based
on the specifications. It contains the classes we think we will need so far and their responsibilities, as well as the 
relationships between the classes. This allows our development to be more structured and straightforward.

#### Brief summary of our scenario walk through
After importing the data, the user will use the commands available in the app to compare two teams and decide which team
will win in the upcoming match. The user will create the match in the system and make a prediction for it. The user
will also make a prediction on the behalf of another league_member of the fantasy league. 

#### Brief summary of the skeleton program
Our skeleton program can add a league_member to their fantasy league. The user can also create matches, on which the members
can bet and attempt to guess the outcome of the match. Finally, our skeleton program can retrieve the statistics and the
data on a Player and a team based on the name, which is passed as an argument in the CLI. 


####Open questions: 
How should we implement data retrieval for the team/Player statistics? Should the data be already stored in the app, 
or retrieved from a file or retrieved online using an API?
Would it be possible for us to submit a .csv file with our program? Are there any particular restrictions about API
usage for the assignment?


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

In terms of the code itself, we think that our class structure has been working really well, in particular the structure
of our teams and players classes. This type of implementation allows us to integrate different kinds of sports into the
app, which might have completely different statistics available. We are also happy that we were able to implement a
command interface, which allows different kind of classes with completely different purposes to be used as use cases.
It gives us a lot of flexibility and doesn't require us to write an abstract parent class, which would most-likely be
too general to be truly useful. 

####Brief summary of what each group league_member has been working on: 
We have all been working on the CRC cards as well as example use cases
for our application. We have been working on these together during our
meetings, as well as separately throughout the week. If someone had an
addition to make, we would make sure to first discuss this on Discord
through texting.

After our second meeting on Friday 8th October, we assigned each person
a section of a project in order to create our skeleton project.
Karim started working on the CommandManager as well as the main method.
Isaiah began working on the Member class to allow the main user to add
members to their list. Nazanin began implementing the PlayerStatManager,
and other Player-focused stat classes, like predictor, and comparer.
Samuel started working on the commands.TeamStatManager (to allow the user to
get statistical data for teams), commands.TeamStatComparer (to allow the user
to compare statistical data for teams), commands.TeamStatPredictor, and Team.Team
classes. Vishali focused on working on the Player.Player classes,
which will store the necessary data to make statistical
manipulations possible. Finally, Jack started working on the Match class,
so that the user can make games and have the members make bets on them.
We will be writing our implementations for these completely and merge the later
to find any errors and incoherency.
