// package macman;

// import java.awt.Color;

// import edu.macalester.graphics.CanvasWindow;

// /**
// * The game of MacMan.
// */
// public class MacManGame {
// private static final int CANVAS_WIDTH = 720;
// private static final int CANVAS_HEIGHT = 720;

// private CanvasWindow canvas;

// public MacManGame() {
// canvas = new CanvasWindow("MacMan", CANVAS_WIDTH, CANVAS_HEIGHT);
// canvas.setBackground(Color.BLACK);
// Grid grid = new Grid(18, 18, 40);
// canvas.add(grid);
// grid.setCenter(360, 360);
// canvas.draw();
// Player macman = new Player(0, 0);
// macman.addToCanvas(canvas);
// canvas.draw();
// }
// public static void main(String[] args) {
// new MacManGame();
// }
// }

package macman;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> d086afb35105a583656880a8793cfd1a88fbeaa9
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.KeyboardEvent;

/**
 * The game of Mac-Man.
 */
public class MacManGame {
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 720;
    private Grid grid;
    private List<Wall> walls;
    private CanvasWindow canvas;
    private Wall wall;
    private String[][] maze;
    private Player player;

    public MacManGame() {
        walls = new ArrayList<>();
        canvas = new CanvasWindow("mac-man", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        generateMaze();
<<<<<<< HEAD
        grid = new Grid(24, 24, 27, maze, canvas);
        canvas.add(grid);

        player = new Player(0, 0, 0, 0);

        grid.placePlayer(5, 10, player);

        canvas.onKeyDown(event -> {
            movePlayer(event);
        });

        canvas.animate(event -> {
            player.updatePosition();
        });

    }

    private void generateMaze() {
        maze = new String[24][24];
        maze[0] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B" };
        maze[1] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "P", "B" };
        maze[2] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[3] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[4] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[5] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[6] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[7] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[8] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[9] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[10] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[11] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[12] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[13] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[14] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[15] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[16] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[17] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[18] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[19] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[20] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[21] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[22] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[23] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B" };
    }

    public void movePlayer(KeyboardEvent event) {
        // animatePlayer();
        // if (event.getKey().toString().equals("RIGHT_ARROW"))
        //     animatePlayer();
    }

=======
        grid = new Grid(9, 10, 80, maze, canvas);
        canvas.add(grid);
        player = new Player(0, 0, 0, 0);
        

        canvas.onKeyDown(event -> {
            player.movePlayer(event);
        });
    }

    private void generateMaze() {
        maze = new String[9][10];
        maze[0] = new String[]{"C", "C", "X", "C", "X", "C", "X", "X", "C", "C"};
        maze[1] = new String[]{"C", "C", "X", "X", "C", "X", "X", "X", "X", "X"};
        maze[2] = new String[]{"C", "X", "X", "X", "X", "X", "X", "X", "X", "X"};
        maze[3] = new String[]{"C", "X", "X", "X", "X", "C", "P", "X", "X", "X"};
        maze[4] = new String[]{"C", "C", "X", "X", "X", "X", "X", "X", "X", "X"};
        maze[5] = new String[]{"X", "C", "C", "X", "X", "X", "X", "X", "X", "X"};
        maze[6] = new String[]{"X", "X", "C", "X", "X", "X", "X", "X", "X", "X"};
        maze[7] = new String[]{"C", "X", "C", "X", "C", "X", "X", "X", "X", "X"};
        maze[8] = new String[]{"X", "X", "C", "C", "X", "X", "X", "X", "X", "X"};
    }

>>>>>>> d086afb35105a583656880a8793cfd1a88fbeaa9
    public static void main(String[] args) {
        new MacManGame();
    }
}