package macman;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class Player implements GameElements {
    private Image playerIcon;
    private double centerX;
    private double centerY;

    public Player(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;

        playerIcon = new Image("sprite-icons/macman.png");
        playerIcon.setMaxWidth(30);
        playerIcon.setMaxHeight(30);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(playerIcon);
    }
}
