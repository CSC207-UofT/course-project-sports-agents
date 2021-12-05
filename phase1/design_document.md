# Progress Report

## Major Design Decisions
A first large challenge was how the application should access
sports statistics: should they be loaded from a file (allowing
loading of larger datasets once downloaded), 
or should they be loaded from a web
API (requiring a complex code and a free-to-use API but 
offering up-to-date data)? 

Due to 
practical cost concerns and the goal of initially minimizing 
complexity, we decided to load large datasets from a file with 
API access as a later feature. However, we implemented the Strategy
design pattern, which allows us to write more classes in the future
that might have a different way of retrieving data, like retrieving data
from an API or otherwise.

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


## Clean Architecture
Our project follows clean architecture by allowing Entities,
which are `Player`s, `Team`s, `Match`es, and `Member`s, to be accessed 
and modified only by Use Cases, which are the classes implementing the 
Command interface (which each correspond to a User command).
The `commandManager` class acts as our controller by selecting the 
appropriate Use Case then passing the command to it. The `Command` 
interface with the `execute` method acts as our input boundary, 
as all Use Cases execute the input command through that method.
The `DataContainer` interface acts as the data access interface, 
where Use Cases directly access files. We were slightly unsure about 
this: it appears in the slides and other resources, but feels slightly
unusual as it is a case of a Use Case class interacting with a file
(in the framework layer).

We currently lack an output boundary or presenter class, as each 
Use Case performs its own presenting through the `formatOut` method.
Should this be changed if our application is remaining command line 
only?

## SOLID Principles
Single Responsibility Principle: While the commands for getting, 
comparing, and predicting statistics for each sport have a similar 
format, they are each handled by a unique Use Case class to ensure
that each of their behavior can be changed without affecting
the behavior for other sports or other commands. This provides us with
a lot of flexibility in the future when we add more sports, since 
we will not need to change the implementation of the existing classes.

Some code related to Teams (primarily the `TeamStatManager`, 
`TeamStatPredictor`, and `TeamStatComparer`)
violates the Single Responsibility Principle because it handles multiple
sports within one class. This will be fixed at a later date.

Open-Closed Principle: All classes make use of private variables with 
getters and setters, which ensures internal implementations can be changed
without changing the interface. The `Command` interface and structure of the
`commandManager` class allow easy adding of additional Use Cases for more
functionality, by adding the new Use Case to the command dictionary. Additionally,
due to how we define the abstract `Player` class, we can easily extend each of the
subclasses to allow it to access statistics, which are specific to the sport.  

Liskov Substitution Principle: While we use inheritance, it is primarily
from an abstract class to concrete classes concerning specific sports. 
This means the Liskov substitution principle largely does not apply.
However, even in the abstract-concrete inheritance patterns we
ensure that overriding a parent method does not significantly change the
method behavior.

Interface Segregation Principle: The `Command` interface only forces 
the dependent classes to implement a single method `execute`, with a
single argument. This allows the client classes to have a lot of flexibility
in how they implement the execution of their respective commands and what kind
of arguments they use. Additionally, this ensures we follow the Interface Segregation
Principle, since we make sure that the client only implements the methods it needs.

Likewise, the `DataContainer` interface only requires its classes to implement
two methods, meaning that the subclasses have flexibility in how they can store
the data and how they can retrieve it from their respective sources.

Dependency Inversion Principle: When accessing data, our use cases use
objects, which are dependent on the `DataContainer` interface, instead of
a specific implementation of a `DataContainer`. This means that our high-level
modules (use cases) do not depend on low-level modules (clients of `DataContainer`). 
This provides us with flexibility in the future, in case we want to change how we
retrieve data or change the source from which we retrieve data. For example, if we
retrieve data from a database instead of a .csv file. 

Additionally, each Use Case implements the `Command` interface, meaning the 
`CommandManager` depends on the `Command` interface rather than a 
specific client class. This allows us to have a wide variety of commands, which 
do not depend on a single unnecessarily general abstract class. For example, 
our statistics-related commands and league-related commands are completely different
in their purposes, but are both commands. This provides us with future flexibility, in
case we want to add more features to our app. 


## Packaging Strategies
We used the feature packaging strategy. All entity classes related to teams are 
in the `team` package, all entity classes related to players are in the `player`
package, all entity classes related to the fantasy league members are in the 
`leagueMember`, all use case classes which handle user commands are in the 
`command` package, and all drivers responsible for program operation are in the
`driversAdapters` package. This packaging strategy worked best for us, because
all of us found it to be the most straightforward and easiest to work with. Additionally,
our app's structure really fit quite well with the packaging strategy, making
our development process smooth and helping us work together better.

The `command` package is expanding as we add more commands. While this is not a massive problem ,
as we have many commands which should go under a `command` package, are there any 
simple solutions to reducepackage size and simplify it?


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

Finally, we implemented the Strategy design pattern, when we implemented
the `DataContainer` interface. In this case, the `DataContainer` interface
is the Strategy interface, and the `CSVDataContainer` is the concrete strategy
which implements the Strategy interface. This pattern gives us flexibility
in the future, in case we decide to change how we retrieve the data or 
how we store it or process it. For instance, if we decide that we want our
data to be retrieved from online sources, we will make another strategy called
`OnlineDataContainer`, which will have a different algorithm for retrieving data.

