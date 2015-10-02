package Town;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller;

/**
 * Created by Sergey on 10/2/15.
 */
public class MainTown extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("town.fxml"));
        Parent root = (Parent) loader.load();
        Controller control = loader.getController();
        control.setPrevStage(primaryStage);
        primaryStage.setTitle("M.U.L.E.");
        primaryStage.setResizable(false);
        Scene s = new Scene(root, 580, 400);
        primaryStage.setScene(s);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
