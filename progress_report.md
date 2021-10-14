##Progress Report
The report should include:

* a brief summary of your specification, CRC model, scenario walk-through, and skeleton program,
* open questions your group is struggling with,
* what has worked well so far with your design,
* and a brief summary of what each group member has been working on and plans to work on next.

####Brief summary of specification,  CRC model, scenario walk through, and skeleton program:

The CRC model classifies the classes to entities, user cases, controller and
presenters, and user interface based on the specification. As written in
the scenario walk through, the input is passed as a command and parsed using
the controller(input parser). The entities contain
team, player, user, game, and classes to store all teams and players.
As mentioned in specification, we have classes in the user case layer like
comparer, predictor, manager, and prediction of games for teams and players.
The output is then passed to the presenter, parsed and shown to the user.
The skeleton program ...


####Open questions: 
...

####What has worked well so far: 
We have been able to come up with a specification that has many features
of reporting statistics for different types of sports. We have identified
the correct layers of the clean architecture according the scenario walk through and
came up with a skeleton program that will be a demo of our program will
look like in the future.

####Brief summary of what each group member has been working on: 
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
and other player-focused stat classes, like predictor, and comparer.
Samuel started working on the TeamStatManager (to allow the user to
get statistical data for teams), TeamStatComparer (to allow the user
to compare statistical data for teams), TeamStatPredictor, and Team
classes. Vishali focused on working on the Player and Team classes,
which will store the necessary data to make statistical
manipulations possible. Finally, Jack started working on the Match class,
so that the user can make games and have the members make bets on them.
We will be writing our implementations for these completely and merge the later
to find any errors and incoherency.
