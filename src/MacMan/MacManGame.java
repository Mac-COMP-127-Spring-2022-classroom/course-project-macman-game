package MacMan;

import edu.macalester.graphics.CanvasWindow;

/**
 * The game of MacMan.
 */
public class MacManGame {
    private static final int CANVAS_WIDTH = 200;
    private static final int CANVAS_HEIGHT = 200;

    private CanvasWindow canvas;

    public MacManGame() {
        canvas = new CanvasWindow("MacMan", CANVAS_WIDTH, CANVAS_HEIGHT);


    }
    public static void main(String[] args) {
        new MacManGame();
    }
}