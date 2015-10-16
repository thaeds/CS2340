package Pub;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import sample.Context;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import sample.Player;

import java.util.Random;

/**
 * Created by Sergey on 10/2/15.
 */
public class Pub {
    @FXML
    private Pane pubWindow;
    @FXML
    private ImageView v = new ImageView();
    @FXML
    private Text pubMessage;
    @FXML
    public void initialize() {
        Player p = Context.getCurrentPlayer();
        pubMessage.setText("You won " + gamble(p) + " by gambling!");
    }
    @FXML
    private void exitPub() {
        System.out.println("clicked on exit pub");
        Context.loadMap();
        Stage curStage = (Stage)pubWindow.getScene().getWindow();
        curStage.close();
    }
    private int gamble(Player p) {
        Random rng = new Random();
        int roundBonus = Context.getCurrentRound() % 4 + 50;
        int time = Context.getRemainingTime();
        int timeBonus = 0;
        if (time < 12) timeBonus = 50;
        else if (time < 25) timeBonus = 100;
        else if (time < 37) timeBonus = 150;
        else timeBonus = 200;
        int winnings = Math.min(250, (int) (rng.nextDouble()*roundBonus*timeBonus));
        p.setBalance(p.getBalance() + winnings);
        return winnings;
    }
}
