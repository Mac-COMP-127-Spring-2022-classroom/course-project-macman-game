package macman;

import edu.macalester.graphics.GraphicsGroup;

public class Grid extends GraphicsGroup {
    protected int numRows, numCols;
    protected double size;
    protected Cell[][] cells;
    private Player player;
    private int playerRow = 11;
    private int playerCol = 11;
    private Ghost blinky, pinky, inky, clyde;

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
                    cell.addGraphics(new Coin(size / 6, size / 6));
                }

                this.add(cell.getGraphics());
                cells[i][j] = cell;
            }
        }

        cells[playerRow][playerCol].addGraphics(player);
        cells[10][10].addGraphics(blinky);
        cells[9][10].addGraphics(pinky);
        cells[8][10].addGraphics(inky);
        cells[7][10].addGraphics(clyde);
    }

    public void erase() {
        if (cells[playerRow][playerCol].getGraphics() != null) {
            cells[playerRow][playerCol].removeGraphics();
        }
    }

    private void move(int row, int col) {
        if (row >= numRows || col >= numCols) {
            // Pac-Man off screen
        } else if (!cells[row][col].getTraversable()) {
            // hit wall
            System.out.println("HIT WALL");
        } else {
            erase();

            playerCol = col;
            playerRow = row;
            cells[row][col].addGraphics(player);
        }

    }

    public void movePlayerRight() {
        move(playerRow + 1, playerCol);
    }

    public void movePlayerLeft() {
        move(playerRow - 1, playerCol);
    }

    public void movePlayerDown() {
        move(playerRow, playerCol + 1);
    }

    public void movePlayerUp() {
        move(playerRow, playerCol - 1);
    }
}
