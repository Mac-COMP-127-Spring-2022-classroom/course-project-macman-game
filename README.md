# Mac-Man!

*By Arnika Abeysekera, Sarah Sylvester*

## Project Overview

Mac-Man is a video game that closely resembles the popular game, Pac-Man. For the most part, it’ll have the same rules and layout as the original game. The player moves through a maze to collect coins placed throughout it. Once all the coins are collected, the player wins. However, throughout the game, the player will be chased by four ghosts that will be randomly moving through the maze. If you get caught by any of the ghosts, you will lose a life. If you lose all three lives, the game is lost. 

## Creating the Game

The initial idea for the project was to almost replicate Pac-Man. While the logic and layout of the game is mostly similar in both games, there are some aspects we didn't implement, and some extra functionality we added. We didn't animate the Pac-Man/Mac-Man to open and close its mouth when it moves. However, we did add a home screen with play, quit, instructions and credit buttons instead of having the game open up immediately. 

The most challenging part of the project was to implement the random movement of the ghosts. While intially, the movement of a single ghost worked correctly, when refactoring the code to apply to multiple ghosts, there were many semantic errors. The ghosts would not move independently - they would move together in the same direction. The ghosts would not remove from the screen correctly, causing multiple images of the same ghost to appear. We fixed these issues through thorough testing and small changes in the code. Finally, we had to make the ghosts move continuously, which we did by repeatedly calling the `MoveGhost()` method in `MacManGame`.  

## How To Play

To run and play the game:
1. Enter the `MacManGame` class.
2. Run the `MacManGame` class by either scrolling to the bottom of the class and running the main method, or clicking the run button in the top right hand corner of the screen.

## Acknowledgements

This game is based entirely off of Pac-Man by Toru Iwatani. 

Code
- Starting code for the `Grid`, `Cell` classes by Benjamin Hillmann. 
- Original code for the `CustomButton` and `EmbeddedSwingComponent` classes copied from the Macalester kilt-graphics and modified by Timothy Lang.
- The `generateMaze()` method in `MacManGame` was created with the help of Jeremy Hubinger. 
- The switching between game screens was created with the help of Jeremy Hubinger. 

Graphics
- Graphic text made using [this website](https://fontmeme.com/). 
- Sprites images downloaded from [here](http://pixelartmaker.com/art/43f4f2b80d92eea).
