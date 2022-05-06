package macman;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import java.awt.Color;

public class HomeScreen {
    private CanvasWindow canvas;
    private MacManGame game;

    public HomeScreen(CanvasWindow canvas, MacManGame game) {
        this.canvas = canvas;
        this.game = game;
    }

    public void homeScreen() {
        titleImage();
        playButton();
        quitButton();
        instructionsButton();
        creditsButton();
    }

    private void titleImage() {
        Image titleImage = new Image("sprite-icons/title.png");
        titleImage.setMaxWidth(400);
        titleImage.setMaxHeight(100);
        titleImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2.5);
        canvas.add(titleImage);
    }

    private void playButton() {
        CustomButton playButton = new CustomButton("START");
        playButton.setCenter(canvas.getWidth() / 2 - 100, canvas.getHeight() / 2 + 10);
        GraphicsText text = new GraphicsText("START");
        text.setFont("Impact", FontStyle.PLAIN, 20);
        text.setFillColor(Color.WHITE);
        text.setCenter(canvas.getWidth() / 2 - 100, canvas.getHeight() / 2 + 10);
        canvas.add(playButton);
        canvas.add(text);
        playButton.onClick(() -> {
            canvas.removeAll();
            game.playingScreen();
        });
    }

    private void quitButton() {
        CustomButton quitButton = new CustomButton("QUIT");
        quitButton.setCenter(canvas.getWidth() / 2 + 100, canvas.getHeight() / 2 + 10);
        GraphicsText text = new GraphicsText("QUIT");
        text.setFont("Impact", FontStyle.PLAIN, 20);
        text.setFillColor(Color.WHITE);
        text.setCenter(canvas.getWidth() / 2 + 100, canvas.getHeight() / 2 + 10);
        canvas.add(quitButton);
        canvas.add(text);
        quitButton.onClick(() -> canvas.closeWindow());
    }

    private void instructionsButton() {
        CustomButton instructionButton = new CustomButton("HOW TO PLAY");
        instructionButton.setCenter(canvas.getWidth() / 2 + 10, canvas.getHeight() / 2 + 50);
        GraphicsText text = new GraphicsText("HOW TO PLAY");
        text.setFont("Courier New", FontStyle.PLAIN, 20);
        text.setFillColor(Color.WHITE);
        text.setCenter(canvas.getWidth() / 2 + 10, canvas.getHeight() / 2 + 50);
        canvas.add(instructionButton);
        canvas.add(text);
        instructionButton.onClick(() -> {
            canvas.removeAll();
            instructions();
        });
    }

    private void instructions() {
        GraphicsText instructionsText = new GraphicsText(
            "Use your UP, DOWN, RIGHT, and LEFT\narrow keys to move the player!\nTry to collect all of the coins without losing all\nthree of your lives!");
        instructionsText.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2);
        instructionsText.setFont("Courier New", FontStyle.PLAIN, 20);
        instructionsText.setFillColor(Color.WHITE);
        instructionsText.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2);
        canvas.add(instructionsText);
        returnButton();
    }

    private void returnButton() {
        CustomButton returnButton = new CustomButton("RETURN TO WELCOME SCREEN");
        returnButton.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2 + 80);
        GraphicsText returnStatement = new GraphicsText("RETURN TO WELCOME SCREEN");
        returnStatement.setFont("Courier New", FontStyle.PLAIN, 20);
        returnStatement.setFillColor(Color.ORANGE);
        returnStatement.setCenter(canvas.getWidth() / 2 + 5, canvas.getHeight() / 2 + 80);
        canvas.add(returnButton);
        canvas.add(returnStatement);
        returnButton.onClick(() -> {
            canvas.removeAll();
            homeScreen();
        });
    }

    private void creditsButton() {
        CustomButton creditButton = new CustomButton("CREDITS");
        creditButton.setCenter(canvas.getWidth() / 2 + 10, canvas.getHeight() / 2 + 80);
        GraphicsText creditText = new GraphicsText("CREDITS");
        creditText.setFont("Courier New", FontStyle.PLAIN, 20);
        creditText.setFillColor(Color.WHITE);
        creditText.setCenter(canvas.getWidth() / 2 + 10, canvas.getHeight() / 2 + 80);
        canvas.add(creditButton);
        canvas.add(creditText);
        canvas.add(creditButton);
        creditButton.onClick(() -> {
            canvas.removeAll();
            creditsScreen();
        });
    }

    private void creditsScreen() {
        GraphicsText credits = new GraphicsText(
            "THANK YOU FOR PLAYING!\n\n\n        CREDITS:\n    Sarah Sylvester\n   Arnika Abeysekera");
        credits.setFont("Courier New", FontStyle.PLAIN, 20);
        credits.setFillColor(Color.WHITE);
        credits.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2 - 50);
        canvas.add(credits);
        returnButton();
    }

    public void winMessage() {
        canvas.removeAll();
        Image winImage = new Image("sprite-icons/win-message.png");
        winImage.setMaxWidth(400);
        winImage.setMaxHeight(100);
        winImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2.5);
        canvas.add(winImage);
        canvas.draw();
        canvas.pause(3000);
        canvas.removeAll();
    }

    public void loseMessage() {
        canvas.removeAll();
        Image loseImage = new Image("sprite-icons/lose-message.png");
        loseImage.setMaxWidth(400);
        loseImage.setMaxHeight(100);
        loseImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2.5);
        canvas.add(loseImage);
        canvas.draw();
        canvas.pause(3000);
        canvas.removeAll();
    }
}
