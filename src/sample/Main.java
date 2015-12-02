package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        // Attempt to add music
//        String musicPath = "pub.mp3";
//        File musicFile = new File(musicPath);
//        Media media = new Media(musicFile.toURI().toASCIIString());
//        System.out.println(media.getSource());
//        MediaPlayer player = new MediaPlayer(media);
//        player.play();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = (Parent) loader.load();
        Controller control = loader.getController();
        control.setPrevStage(primaryStage);
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
