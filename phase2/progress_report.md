All members continued working on previous code from phase 1 to improve readibility, refactor, and incorporate the recieved feedback. Similar to phase 0 and 1, the group has been having regular weekly meetings outside of our practical session, which has helped all group members stay updated. Based on the feedback after phase1, in order for our program to be used easier, we added some new features. 

Nazanin has worked on `GetList` for sports, players, and stats and `Search` so the user can know the available options for each and based on that, provide the arguments for a command.
[Pull Request](https://github.com/CSC207-UofT/course-project-sports-agents/actions/runs/1542419457)


Karim has worked on the output formatter methods in the Command classes. 
This makes the output much easier to see for the user and allows them to easily
compare players, or simply analyze a single player's performance. This
drastically increases the usability of the app, and allows the user to more easily
see the output of the app. [Pull Request](https://github.com/CSC207-UofT/course-project-sports-agents/pull/46)

Isaiah has worked on the Verbose Parsing functionality in the `InputParser` class.
This allows including the argument names in the input, which makes the command's
purpose much clearer. The application still supports the short form, which is
less readable but is faster to type. Alongside these changes, he also modified
the application to ignore the capitalization of inputs.
[Pull Request](https://github.com/CSC207-UofT/course-project-sports-agents/pull/53)

Vishali has worked on adding tennis player data and updating the `TennisPlayer`
class. The .csv file used for tennis players was changed. 
The old .csv file required users to query players by competition name
instead of season. It also only contained data for one year.
The new file contains data for multiple years, and players can now be queried
by year. [Pull Request](https://github.com/CSC207-UofT/course-project-sports-agents/pull/47)

Jack has worked on refactoring the project's package structure. He broke up the too-large
`commands` package, created the `sports` package, and gave each sport a
subpackage within that package. This makes the project much easier to navigate
and would make the addition of future sports much easier. 
[Pull Request](https://github.com/CSC207-UofT/course-project-sports-agents/pull/50)
