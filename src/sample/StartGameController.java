package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Map.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Sergey on 9/24/15.
 */
public class StartGameController implements Initializable {

    Stage prevStage;

    /**
     * Sets previous stage
     */
    public void setPrevStage(Stage stage){
        this.prevStage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Starts game
     *
     * @param event triggers game start
     */
    public void startGame(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Shop Management");
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("../Map/map.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        Context.map = scene;

        prevStage.close();

        stage.show();
    }

}
