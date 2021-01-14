### Conway's Game of Life solution in Java 
[link](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

The game of life is a well known cellular automata where only 2 state of cells comes into play,
and with just a few rules demonstrates itself that, based on the initial conditions,
it generates a lot of mesmerizing patterns throughout the game field.

####Rules
* Any live cell with fewer than two live neighbours dies, as if by under-population.
* Any live cell with two or three live neighbours lives on to the next generation.
* Any live cell with more than three live neighbours dies, as if by overpopulation.
* Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.