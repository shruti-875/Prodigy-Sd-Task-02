package org.example.guessinggame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Random;

public class HelloController {
    private int targetNumber;
    private int attempts;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Label attemptsLabel;

    @FXML
    private TextField guessInput;

    @FXML
    private Button guessButton;

    public void initialize() {
        Random random = new Random();
        targetNumber = random.nextInt(10) + 1;
        attempts = 0;
    }

    @FXML
    protected void onGuessButtonClick() {
        String input = guessInput.getText();
        try {
            int guess = Integer.parseInt(input);
            attempts++;
            if (guess < targetNumber) {
                feedbackLabel.setText("Too low! Try again.");
            } else if (guess > targetNumber) {
                feedbackLabel.setText("Too high! Try again.");
            } else {
                feedbackLabel.setText("Correct! You've guessed the number.");
                guessButton.setDisable(true);
            }
            attemptsLabel.setText("Attempts: " + attempts);
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Please enter a valid number.");
        }
        guessInput.clear();
    }
}