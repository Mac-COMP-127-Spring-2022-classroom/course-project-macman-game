package macman;

import edu.macalester.graphics.GraphicsGroup;

import java.util.List;

/**
 * Represents a grid of cells that is populated to form the maze and all its elements (coins,
 * ghosts, walls and player).
 */
public class Grid extends GraphicsGroup {
    protected int numRows, numCols;
    protected double size;
    private MacManGame game;
    protected Cell[][] cells;
    private Player player;
    private int playerRow = 11;
    private int playerCol = 11;
    private List<Ghost> ghosts;

    private static final int DIRECTION_UP = 0;
    private static final int DIRECTION_DOWN = 1;
    private static final int DIRECTION_LEFT = 2;
    private static final int DIRECTION_RIGHT = 3;

    /**
     * Initializes a grid with a speicified number of rows and columns and overall size.
     */
    public Grid(int numRows, int numCols, int size, String[][] maze, Player player, List<Ghost> ghosts,
        MacManGame game) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.size = size;
        this.player = player;
        this.ghosts = ghosts;
        this.game = game;
        createGrid(maze);
    }

    /**
     * Populates the grid with a cell for each unique row/column combination and fills each cells based
     * on the speicified element to be in it.
     */
    private void createGrid(String[][] maze) {
        cells = new Cell[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                String type = maze[i][j];
                Cell cell = new Cell(size);
                cell.getGraphics().setPosition(i * size, j * size);
                if (type.equals("B")) {
                    cell.addGraphics(new Wall(size, size));
                    cell.setTraversable(false);
                } else if (type.equals("C")) {
                    cell.addCoin(size);
                }
                this.add(cell.getGraphics());
                cells[i][j] = cell;
            }
        }
        addtoGrid();
    }

    /**
     * Adds the ghosts and the player to the grid in their specified row/column locations.
     */
    private void addtoGrid() {
        cells[playerRow][playerCol].addPlayer(player);
        for (Ghost ghost : ghosts) {
            cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            ghost.chooseRandomDirection();
        }
    }

    /**
     * Checks if there is an interaction between player and ghost (if they are currently in the same
     * cell), starting a new turn if true, thereby reducing the player's lives by one and setting it's
     * position back to the starting position.
     * 
     * @return true if the player has interacted with the ghost.
     */
    public boolean playerGhostInteraction() {
        for (Ghost ghost : ghosts) {
            if (cells[playerRow][playerCol] == cells[ghost.getGhostRow()][ghost.getGhostCol()]) {
                cells[playerRow][playerCol].removePlayer();
                playerRow = 11;
                playerCol = 11;
                cells[playerRow][playerCol].addPlayer(player);
                return true;
            }
        }
        return false;
    }

    /**
     * Moves the player to the specified row and column if it is a legal move (not a wall, or not
     * off-screen).
     */
    private void movePlayer(int row, int col) {
        if (row >= numRows || col >= numCols) {
            // Pac-Man off screen
        } else if (!cells[row][col].getTraversable()) {
            // hit wall
        } else {
            cells[playerRow][playerCol].removePlayer();

            playerCol = col;
            playerRow = row;
            cells[row][col].addPlayer(player);
            playerCoinInteraction();

        }
    }

    /**
     * If the player has entered a cell with a coin in it, removes the coin from the cell and updates
     * the coin counter to reflect this change.
     */
    public void playerCoinInteraction() {
        if (cells[playerRow][playerCol].removeCoin()) {
            game.updateNumOfCoins();
        }
    }

    /**
     * Moves the player one cell to the right.
     */
    public void movePlayerRight() {
        movePlayer(playerRow + 1, playerCol);
    }

    /**
     * Moves the player one cell to the left.
     */
    public void movePlayerLeft() {
        movePlayer(playerRow - 1, playerCol);
    }

    /**
     * Moves the player one cell downwards.
     */
    public void movePlayerDown() {
        movePlayer(playerRow, playerCol + 1);
    }

    /**
     * Moves the player one cell upwards.
     */
    public void movePlayerUp() {
        movePlayer(playerRow, playerCol - 1);
    }

    /**
     * Checks if the ghost can move one cell in its current direction.
     * 
     * @return true if it can, false if it cannot.
     */
    private boolean canGhostMove(Ghost ghost) {
        if (ghost.getGhostDirection() == DIRECTION_RIGHT
            && !cells[ghost.getGhostRow() + 1][ghost.getGhostCol()].getTraversable()) {
            return false;
        } else if (ghost.getGhostDirection() == DIRECTION_UP
            && !cells[ghost.getGhostRow()][ghost.getGhostCol() - 1].getTraversable()) {
            return false;
        } else if (ghost.getGhostDirection() == DIRECTION_LEFT
            && !cells[ghost.getGhostRow() - 1][ghost.getGhostCol()].getTraversable()) {
            return false;
        } else if (ghost.getGhostDirection() == DIRECTION_DOWN
            && !cells[ghost.getGhostRow()][ghost.getGhostCol() + 1].getTraversable()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * If the ghost cannot move in its current direction any further, sets the direction of the ghost to
     * a different one.
     */
    private void changeGhostDirection(Ghost ghost) {
        if (ghost.getGhostDirection() == DIRECTION_RIGHT) {
            while (ghost.getGhostDirection() == DIRECTION_RIGHT) {
                ghost.chooseRandomDirection();
            }
        } else if (ghost.getGhostDirection() == DIRECTION_UP) {
            while (ghost.getGhostDirection() == DIRECTION_UP) {
                ghost.chooseRandomDirection();
            }
        } else if (ghost.getGhostDirection() == DIRECTION_LEFT) {
            while (ghost.getGhostDirection() == DIRECTION_LEFT) {
                ghost.chooseRandomDirection();
            }
        } else if (ghost.getGhostDirection() == DIRECTION_DOWN) {
            while (ghost.getGhostDirection() == DIRECTION_DOWN) {
                ghost.chooseRandomDirection();
            }
        }
    }

    /**
     * If the ghost can move one space in its current direction, moves the ghost to that new cell.
     */
    public void moveGhost(Ghost ghost) {
        if (!canGhostMove(ghost)) {
            changeGhostDirection(ghost);
        } else {
            if (ghost.getGhostDirection() == DIRECTION_DOWN) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostCol(ghost.getGhostCol() + 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            } else if (ghost.getGhostDirection() == DIRECTION_UP) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostCol(ghost.getGhostCol() - 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            } else if (ghost.getGhostDirection() == DIRECTION_LEFT) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostRow(ghost.getGhostRow() - 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            } else if (ghost.getGhostDirection() == DIRECTION_RIGHT) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostRow(ghost.getGhostRow() + 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            }
        }
    }
}
