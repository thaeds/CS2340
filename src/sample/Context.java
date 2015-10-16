package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Sergey on 9/25/15.
 */
public class Context {
    private static ArrayList<Player> players;
    private static Player currentPlayer;
    private Stage prevStage;
    public static Scene map;
    public static int currentRound = 1;
    public static Player getCurrentPlayer() {
        return players.get(0);
    }
    public static int getCurrentRound() {
        return currentRound;
    }
    public static int getRemainingTime() {
        return 140;
    }
    public static void setCurrentPlayer(Player p) {
        System.out.println("Current Player" + p.toString());
        currentPlayer = p;
    }
    public static void loadMap() {
        FXMLLoader ldr = null;
        Parent root;
        System.out.println("loading map");
        try {
            ldr = new FXMLLoader(Context.class.getResource("../Map/map.fxml"));
            root = (Parent) ldr.load();
            Stage primaryStage = new Stage();
            Scene q = new Scene(root, 580, 400);
            primaryStage.setScene(q);
            primaryStage.show();
        } catch(Exception e) {
            System.out.println("Exception caught");
        }
    }
    public static void loadTown() {
        FXMLLoader ldr = null;
        Parent root;
        //Controller control = loader.getController();
        //control.setPrevStage(primaryStage);
        Pane myPane = null;
        try {
            ldr = new FXMLLoader(Context.class.getResource("../Town/town.fxml"));
            root = (Parent) ldr.load();
            Stage primaryStage = new Stage();
            primaryStage.setTitle("M.U.L.E.");
            primaryStage.setResizable(false);
            Scene q = new Scene(root, 580, 400);
            primaryStage.setScene(q);
            primaryStage.show();
//            s.close();
        } catch (Exception e) {
            System.out.println("Can't load town");
            return;
        }
    }
    public static void loadPub() {
        FXMLLoader ldr = null;
        Parent root;
        //Controller control = loader.getController();
        //control.setPrevStage(primaryStage);
        Pane myPane = null;
        try {
            ldr = new FXMLLoader(Context.class.getResource("../Pub/pub.fxml"));
            root = (Parent) ldr.load();
            Stage primaryStage = new Stage();
            primaryStage.setTitle("M.U.L.E.");
            primaryStage.setResizable(false);
            Scene q = new Scene(root, 580, 400);
            primaryStage.setScene(q);
            primaryStage.show();
//          s.close();
        } catch (Exception e) {
            System.out.println("Can't load pub");
            return;
        }
    }
    public static void loadStore() {
        FXMLLoader ldr = null;
        Parent root;
        //Controller control = loader.getController();
        //control.setPrevStage(primaryStage);
        Pane myPane = null;
        try {
            ldr = new FXMLLoader(Context.class.getResource("../Store/store.fxml"));
            root = (Parent) ldr.load();
            Stage primaryStage = new Stage();
            primaryStage.setTitle("M.U.L.E.");
            primaryStage.setResizable(false);
            Scene q = new Scene(root, 580, 400);
            primaryStage.setScene(q);
            primaryStage.show();
//          s.close();
        } catch (Exception e) {
            System.out.println("Can't load Store");
            return;
        }
    }
    public static void setPlayers(ArrayList<Player> p) {
        players = p;
    }
    public static ArrayList<Player> getPlayers() {
        return players;
    }
}
