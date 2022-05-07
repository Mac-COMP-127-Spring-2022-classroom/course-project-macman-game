package macman;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

/**
 * Represents each non-playing screen of the game, such as the home screen and the win/lose screens.
 */
public class HomeScreen {
    private CanvasWindow canvas;
    private MacManGame game;

    /**
     * Initializes an instance of the Mac-Man home screen.
     */
    public HomeScreen(CanvasWindow canvas, MacManGame game) {
        this.canvas = canvas;
        this.game = game;
    }

    /**
     * Creates the main home screen with all of its elements: the title image and play, quit, how-to and
     * credits buttons.
     */
    public void homeScreen() {
        titleImage();
        playButton();
        quitButton();
        instructionsButton();
        creditsButton();
    }

    /**
     * Creates the title image to be added to the home screen.
     */
    private void titleImage() {
        Image titleImage = new Image("sprite-icons/title.png");
        titleImage.setScale(0.8);
        titleImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2.5);
        canvas.add(titleImage);
    }

    /**
     * Creates a "play" button that when clicked, enters the playing screen and starts the game.
     */
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

    /**
     * Creates a "quit" button that when clicked, exits out and closes the game.
     */
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

    /**
     * Creates the "how to play" screen that displays both the game's instructions, and a button to
     * return to the main home screen.
     */
    private void instructionsScreen() {
        Image instructionsText = new Image("sprite-icons/instructions.png");
        instructionsText.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2);
        instructionsText.setScale(0.3);
        canvas.add(instructionsText);
        returnButton();
    }

    /**
     * Create a "how to play" button that when clicked, enters the "how to play" screen.
     */
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
            instructionsScreen();
        });
    }

    /**
     * Creates a "return" button that when clicked, returns the user to the main home screen.
     */
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

    /**
     * Creates the "credits" screen that displays credits to the creators of the game, and a button to
     * return to the main home screen.
     */
    private void creditsScreen() {
        Image credits = new Image("sprite-icons/credits-message.png");
        credits.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2 - 50);
        credits.setScale(0.3);
        canvas.add(credits);
        returnButton();
    }

    /**
     * Create a "credits" button that when clicked, enters the "credits" screen.
     */
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

    /**
     * Creates a "win" screen that displays the "you win!" message.
     */
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

    /**
     * Creates a "lose" screen that displays the "you lose" message.
     */
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
