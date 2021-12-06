# Accessibility

## Question 1:
Principles of Universal Design:

Equitable use: 
Our program requires the user to type in commands with specific keywords and 
arguments, with no misspellings. This is challenging for those with impaired 
motor coordination. In the future, we could implement multiple input sources. 
For example, we could allow the user to choose their commands 
(e.g. predict_player_stat, compare_player_stat, or get_player_stat) via a Web interface 
which allows either typing, clicking buttons, or selecting from a dropdown. 

Flexibility in use:
We allow users to either use verbose mode commands or short mode commands,
depending on their preference in readability or command length.
In the future, we could support more interfaces, such as a GUI with buttons.

Simple and intuitive use: 
Our program provides assistance through the `available_commands` method (to list all
commands and their usages) and the several list commands to list other important
features of the commands. We provide detailed error messages on invalid inputs, 
warning them where or why their input is invalid.
In the future, we could add a "help" feature to explain sports-related terms. 
As an example, most people are unfamiliar with tennis's "Double Faults", so 
an explanation command would tell them what it means and that a Double Fault is
a mark of poor play.

Perceptible information: 
The command line limits our ability to modify how text is displayed in colors
and font. However, we added a new display formatting method to present results
in a table format, which makes them easier to view. These decorative dashes 
makes it less accessible to screen readers, so in the future we will create a 
screen reader view with only important information to be read out loud.


Tolerance for error:
We convert all inputs to lower case, which tolerates any mis-capitalizations from the 
user. However, it still requires commands be spelled exactly correctly, otherwise they will not
function. In the future, we could implement a rudimentary form of spellcheck
to correct single-letter spelling mistakes in words and tolerate that error.

Low physical effort:
Our program only requires the user to type on the command line, making this
principle less important. 
However, to minimize the amount of typing, we could implement a 
GUI or other interface in the future.

Size and space for approach and use: 
Our program only requires that the user can see their computer screen 
and access their keyboard (to type in commands). This means the principle is 
difficult to apply here.


## Question 2:
Since our product is based around sports statistics and fantasy sports, 
the target category of consumers would be sports fans or sports analysts.
Specifically, we should market to fantasy sports groups, 
as the application offers both the ability to manage a fantasy sport group and 
also perform the research and analysis to make informed fantasy sport bets.
We should also market to individuals interested in a variety of sports, 
as our program implements many sports, so they would be engaged with all its 
features rather than only the aspects related to one sport.


## Question 3:
Our program is less likely to be used by the non-target demographic, which is people
who do not enjoy sports, fantasy sports, or sports statistics. Because our program 
is currently on the command line, it is also less likely to be used by people
with disabilities making command line usage more difficult; this includes 
those with limited motor coordination (as typing is more difficult), those
with vision impairment (as the command line font is very small), and those 
with less technical experience (such as the elderly).

