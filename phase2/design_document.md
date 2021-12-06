# Design Document

## SOLID Principles
### Single Responsibility Principle
The commands for getting,
comparing, and predicting statistics for each sport have a similar
format and function, but are responsible to different actors. To ensure
the way one sport is analyzed can be changed without affecting the other sports,
we created a unique Use Case class for each sport's implementation of
the `get_player_stat`, `compare_player_stat`, and `predict_player_stat`.
This provides flexibility for the future as we can add more sports without
changing the implementations of existing classes.

One later concern with the Single Responsibility Principle lies in the 
`MemberManager` class, which manages the Fantasy league by both managing the
league's members and managing the ongoing matches and bets. These functions 
are closely related, but are responsible to different actors (as the league
registation system and betting process are independent). If the fantasy
league aspect of the app was larger (or planned on being enlarged) this would
be a very high priority change, but our de-emphasization of this area led us to
leave the functions as-is to focus on other features of searching statistics.


### Open-Closed Principle
All classes make use of private variables with
getters and setters, which ensures internal implementations can be changed
without changing the interface. Both the `Command` interface and `DataContainer`
interfaces allow addition of more Use Cases or Data sources to increase 
functionality, which is very helpful for future expansion.
We also used several abstract classes such as `Player`, `Team`, `PlayerStatManager`,
`PlayerStatComparer`, and `PlayerStatPredictor` with concrete implementations
for each sport. This allows new sports to be added by creating subclasses of those
abstract classes, with no changes to existing classes in other sports.

### Liskov Substitution Principle
While we use inheritance, it is primarily
from an abstract class to concrete classes concerning specific sports.
This means the Liskov substitution principle largely does not apply.
However, even in the abstract-concrete inheritance patterns we
ensure that overriding a parent method does not significantly change the
method behavior.

### Interface Segregation Principle
The `Command` interface only forces
the dependent classes to implement a single method `execute`, with a
single argument. This allows the client classes to have a lot of flexibility
in how they implement the execution of their respective commands and what kind
of arguments they use. Additionally, this ensures we follow the Interface Segregation
Principle, since we make sure that the client only implements the methods it needs.

Likewise, the `DataContainer` interface only requires its classes to implement
two methods, meaning that the subclasses have flexibility in how they can store
the data and how they can retrieve it from their respective sources.

### Dependency Inversion Principle
When accessing data, our Use Cases objects 
with the`DataContainer` interface rather than a specific implementation with
data-accessing features. This means that our high-level
modules (Use Cases) do not depend on low-level modules (clients of `DataContainer`).
This provides us with flexibility in the future for changing the data source to a
web API or database.

Additionally, each Use Case implements the `Command` interface, meaning the
`CommandManager` depends on the `Command` interface rather than a
specific client class. This allows us to have a wide variety of commands, which
do not depend on a single unnecessarily general abstract class. For example,
our statistics-related commands and league-related commands are completely different
in their purposes, but are both commands. This provides us with future flexibility, in
case we want to add more features to our app.

## Clean Architecture
Our project follows clean architecture by allowing Entities,
which are `Player`s, `Team`s, `Match`es, and `Member`s, to be accessed
and modified only by Use Cases, which are the classes implementing the
Command interface (which each correspond to a User command).
The `commandManager` class acts as our controller by selecting the
appropriate Use Case then passing the command to it. The `Command`
interface with the `execute` method acts as our input boundary,
as all Use Cases execute the input command through that method, and 
also as the output boundary as it returns the result to display.
The `DataContainer` interface acts as the data access interface,
where Use Cases directly access files.

Since Phase 1, we have added a `Presenter` interface which functions as both 
a `ViewModel`. The `CLIPresenter` class implements this for the command line, 
while the `TestPresenter` class provides an implementation which could be
used to write test cases for the full program.

### Boundaries
We keep a tight boundary between the Interface Adapters and Use Cases using the
`Command` interface. We also have a much looser boundary between Use Cases and
Entities. While some Use Cases only access Entities through the `DataContainer`
interface, the `MemberManager` class creates and stores them directly. This boundary 
should be strengthened by moving `Member` and `Match` storage 
into a `DataContainer` or possibly creating a new interface to ensure
`DataContainer` classes do not violate the single responsibility principle
by storing statistics and fantasy league information.


