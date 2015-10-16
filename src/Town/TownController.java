package Town;

import Map.Town;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import sample.Context;
import sample.Player;

import java.util.*;

/**
 * Created by Alex on 10/2/15.
 */
public class TownController {
        private void setMouseOver() {
            ColorAdjust ca = new ColorAdjust();
            ca.setBrightness(.5);
            for (Node n : buildings.getChildren()) {
                n.setOnMouseEntered(a -> {
                    Shadow s = new Shadow();
                    if (n.getEffect() != null && n.getEffect().getClass().equals(s.getClass())) {
                    }else {
                        n.setEffect(ca);
                    }
                });
                n.setOnMouseExited(a -> {
                    if (n.getEffect().equals(ca)) {
                        n.setEffect(null);
                    }
                });
            }
        }
    @FXML
    private Button enterPub;
    @FXML
    private GridPane buildings;
    @FXML
    private Button enterStore;
    public void initialize(){
        enterPub.setOnMouseClicked(a ->
        enterPub()
        );
        enterStore.setOnMouseClicked(a -> {
            System.out.println("Entering Store");
            Context.loadStore();
            Stage curStage = (Stage)townWindow.getScene().getWindow();
            curStage.close();
        });
    }
    private Stage prevStage = null;
    @FXML
    private Pane townWindow;
    Random rng = new Random();
    private void enterPub() {
        System.out.println("Entering Pub");
        Context.loadPub();
        Stage curStage = (Stage)townWindow.getScene().getWindow();
        curStage.close();
//        int round = 1;
//        double time = 10;
//        int bonus = (int)(round * rng.nextDouble() * time);
//        currentPlayer.setBalance(currentPlayer.getBalance() + bonus);
//        pubmsg = new TextField();
//        pubmsg.setText("You earned " + bonus + " dollars from gambling!");
//        Pane myPane = null;
//        FXMLLoader ldr = new FXMLLoader();
//        try {
//            // I have no idea why I can't get this to work
//            myPane = ldr.load(getClass().getResource("pub.fxml"));
//        } catch (Exception e) {
//            System.out.println("Exception loading pub.fxml");
//            return;
//        }
//        Image pub = new Image(getClass().getResource("pubinside.jpg").toExternalForm());
//        ImagePattern img = new ImagePattern(pub);
//        BackgroundFill bgFill = new BackgroundFill(img, new CornerRadii(0), new Insets(0,0,0,0));
//        Background bg = new Background(bgFill);
//        background.setBackground(bg);
////        outerWindow.setStyle("-fx-background-image: url('" + "pubinside.jpg" + "')");
//
//        Scene scene = new Scene(myPane);
//        prevStage = (Stage) townWindow.getScene().getWindow();
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setOnCloseRequest(a -> {
//            Platform.exit();
//            System.exit(0);
//        });
//        prevStage.close();
//        stage.show();
    }

}