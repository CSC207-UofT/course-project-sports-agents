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
application so the class loading the file can easily be
replaced by a class loading from an API for ease of transition
later in development.

A second design challenge was how to handle the
Player-Team relationship: how much should a `Player`
store about its current (and past) `Team`s and how much
should a `Team` store about its current (and past)
`Player`s? How would this change for sports with a larger
role for teams (such as hockey) compared to sports with
a smaller role for teams (such as tennis)?

We first decided
all sports should use the same player-team relationship
regardless of the role of the team, as
this allowed their `Player` and `Team` classes to use similar
inheritance patterns and increased the modularity of each
sports' classes (as they have identical functionality in
this area while differing in statistics-related features).
After reviewing our specification, we decided that `Player`s
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
which are `Player`s, `Team`s, `Match`es, and `Member`s, to be accessed and
modified only by Use Cases, which are the classes implementing the
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
Should this be changed if our application is remaining command line only?

## SOLID Principles

## Packaging Strategies

## Design Patterns
