"8 Queens" Solution
===================

This is a Java solution to the "8 queens problem", where a program must find all permutations of a chess board with 8 queens such that no queen threatens another.


Running
-------

Use gradle:

    gradle test
    gradle run


Solving n-queens
----------------

Change `boardSize` in `App.java` to whatever value you would like. I haven't implemented command line arguments since gradle makes it such a pain.
The app will only print out boards when there are less than 100 permutations.
