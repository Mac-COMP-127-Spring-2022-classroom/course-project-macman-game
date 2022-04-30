package macman;

import edu.macalester.graphics.GraphicsGroup;

import java.util.ArrayList;
import java.util.List;

public class Grid extends GraphicsGroup {
    protected int numRows, numCols;
    protected double size;
    protected Cell[][] cells;
    private Player player;
    private int playerRow = 11;
    private int playerCol = 11;
    private List<Ghost> ghosts = new ArrayList<>();

    private final int DIRECTION_UP = 0;
    private final int DIRECTION_DOWN = 1;
    private final int DIRECTION_LEFT = 2;
    private final int DIRECTION_RIGHT = 3;

    public Grid(int numRows, int numCols, int size, String[][] maze, Player player, List<Ghost> ghosts) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.size = size;
        this.player = player;
        this.ghosts = ghosts;
        createGrid(maze);
    }

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

    // adds ghost and player to grid
    private void addtoGrid() {
        cells[playerRow][playerCol].addPlayer(player);
        for (Ghost ghost : ghosts) {
            cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            ghost.chooseRandomDirection();   
        }
    }

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

    private void movePlayer(int row, int col) {
        if (row >= numRows || col >= numCols) {
            // Pac-Man off screen
        } else if (!cells[row][col].getTraversable()) {
            // hit wall
        } else {
            playerCoinInteraction();
            cells[playerRow][playerCol].removePlayer();

            playerCol = col;
            playerRow = row;
            cells[row][col].addPlayer(player);
        }
    }

    public boolean playerCoinInteraction() {
        if (cells[playerRow][playerCol].removeCoin()) {
            return true;
        }
        return false;
    }

    public void movePlayerRight() {
        movePlayer(playerRow + 1, playerCol);
    }

    public void movePlayerLeft() {
        movePlayer(playerRow - 1, playerCol);
    }

    public void movePlayerDown() {
        movePlayer(playerRow, playerCol + 1);
    }

    public void movePlayerUp() {
        movePlayer(playerRow, playerCol - 1);
    }

    // moves ghost in the randomly generated direction
    public void moveGhost(Ghost ghost) {
        if (!canGhostMove(ghost)) {
            changeGhostDirection(ghost);
        } else {
            if (ghost.getGhostDirection() == DIRECTION_DOWN) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostCol(ghost.getGhostCol() + 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            }
            else if (ghost.getGhostDirection() == DIRECTION_UP) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostCol(ghost.getGhostCol() - 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            }
            else if (ghost.getGhostDirection() == DIRECTION_LEFT) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostRow(ghost.getGhostRow() - 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            }
            else if (ghost.getGhostDirection() == DIRECTION_RIGHT) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostRow(ghost.getGhostRow() + 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            }
        }
    }

    // returns false if there is a wall one cell in front in the ghost's current direction
    private boolean canGhostMove(Ghost ghost) {
        if (ghost.getGhostDirection() == DIRECTION_RIGHT && !cells[ghost.getGhostRow() + 1][ghost.getGhostCol()].getTraversable()) {
            return false;
        } else if (ghost.getGhostDirection() == DIRECTION_UP && !cells[ghost.getGhostRow()][ghost.getGhostCol() - 1].getTraversable()) {
            return false;
        } else if (ghost.getGhostDirection() == DIRECTION_LEFT && !cells[ghost.getGhostRow() - 1][ghost.getGhostCol()].getTraversable()) {
            return false;
        } else if (ghost.getGhostDirection() == DIRECTION_DOWN && !cells[ghost.getGhostRow()][ghost.getGhostCol() + 1].getTraversable()) {
            return false;
        }
        else {
            return true;
        }
    }

    // if the ghost can't move, changes the direction of the ghost
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
}
