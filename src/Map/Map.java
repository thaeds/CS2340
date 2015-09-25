package Map;/**
 * Created by Sergey on 9/22/15.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Map extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
        primaryStage.setTitle("M.U.L.E.");
        primaryStage.setResizable(false);
        Scene s = new Scene(root, 585, 400);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
