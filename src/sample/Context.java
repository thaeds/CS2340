package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Sergey on 9/25/15.
 * @author Sergey
 * @version 1.0 calculate current round and time, also set and get player in playerlist
 * @version 1.5 context class does following: loading structures (town/pub/store/map/...)
 * @version 2.0 save and load games
 *
 */
public class Context {
    private static ArrayList<Player> players;
    private static Player currentPlayer;
    private static Stage mapStage;
    public static Scene map;
    private static int currentRound = 1;
    private static int remainingTime = 140;
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static int getCurrentRound() {
        return currentRound;
    }

    public static void setCurrentRound(int i) {
        currentRound = i;
    }

    public static int getRemainingTime() {
        return remainingTime;
    }

    public static void setRemainingTime(int i) {
        if (i > 0) {
            remainingTime = i;
        }
    }


    public static void setCurrentPlayer(Player p) {
        System.out.println("Current Player" + p.toString());
        currentPlayer = p;
    }
    public static void clear() {
        players = null;
        currentPlayer = null;
        mapStage = null;
        currentRound = 1;
    }
    public static Stage getMapStage() {
        return mapStage;
    }

    public static void setMapStage(Stage mStage) {
        mapStage = mStage;
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
        } catch (Exception e) {
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
            //s.close();
        } catch (Exception e) {
            System.out.println("Can't load town");
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
            //s.close();
        } catch (Exception e) {
            System.out.println("Can't load pub");
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
            //s.close();
        } catch (Exception e) {
            System.out.println("Can't load Store");
        }
    }

    public static void setPlayers(ArrayList<Player> p) {
        players = p;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void writeGameSaveState() {
        gameSaveState save = new gameSaveState();
        save.setCurrentPlayer(currentPlayer);
        save.setPlayers(players);
        save.setCurrentRound(currentRound);
        try {
            File saveGame = new File("M.U.L.E._Save.data");
            FileOutputStream f = new FileOutputStream(saveGame);
            ObjectOutputStream obj_out = new ObjectOutputStream(f);
            obj_out.writeObject(save);
        } catch (Exception e) {
            System.out.println("SAVE ERROR!");
            System.out.println(e.getMessage());
        }
    }

    public static void readGameSaveState() {
        try {
            FileInputStream f = new FileInputStream("M.U.L.E._Save.data");
            ObjectInputStream obj_in = new ObjectInputStream(f);
            Object obj = obj_in.readObject();
            if (obj instanceof gameSaveState) {
                gameSaveState saveState = (gameSaveState) obj;
                currentPlayer = saveState.getCurrentPlayer();
                players = saveState.getPlayers();
                currentRound = saveState.getCurrentRound();
                for (Player p : players) {
                    Color c = new Color(p.getRed(), p.getGreen(), p.getBlue(), p.getOpacity());
                    p.setColor(c);
                }
                Context.loadMap();
            }
        } catch(Exception e) {
            System.out.println("SAVE NOT FOUND!!!");
            System.out.println(e.getMessage());
        }
    }
    public static void readGameSaveStateTest() {
        try {
            FileInputStream f = new FileInputStream("M.U.L.E._Save.data");
            ObjectInputStream obj_in = new ObjectInputStream(f);
            Object obj = obj_in.readObject();
            if (obj instanceof gameSaveState) {
                gameSaveState saveState = (gameSaveState) obj;
                currentPlayer = saveState.getCurrentPlayer();
                players = saveState.getPlayers();
                currentRound = saveState.getCurrentRound();
                for (Player p : players) {
                    Color c = new Color(p.getRed(), p.getGreen(), p.getBlue(), p.getOpacity());
                    p.setColor(c);
                }
            }
        } catch(Exception e) {
            System.out.println("SAVE NOT FOUND!!!");
            System.out.println(e.getMessage());
        }
    }
}
