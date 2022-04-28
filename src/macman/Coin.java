package macman;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

public class Coin extends GraphicsGroup {
    private Ellipse coin;
    // private int numOfCoins = 20;
    
    public Coin(double ballWidth, double ballHeight) {
        super();
        coin = new Ellipse(0, 0, ballWidth, ballHeight);
        coin.setFillColor(Color.ORANGE);
        coin.setStrokeColor(Color.GREEN);
        this.add(coin);
    }
    // public int getCoins() {
    //     return numOfCoins;
    // }
    // public void setCoins(int coin) {
    //     numOfCoins = coin;
    // }
}
