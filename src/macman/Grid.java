// package macman;

// import edu.macalester.graphics.GraphicsGroup;

// public class Grid extends GraphicsGroup {

// protected int num_rows, num_cols;

// protected double size;

// protected Cell[][] cells;

// public Grid(int num_rows, int num_cols, double size) {
// this.num_rows = num_rows;
// this.num_cols = num_cols;
// this.size = size;
// createGrid();
// }

// private void createGrid() {
// cells = new Cell[num_rows][num_cols];

// double x = 0;
// double y = 0;
// for (int i = 0; i < num_rows; i++) {
// for (int j = 0; j < num_cols; j++) {
// Cell cell = new Cell(size);
// cell.getGraphics().setPosition(x, y);
// cells[i][j] = cell;
// this.add(cell.getGraphics());
// x += cell.getSize();
// }
// x = 0;
// y += cells[i][0].getSize();
// }
// }
// }


package macman;

import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;

public class Grid extends GraphicsGroup {
    protected int num_rows, num_cols;
    protected double size;
    protected GameElements[][] cells;
    private CanvasWindow canvas;

    public Grid(int num_rows, int num_cols, int size, String[][] maze, CanvasWindow canvas) {
        this.num_rows = num_rows;
        this.num_cols = num_cols;
        this.size = size;
        canvas.setBackground(Color.BLACK);
        this.canvas = canvas;
        createGrid(maze);
    }

    public void createGrid(String[][] maze) {
        cells = new GameElements[num_rows][num_cols];
        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                String type = maze[i][j];
                GameElements element = null;
                if (type.equals("B")) {
                    element = new Wall(i * size, j * size, size, size);
                } else if (type.equals("P")) {
                    element = new Player(i * size + 14, j * size + 11, size / 2.5, size / 2.5);
                } else if (type.equals("C")) {
                    element = new Coin(i * size + 11, j * size + 11, size / 6, size / 6);
                } if (element != null) {
                    canvas.add(element.getGraphics());
                    cells[i][j] = element;
                }
            }
        }
    }

    // public GameElements[][] getCells() {
    //     return cells;
    // }

    public void placePlayer(int i, int j, Player p) {
        GameElements cell = cells[i][j];
        p.getGraphics().setCenter(cell.getGraphics().getCenter().getX(), cell.getGraphics().getCenter().getY());
    }
}