## Design Patterns
We implemented the Command design pattern almost word-for-word from the example
in the `Command` interface, where all Use Cases handle the user's input
by implementing `Command` interface with the `execute` method to perform the
action as specified by the arguments passed by the user. This allows us to achieve high
decoupling by encapsulating our commands into completely separate processes, and ensuring
that the command manager is not aware of the details in the commands.

Furthermore, we implemented the facade design pattern for `PlayerStatManager`,
`PlayerStatComparer`, and `PlayerStatPredictor`. For example, since each sport has its own
class handling the function for that class (to avoid violating the
Single Responsibility Principle), the `PlayerStatManager` facade will
accept a command requesting a statistic and delegate it to the appropriate
sport's use case.

We additionally implemented the Strategy design pattern, when we implemented
the `DataContainer` interface. In this case, the `DataContainer` interface
is the Strategy interface, and the `CSVDataContainer` is the concrete strategy
which implements the Strategy interface. This pattern gives us flexibility
in the future, in case we decide to change how we retrieve the data or
how we store it or process it. For instance, if we decide that we want our
data to be retrieved from online sources, we will make another strategy called
`OnlineDataContainer`, which will have a different algorithm for retrieving data.

Finally, we implemented the `Builder` design pattern in the `CommandDictBuilder` 
class. This class performs the complicated process of creating all the Use Cases
and associating each command's Use Case with the appropriate keyword, before
returning this dictionary for the `commandMangager` class to use. It has a 
relatively limited function with its single call per operation of the 
program, but is important in keeping the `commandManager` class simple.


## Use of GitHub Features
Throughout the term, we made consistent use of branches and pull requests.
Each group member created their own branch and complete their task within it. 
Once finished, they would merge `main` into their branch, resolve any conflicts,
create a pull request, and request a review. Another group member would review it, 
make comments, and approve the request to merge the branch into `main`. 

We attempted to use GitHub issues, and they guided some discussion, but we
rapidly discovered we preferred discussing issues on Discord: our program's 
smaller scale meant features were often interconnected, so creating a 
distinct branch for each was inconvenient; people also did not check or post to
GitHub frequently, so it discussions fell behind on reality. In Discord 
(which had much more frequent interaction), we had an Update
chat dedicated to items needed to be done or tasks recently done. 

We attempted to use a Github action which checked the code for syntax errors.
However, it was not much better than IntelliJ's built-in features to
review code. At some point it was accidentally deleted during a merge, 
and it was contributing so little that we decided to not re-add it.


## Code Style and Documentation
We have added JavaDoc to all classes and methods to establish their functions and 
preconditions. We included comments where applicable. We have used IntelliJ's tools
to reformat code to follow style convention and inspect code to prevent 
all warnings of importance.

## Testing
Most components of our program has been tested. All concrete player classes
have tests. All concrete children of `PlayerStatManager`, `PlayerStatComparer`, and
`PlayerStatPredictor` classes have tests. However, we were not able to write tests
for some methods in the `GetList` class. For example, the `GetList` class
can return all players in all sports. We did not write a test for the method
that does this because the list of players returned is far too long.

## Refactoring
Following Phase 0, we extensively refactored code to reduce duplicate code.
For example, the abstract `PlayerStatManager`, `PlayerStatComparer`, and
`PlayerStatPredictor` were added after Phase 0. These abstract classes significantly
reduced redundant code, and made it easier for more sports (such as baseball) to
be added to the program. Following Phase 1, we refactored our packages. As we
added more classes to each package, packages quickly became too large (in particular
the `commands` package, as adding functionality adds Use Cases). As such,
changed our packaging to separate sports and leave only general Use Cases in
the `commands` package.

## Code Organization
Our code is Packaged by function, but with more specificity in function than in
Phase 1. The `driverAdapters` package still stores driver and interface adapter
classes, and the `constants` package still stores general constants.
The `commands` package now stores only general Use Cases. Each sport 
has a sub-package of the `sports` package, which holds that sports' `Player` and
Use cases. 

