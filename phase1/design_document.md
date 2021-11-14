# Progress Report

## Major Design Decisions
A first large challenge was how the application should access
sports statistics: should they be loaded from a file (allowing
loading of larger datasets once downloaded), 
or should they be loaded from a web
API (requiring a complex code and a free-to-use API but 
offering up-to-date data)? Due to 
practical cost concerns and the goal of initially minimizing 
complexity, we decided to load large datasets from a file with 
API access as a later feature. However, we designed the 
application so the class loading the file can easily be 
replaced by a class loading from an API for ease of transition
later in development. 

TODO: More design decisions.


## Clean Architecture

## SOLID Principles

## Packaging Strategies

## Design Patterns

