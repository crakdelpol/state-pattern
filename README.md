# Gumball Machine

This machine starting in "No quarter" state.
When someone put a Quarter (of dollars) inside the machine, this change our state in "Has Quarter".
Now you can Turns Crank and get Gumball or eject Quarter. So in this case we can go to two different scenarios. "Eject quarter" and "Turns Crank".
Later for Turns Crank the gumball will be sold, now there is "Gumball Sold" state.
Then now, if the gumball is to sold the next state is no quarter. But if the gumball inside of machine are 0 the machine go in a new state "Out of gumballs"
Keep in mind that someone could try to move from insert quarter to eject quarter. In this case nothing could be happen.

So decompose problem above:

There are 4 states
- no quarter 
- has quarter 
- out of gumballs
- gumball sold


There are 4 actions available

- insert quarter
- ejects quarter
- turns crank
- dispense
- refill

The possibles scenario are:

- happy path (insert quarter turns crank and dispense gumball
- eject quarter before insert it
- turn crank before insert coin
- turn crank but there aren't gumballs (in this case eject quarter and move out of gumballs)
- dispense without quarter
- refill can be done only when is out of gumballs or no quarter
 