## Functionality
Our program fulfills our specification significantly, as it supports three sports
(hockey, baseball, and tennis), the User can
query data about players and teams, the User can compare and predict these 
statistics, and the User can manage a fantasy league's members and their 
bets. The Fantasy League data can be saved and loaded, through the `save` and
`load` commands. However, there were
some aspects of our specification that were not included. For example,
we originally wanted to allow the user to upload a .csv file of their
own and load data from this file. However, our program does not currently
allow the user to upload a file. The user can only access data that is available
in the .csv files that we have added. Due to the departure of one team member, 
our program does not support baseball teams and only stores information 
on hockey teams.


## Other Important Project Components
### Major Design Decisions
A first large challenge was how the application should access
sports statistics: should they be loaded from a file (allowing
loading of larger datasets once downloaded), 
or should they be loaded from a web
API (requiring a complex code and a free-to-use API but 
offering up-to-date data)? 

As discussed in Phase 1, we decided to load large datasets from a 
file at first and postpone API access as a later feature, as this
would create a simpler initial program. Due to time constraints following
stage 1, we opted to not work on API access and instead polish other 
features. However, our program's `DataContainer` interface functions as a 
Strategy design pattern which the rest of the program uses to access data. 
In the future, the program could easily be expanded to
access data via an API, a database, or any other method by writing a new
class which implements the `DataContainer` interface.


A second design challenge was how to handle the
Player-Team relationship: how much should a `Player` 
store about its current (and past) `Team`s and how much
should a `Team` store about its current (and past)
`Player`s? How would this change for sports with a larger
role for teams (such as hockey) compared to sports with
a smaller role for teams (such as tennis)? 

We first decided that
all sports should use the same player-team relationship 
regardless of the role of the team, as
this allowed their `Player` and `Team` classes to use similar 
inheritance patterns and increased the modularity of each 
sports' classes (as they have identical functionality in
this area while differing in statistics-related features).
After reviewing our specifications, we decided that `Player`s
should only know the name of their `Team` and `Team`s should only
know the name of their `Player`s, rather than storing further
information or a pointer to the full object.
A user's query about a team or player should only retrieve 
data about that `Team` or `Player`, so storing the name is 
sufficient; if the player requires information about the 
player's team or team's player, they should make a new query 
using the name which was returned. This system reduces 
coupling and simplifies the process of recording new players 
and teams, as there are no links between `Player` and `Team` to 
update.


A third later design challenge was providing accessibility for the program, 
both in providing ease-of-use and in assisting disabled users. Given our 
program uses the command line, which has very limited input and output, 
how do we teach users how the command syntax works, how do we make the
features intuitive to use, and how do we make this more accessible to
individuals with vision disabilities?

After discussing with the TA following Phase 1, we decided to include
instructions on using the program into the program itself. Rather than
creating a separate instruction document, we created the `get_available_commands`
Use Case which will print the program's full list of commands and instructions 
on how to use them. We also created the `Search` use case, which allows users to 
search `Player`s for a name, and the `GetListPlayers`, `GetListSports`, and 
`GetListStats` use cases to display the full list of players, sports, and 
statistics available. 

To assist regular usage, we implemented both a verbose format and short 
format for command input. The verbose mode allows the user to include the names
of the arguments in their command and put the arguments in any order, which
both make the command more readable (by tagging each phrase with its purpose). 
The short form, for more regular users, enforces the order of commands 
and reduces their readability, but saves time by making commands shorter.
The choice to use either command form provides more user flexibility.

For more about the disability accessibility decisions, read the 
`accessibility.md` file. It's a longer discussion, so repeating it in 
full here would be longer than needed.

### Group Interactions
We communicated on Discord, and worked purely online. While this was challenging
due to the lack of face-to-face communication, we created several beneficial
alternatives such as the Updates channel dedicated to important TODO items and 
a Use Cases channel dedicated to brainstorming Use Cases and their interactions
with the rest of the program before implementing them in code.


### Last-Minute Group Change
In the last week of November, our group member Samuel Glasroth was de-enrolled 
from CSC207. This reduced our group of 6 to a group of 5 and was a significant 
setback, as he was heavily involved in implementing team features. Due to this, we
were unable to finish implementing all team classes and team functionality.
It also strained our other work, as we had to take a break, re-evaluate our roles, 
and examine how much we could reasonably implement for Phase 2 in the 
remaining time without Samuel.
