package macman;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Ghost extends GraphicsGroup {
    private Image ghostIcon;
    private double initialAngle;
    private double initialSpeed;
    private double xVelocity;
    private double yVelocity;

    public Ghost(double ghostWidth, 
        double ghostHeight, 
        String ghostName,
        double initialSpeed,
        double initialAngle) {
        super();
        ghostIcon = new Image("sprite-icons/" + ghostName + ".png");
        ghostIcon.setMaxWidth(ghostWidth);
        ghostIcon.setMaxHeight(ghostHeight);

        this.add(ghostIcon);
        this.initialSpeed = initialSpeed;
        this.initialAngle = initialAngle;

        double initialAngleRadians = Math.toRadians(this.initialAngle);
        this.xVelocity = this.initialSpeed * Math.cos(initialAngleRadians);
        this.yVelocity = this.initialSpeed * -1 * (Math.sin(initialAngleRadians));
    }

    public boolean updatePosition(double dt) {
        double newXPosition = this.getCenter().getX() + xVelocity * dt;
        double newYPosition = this.getCenter().getY() + yVelocity * dt;

        if (newYPosition >= 365 || newYPosition <= -280) {
            yVelocity *= -1;
            this.setPosition(newXPosition, newYPosition);
        } else if (newXPosition >= 420 || newXPosition <= -240) {
            xVelocity *= -1;
            this.setPosition(newXPosition, newYPosition);
        }
        this.setCenter(newXPosition, newYPosition);
        return true;
    }
}
