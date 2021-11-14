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
API access as a later feature. However, we designed the 
application such that the class loading the file could easily be 
replaced by a class loading from an API allowing for ease of transition
later in development. 

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

TODO: More design decisions?


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
the behavior for other sports or other commands.

Open-Closed Principle: All classes make use of private variables with 
getters and setters, which ensures internal implementations can be changed
without changing the interface. The `Command` interface and structure of the
`commandManager` class allow easy adding of additional Use Cases for more
functionality, by adding the new Use Case to the command dictionary.

Liskov Substitution Principle: While we use inheritance, it is primarily
from an abstract class to concrete classes concerning specific sports. 
This means the Liskov substitution principle largely does not apply.
However, even in the abstract-concrete inheritance patterns we
ensure that overriding a parent method does not significantly change the
method behavior.

Interface Segregation Principle: Each Use Case (which corresponds to a 
function of the program) is separated into its own class and does not interact
with any other Use Case. This ensures each function of the program internally 
relates to only one sub-interface of the specific Use Class (though they
all share the same `Command` interface).

Dependency Inversion Principle: Each Use Case implements the `Command` 
interface, meaning the `commandManager` depends on the `Command` interface
rather than the specific class being used. 


## Packaging Strategies

## Design Patterns
We implement a Command design pattern almost word-for-word from the example
in the `Command` interface, where all Use Cases handle the user's input
by implementing `Command` interface with the `execute` method to perform the 
action as specified.
We implement a facade design pattern for `PlayerStatManager`, 
`PlayerStatComparer`, and `PlayerStatPredictor`. Each sport has their own 
class handling the function for that class (to avoid violating the 
Single Responsibility Principle), so the `PlayerStatManager` facade will
accept a command requesting a statistic and delegate it to the appropriate
sport's use case.

