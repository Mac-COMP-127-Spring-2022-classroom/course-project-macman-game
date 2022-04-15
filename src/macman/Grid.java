package macman;

import edu.macalester.graphics.GraphicsGroup;

public class Grid extends GraphicsGroup {

    protected int num_rows, num_cols;

    protected double size;

    protected Cell[][] cells;

    public Grid(int num_rows, int num_cols, double size) {
        this.num_rows = num_rows;
        this.num_cols = num_cols;
        this.size = size;
        createGrid();
    }

    private void createGrid() {
        cells = new Cell[num_rows][num_cols];

        double x = 0;
        double y = 0;
        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                Cell cell = new Cell(size);
                cell.getGraphics().setPosition(x, y);
                cells[i][j] = cell;
                this.add(cell.getGraphics());
                x += cell.getSize();
            }
            x = 0;
            y += cells[i][0].getSize();
        }
    }
}
