package macman;

import edu.macalester.graphics.CanvasWindow;

/**
 * The game of MacMan.
 */
public class MacManGame {
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 720;

    private CanvasWindow canvas;

    public MacManGame() {
        canvas = new CanvasWindow("MacMan", CANVAS_WIDTH, CANVAS_HEIGHT);
        Grid grid = new Grid(18, 18, 40);
        canvas.add(grid);
        grid.setCenter(360, 360);
        canvas.draw();
    }
    public static void main(String[] args) {
        new MacManGame();
    }
}