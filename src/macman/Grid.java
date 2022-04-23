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
    // private int direction;
    private Ghost blinky, pinky, inky, clyde;
    private List<Ghost> ghosts;

    private final int DIRECTION_UP = 0;
    private final int DIRECTION_DOWN = 1;
    private final int DIRECTION_LEFT = 2;
    private final int DIRECTION_RIGHT = 3;

    public Grid(int numRows, int numCols, int size, String[][] maze, Player player, Ghost blinky, Ghost pinky, Ghost inky, Ghost clyde) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.size = size;
        this.player = player;
        this.blinky = blinky;
        this.pinky = pinky;
        this.inky = inky;
        this.clyde = clyde;
        addGhosts();
        createGrid(maze);
    }

    public void addGhosts() {
        ghosts = new ArrayList<>();
        ghosts.add(blinky);
        ghosts.add(pinky);
        ghosts.add(inky);
        ghosts.add(clyde);
    }

    public void createGrid(String[][] maze) {
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
        cells[playerRow][playerCol].addPlayer(player);
        for (Ghost ghost : ghosts) {
            cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            ghost.chooseRandomDirection();   
        }
    }

    private void movePlayer(int row, int col) {
        if (row >= numRows || col >= numCols) {
            // Pac-Man off screen
        } else if (!cells[row][col].getTraversable()) {
            // hit wall
        } else {
            erase();

            playerCol = col;
            playerRow = row;
            cells[row][col].addPlayer(player);
        }
    }

    public void erase() {
        if (cells[playerRow][playerCol].getGraphics() != null) {
            cells[playerRow][playerCol].removeCoin();
        }
        cells[playerRow][playerCol].removePlayer();
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
            if (ghost.getGhostDirection() == DIRECTION_UP) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostCol(ghost.getGhostCol() - 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            }
            if (ghost.getGhostDirection() == DIRECTION_LEFT) {
                cells[ghost.getGhostRow()][ghost.getGhostCol()].removeGhost(ghost);
                ghost.setGhostRow(ghost.getGhostRow() - 1);
                cells[ghost.getGhostRow()][ghost.getGhostCol()].addGhost(ghost);
            }
            if (ghost.getGhostDirection() == DIRECTION_RIGHT) {
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
        if (ghost.getGhostDirection() == DIRECTION_RIGHT && !canGhostMove(ghost)) {
            while (ghost.getGhostDirection() == DIRECTION_RIGHT) {
                ghost.chooseRandomDirection();
            }
        } if (ghost.getGhostDirection() == DIRECTION_UP && !canGhostMove(ghost)) {
            while (ghost.getGhostDirection() == DIRECTION_UP) {
                ghost.chooseRandomDirection();
            }        
        } if (ghost.getGhostDirection() == DIRECTION_LEFT && !canGhostMove(ghost)) {
            while (ghost.getGhostDirection() == DIRECTION_LEFT) {
                ghost.chooseRandomDirection();
            }        
        } if (ghost.getGhostDirection() == DIRECTION_DOWN && !canGhostMove(ghost)) {
            while (ghost.getGhostDirection() == DIRECTION_DOWN) {
                ghost.chooseRandomDirection();
            }    
        }    
    }
}
