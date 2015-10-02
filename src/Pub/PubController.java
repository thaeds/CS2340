package Pub;

import Map.Town;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by Alex on 10/2/15.
 */
public class PubController {
        private void setMouseOver() {
            ColorAdjust ca = new ColorAdjust();
            ca.setBrightness(.5);
        }
    @FXML
    private Pane background = null;
    @FXML
    private TextField pubmsg = null;
    @FXML
    public void initialize(){
        System.out.println("PubController Initialized");
        int round = 1;
        double time = 10;
        int bonus = (int)(round * rng.nextDouble() * time);
//        currentPlayer.setBalance(currentPlayer.getBalance() + bonus);
        pubmsg = new TextField();
        pubmsg.setText("You earned " + bonus + " dollars from gambling!");
        Pane myPane = null;
        FXMLLoader ldr = new FXMLLoader();
        try {
            // I have no idea why I can't get this to work
            myPane = ldr.load(getClass().getResource("pub.fxml"));
        } catch (Exception e) {
            System.out.println("Exception loading pub.fxml");
            return;
        }
        Image pub = new Image(getClass().getResource("pubinside.jpg").toExternalForm());
        ImagePattern img = new ImagePattern(pub);
        BackgroundFill bgFill = new BackgroundFill(img, new CornerRadii(0), new Insets(0,0,0,0));
        Background bg = new Background(bgFill);
        background.setBackground(bg);
//        outerWindow.setStyle("-fx-background-image: url('" + "pubinside.jpg" + "')");

        Scene scene = new Scene(myPane);
        prevStage = (Stage) background.getScene().getWindow();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(a -> {
            Platform.exit();
            System.exit(0);
        });
        prevStage.close();
        stage.show();
    }

    private Stage prevStage = null;
    Random rng = new Random();
}
