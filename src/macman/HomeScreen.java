package macman;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

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
        titleImage.setScale(0.8);
        titleImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2.5);
        canvas.add(titleImage);
    }

    private void playButton() {
        CustomButton playButton = new CustomButton("START");
        playButton.setCenter(canvas.getWidth() / 2 - 100, canvas.getHeight() / 2 + 10);
        Image playImage = new Image("sprite-icons/play.png");
        playImage.setCenter(canvas.getWidth() / 2 - 100, canvas.getHeight() / 2 + 10);
        playImage.setScale(0.3);
        canvas.add(playImage);
        canvas.add(playButton);
        playButton.onClick(() -> {
            canvas.removeAll();
            game.playingScreen();
        });
    }

    private void quitButton() {
        CustomButton quitButton = new CustomButton("QUIT");
        quitButton.setCenter(canvas.getWidth() / 2 + 100, canvas.getHeight() / 2 + 10);
        Image quitImage = new Image("sprite-icons/quit.png");
        quitImage.setCenter(canvas.getWidth() / 2 + 100, canvas.getHeight() / 2 + 10);
        quitImage.setScale(0.3);
        canvas.add(quitImage);
        canvas.add(quitButton);
        quitButton.onClick(() -> canvas.closeWindow());
    }

    private void instructionsButton() {
        CustomButton instructionButton = new CustomButton("HOW TO PLAY");
        instructionButton.setCenter(canvas.getWidth() / 2 + 10, canvas.getHeight() / 2 + 70);
        Image instructionImage = new Image("sprite-icons/how-to.png");
        instructionImage.setCenter(canvas.getWidth() / 2 + 10, canvas.getHeight() / 2 + 70);
        instructionImage.setScale(0.2);
        canvas.add(instructionImage);
        canvas.add(instructionButton);
        instructionButton.onClick(() -> {
            canvas.removeAll();
            instructions();
        });
    }

    private void instructions() {
        Image instructionsText = new Image("sprite-icons/instructions.png");
        instructionsText.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2);
        instructionsText.setScale(0.3);
        canvas.add(instructionsText);
        returnButton();
    }

    private void returnButton() {
        CustomButton returnButton = new CustomButton("RETURN TO WELCOME SCREEN");
        returnButton.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2 + 80);
        Image returnImage = new Image("sprite-icons/return.png");
        returnImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2 + 80);
        returnImage.setScale(0.3);
        canvas.add(returnImage);
        canvas.add(returnButton);
        returnButton.onClick(() -> {
            canvas.removeAll();
            homeScreen();
        });
    }

    private void creditsButton() {
        CustomButton creditButton = new CustomButton("CREDITS");
        creditButton.setCenter(canvas.getWidth() / 2 + 10, canvas.getHeight() / 2 + 100);
        Image creditImage = new Image("sprite-icons/credits.png");
        creditImage.setCenter(canvas.getWidth() / 2 + 10, canvas.getHeight() / 2 + 100);
        creditImage.setScale(0.2);
        canvas.add(creditImage);
        canvas.add(creditButton);
        creditButton.onClick(() -> {
            canvas.removeAll();
            creditsScreen();
        });
    }

    private void creditsScreen() {
        Image credits = new Image("sprite-icons/credits-message.png");
        credits.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2 - 50);
        credits.setScale(0.3);
        canvas.add(credits);
        returnButton();
    }

    public void winMessage() {
        canvas.removeAll();
        Image winImage = new Image("sprite-icons/win-message.png");
        winImage.setScale(0.8);
        winImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2.5);
        canvas.add(winImage);
        canvas.draw();
        canvas.pause(3000);
        canvas.removeAll();
    }

    public void loseMessage() {
        canvas.removeAll();
        Image loseImage = new Image("sprite-icons/lose-message.png");
        loseImage.setScale(0.8);
        loseImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2.5);
        canvas.add(loseImage);
        canvas.draw();
        canvas.pause(3000);
        canvas.removeAll();
    }
}
