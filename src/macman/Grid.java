package macman;

import edu.macalester.graphics.GraphicsGroup;
import java.util.Random;

public class Grid extends GraphicsGroup {
    protected int numRows, numCols;
    protected double size;
    protected Cell[][] cells;
    private Player player;
    private int playerRow = 11;
    private int playerCol = 11;
    private int ghostRow = 10; // refactor here to be applicable to all ghosts
    private int ghostCol = 10;
    private Ghost blinky, pinky, inky, clyde;
    private Random random;
    private int direction;

    private final int DIRECTION_UP = 0;
    private final int DIRECTION_DOWN = 1;
    private final int DIRECTION_LEFT = 2;
    private final int DIRECTION_RIGHT = 3;

    public Grid(int numRows, int numCols, int size, String[][] maze, Player player, Ghost blinky, Ghost pinky,
        Ghost inky, Ghost clyde) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.size = size;
        this.player = player;
        this.blinky = blinky;
        this.pinky = pinky;
        this.inky = inky;
        this.clyde = clyde;
        createGrid(maze);

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
        cells[10][10].addGhost(blinky);
        cells[9][10].addGhost(pinky);
        cells[8][10].addGhost(inky);
        cells[7][10].addGhost(clyde);
    }

    private void movePlayer(int row, int col) {
        if (row >= numRows || col >= numCols) {
            // Pac-Man off screen
        } else if (!cells[row][col].getTraversable()) {
            // hit wall
            System.out.println("HIT WALL");
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
        if (direction == DIRECTION_DOWN && canGhostMove(ghost)) {
            cells[ghostRow][ghostCol].removeGhost();
            ghostCol = ghostCol + 1;
            cells[ghostRow][ghostCol].addGhost(ghost);
        }
        if (direction == DIRECTION_UP && canGhostMove(ghost)) {
            cells[ghostRow][ghostCol].removeGhost();
            ghostCol = ghostCol - 1;
            cells[ghostRow][ghostCol].addGhost(ghost);
        }
        if (direction == DIRECTION_LEFT && canGhostMove(ghost)) {
            cells[ghostRow][ghostCol].removeGhost();
            ghostRow = ghostRow - 1;
            cells[ghostRow][ghostCol].addGhost(ghost);
        }
        if (direction == DIRECTION_RIGHT && canGhostMove(ghost)) {
            cells[ghostRow][ghostCol].removeGhost();
            ghostRow = ghostRow + 1;
            cells[ghostRow][ghostCol].addGhost(ghost);
        }
        else {
            changeGhostDirection(ghost);
        }
    }

    // returns false if there is a wall one cell in front in the ghost's current direction
    private boolean canGhostMove(Ghost ghost) {
        if (direction == DIRECTION_RIGHT && !cells[ghostRow + 1][ghostCol].getTraversable()) {
            return false;
        } else if (direction == DIRECTION_UP && !cells[ghostRow][ghostCol - 1].getTraversable()) {
            return false;
        } else if (direction == DIRECTION_LEFT && !cells[ghostRow - 1][ghostCol].getTraversable()) {
            return false;
        } else if (direction == DIRECTION_DOWN && !cells[ghostRow][ghostCol + 1].getTraversable()) {
            return false;
        }
        else {
            return true;
        }
    }

    // if the ghost can't move, changes the direction of the ghost
    private void changeGhostDirection(Ghost ghost) {
        if (direction == DIRECTION_RIGHT && !canGhostMove(ghost)) {
            while (direction == DIRECTION_RIGHT) {
                chooseRandomDirection();
            }
        } if (direction == DIRECTION_UP && !canGhostMove(ghost)) {
            while (direction == DIRECTION_UP) {
                chooseRandomDirection();
            }        
        } if (direction == DIRECTION_LEFT && !canGhostMove(ghost)) {
            while (direction == DIRECTION_LEFT) {
                chooseRandomDirection();
            }        
        } if (direction == DIRECTION_DOWN && !canGhostMove(ghost)) {
            while (direction == DIRECTION_DOWN) {
                chooseRandomDirection();
            }    
        }    
    }

    public void chooseRandomDirection() {
        random = new Random();
        direction = random.nextInt(4);
    }
}
