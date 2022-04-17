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
        cells = new GameElements[9][10];

        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                String type = maze[i][j];
                System.out.println(type);
                GameElements element = null;
                if (type.equals("X")) {
                    element = new Wall(i * size, j * size + 25, size, size / 3);
                } else if (type.equals("P")) {
                    element = new Player(i * size + 25, j * size + 25, size / 3, size / 3);
                } else if (type.equals("C")) {
                    element = new Coin(i * size + 25, j * size + 25, size / 4, size / 4);
                }
                if (element != null) {
                    canvas.add(element.getGraphics());
                    cells[i][j] = element;
                }
            }  
        }
    }
}
