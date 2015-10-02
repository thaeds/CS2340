package Town;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Town.TownController;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("town.fxml"));
        Parent root = (Parent) loader.load();
        TownController control = loader.getController();
        primaryStage.setTitle("M.U.L.E.");
        primaryStage.setResizable(false);
        Scene s = new Scene(root, 800, 480);
        primaryStage.setScene(s);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
