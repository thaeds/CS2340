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
 */
public class Context {
    private static ArrayList<Player> players;
    private static Player currentPlayer;
    private static Stage mapStage;
    public static Scene map;
    public static int currentRound = 1;
    private static int remainingTime = 140;
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gets current round
     *
     * @return the current round
     */
    public static int getCurrentRound() {
        return currentRound;
    }

    /**
     * Sets current round
     *
     * @param i round being set
     */
    public static void setCurrentRound(int i) {
        currentRound = i;
    }

    /**
     * Gets remaining time
     *
     * @return the amount of remaining time
     */
    public static int getRemainingTime() {
        return remainingTime;
    }

    /**
     * Sets remaining time
     *
     * @param i amount of time being set
     */
    public static void setRemainingTime(int i) {
        if (i > 0) {
            remainingTime = i;
        }
    }

    /**
     * Sets current player
     *
     * @param p player being sset
     */
    public static void setCurrentPlayer(Player p) {
        System.out.println("Current Player" + p.toString());
        currentPlayer = p;
    }

    /**
     * clears players and stage
     */
    public static void clear() {
        players = null;
        currentPlayer = null;
        mapStage = null;
        currentRound = 1;
    }

    /**
     * gets map stage
     *
     * @return map stage
     */
    public static Stage getMapStage() {
        return mapStage;
    }

    /**
     * sets map stage
     *
     * @param mStage the stage being set
     */
    public static void setMapStage(Stage mStage) {
        mapStage = mStage;
    }

    /**
     * loads map
     */
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

    /**
     * loads town
     */
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
            return;
        }
    }

    /**
     * loads pub
     */
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
            return;
        }
    }

    /**
     * loads store
     */
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
            return;
        }
    }

    /**
     * Sets players
     *
     * @param p  players being set
     */
    public static void setPlayers(ArrayList<Player> p) {
        players = p;
    }

    /**
     * Sets remaining time
     *
     * @return the amount of remaining time
     */
    public static ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * saves game
     */
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

    /**
     * loads saved game
     */
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

    /**
     * loads saved game
     */
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
