// package macman;

// import edu.macalester.graphics.CanvasWindow;
// import edu.macalester.graphics.Image;

// public class Player implements GameElements {
// private Image playerIcon;
// private double centerX;
// private double centerY;

// public Player(double centerX, double centerY) {
// this.centerX = centerX;
// this.centerY = centerY;

// playerIcon = new Image("sprite-icons/macman.png");
// playerIcon.setMaxWidth(30);
// playerIcon.setMaxHeight(30);
// playerIcon.setCenter(centerX, centerY);
// }

// public void addToCanvas(CanvasWindow canvas) {
// canvas.add(playerIcon);
// }
// }

package macman;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.events.KeyboardEvent;

public class Player extends GameElements {
    private Image playerIcon;
    private double xPosition;
    private double yPosition;
    private double initialAngleInRadians;
    private double xVelocity;
    private double yVelocity;

    private static final double SPEED = 7;


    public Player(double xPosition, double yPosition, double playerWidth, double playerHeight) {
        xPosition = this.xPosition;
        yPosition = this.yPosition;
        
        playerIcon = new Image("sprite-icons/macman.png");
        playerIcon.setMaxWidth(playerWidth);
        playerIcon.setMaxHeight(playerHeight);
        playerIcon.setCenter(xPosition, yPosition);

        initialAngleInRadians = Math.toRadians(0);
        // xVelocity = SPEED * Math.cos(initialAngleInRadians);
        // yVelocity = SPEED * -(Math.sin(initialAngleInRadians));
        xVelocity = 30;
        yVelocity = 0;

        this.graphics.add(playerIcon);
        
    }

    public void updatePosition() {
        xPosition += xVelocity;
        yPosition += yVelocity;
        playerIcon.setCenter(xPosition, yPosition);
    }

    public boolean canMove() {
        return false;
    }

    public boolean isEnd() {
        return false;
    }
}
