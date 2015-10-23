package Map;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import sample.*;
import sample.Player;

import java.util.*;

/**
 * Created by Sergey on 9/24/15.
 */
public class MapController {
    Town t;
    private class MapStuff extends TimerTask {
        //private ArrayDeque<Player> turn = new ArrayDeque<>();
        Turn ordering;

        /**
         * Player's resources (Food/Energy/Ore) is calculated according to the map setting or town type
         * SOP is printed for user to view the current stat
         * Move onto next player when current is finished
         */
        public void run() {
            Context.getCurrentPlayer().production();
            nextPlayer();
        }


        public MapStuff() {
            setPlayers(Context.getPlayers());
            System.out.println("I am initialing!");
            startMap1();
            setMouseOver();
        }

        private void startMap1() {
            t = new Town();
            t.setOnMouseClicked(a -> {
                Context.loadTown();
                Stage curStage = (Stage)mapWindow.getScene().getWindow();
                curStage.close();
            });
            tiles.add(t, 4, 2);

            River r1 = new River();
            River r2 = new River();
            River r3 = new River();
            River r4 = new River();


            tiles.add(r1, 4, 0);
            tiles.add(r2, 4, 1);
            tiles.add(r3, 4, 3);
            tiles.add(r4, 4, 4);

            Mountain m1 = new Mountain();
            Mountain m2 = new Mountain();
            Mountain m3 = new Mountain();
            Mountain m4 = new Mountain();
            Mountain m5 = new Mountain();
            Mountain m6 = new Mountain();
            Mountain m7 = new Mountain();
            Mountain m8 = new Mountain();
            Mountain m9 = new Mountain();
            Mountain m10 = new Mountain();

            tiles.add(m1, 2, 0);
            tiles.add(m2, 1, 1);
            tiles.add(m3, 0, 2);
            tiles.add(m4, 1, 3);
            tiles.add(m5, 2, 4);
            tiles.add(m6, 6, 0);
            tiles.add(m7, 8, 1);
            tiles.add(m8, 8, 2);
            tiles.add(m9, 6, 3);
            tiles.add(m10, 8, 4);

            Tile t1 = new Tile();
            Tile t2 = new Tile();
            Tile t3 = new Tile();
            Tile t4 = new Tile();
            Tile t5 = new Tile();
            Tile t6 = new Tile();
            Tile t7 = new Tile();
            Tile t8 = new Tile();
            Tile t9 = new Tile();
            Tile t10 = new Tile();
            Tile t11 = new Tile();
            Tile t12 = new Tile();
            Tile t13 = new Tile();
            Tile t14 = new Tile();
            Tile t15 = new Tile();
            Tile t16 = new Tile();
            Tile t17 = new Tile();
            Tile t18 = new Tile();
            Tile t19 = new Tile();
            Tile t20 = new Tile();
            Tile t21 = new Tile();
            Tile t22 = new Tile();
            Tile t23 = new Tile();
            Tile t24 = new Tile();
            Tile t25 = new Tile();
            Tile t26 = new Tile();
            Tile t27 = new Tile();
            Tile t28 = new Tile();
            Tile t29 = new Tile();
            Tile t30 = new Tile();


            tiles.add(t1, 0, 0);
            tiles.add(t2, 0, 1);
            tiles.add(t3, 0, 3);
            tiles.add(t4, 0, 4);
            tiles.add(t5, 1, 0);
            tiles.add(t6, 1, 2);
            tiles.add(t7, 1, 4);
            tiles.add(t8, 2, 1);
            tiles.add(t9, 2, 2);
            tiles.add(t10, 2, 3);
            tiles.add(t11, 3, 0);
            tiles.add(t12, 3, 1);
            tiles.add(t13, 3, 2);
            tiles.add(t14, 3, 3);
            tiles.add(t15, 3, 4);
            tiles.add(t16, 5, 0);
            tiles.add(t17, 5, 1);
            tiles.add(t18, 5, 2);
            tiles.add(t19, 5, 3);
            tiles.add(t20, 5, 4);
            tiles.add(t21, 6, 1);
            tiles.add(t22, 6, 2);
            tiles.add(t23, 6, 4);
            tiles.add(t24, 7, 0);
            tiles.add(t25, 7, 1);
            tiles.add(t26, 7, 2);
            tiles.add(t27, 7, 3);
            tiles.add(t28, 7, 4);
            tiles.add(t29, 8, 0);
            tiles.add(t30, 8, 3);
        }

        private void setMouseOver() {
            ColorAdjust ca = new ColorAdjust();
            ca.setBrightness(.5);
            for (Node n : tiles.getChildren()) {
                n.setOnMouseEntered(a -> {
                    if(a.getClickCount() == 2) {
                        System.out.println("Current Owner: " + t.getOwner());
                        if(Context.getCurrentPlayer().getMule() != null &&
                                t.getOwner() == Context.getCurrentPlayer()) {
                            t.setMule(Context.getCurrentPlayer().getMule());
                            System.out.println("Mule Placed");
                        }
                    }
                    Shadow s = new Shadow();
                    if (n.getEffect() != null && n.getEffect().getClass().equals(s.getClass())) {
                    }else {
                        n.setEffect(ca);
                    }
                });
                n.setOnMouseExited(a -> {
                    if(a.getClickCount() == 2) {
                        System.out.println("Current Owner: " + t.getOwner());
                        if(Context.getCurrentPlayer().getMule() != null &&
                                t.getOwner() == Context.getCurrentPlayer()) {
                            t.setMule(Context.getCurrentPlayer().getMule());
                            System.out.println("Mule Placed");
                        }
                    }
                    if (n.getEffect().equals(ca)) {
                        n.setEffect(null);
                    }
                });
            }
        }

        private void setTileOwner(Player p) {
            for (Node n : tiles.getChildren()) {
                if (n.getEffect() == null) {
                    Shadow s = new Shadow();
                    s.setColor(p.getColor());
                    s.setBlurType(BlurType.GAUSSIAN);
                    s.setRadius(50);
                    s.setWidth(0);
                    s.setHeight(0);
                    if(n.getClass().getName().equals("Map.Town")) {
                    } else {
                        n.setOnMouseClicked(a -> {
                            Tile t = (Tile) n;
                            buyTile(p, t, s);
                            t.setOwner(Context.getCurrentPlayer());
                            nextPlayer();
                            if(a.getClickCount() == 2) {
                                System.out.println("Current Owner: " + t.getOwner());
                                if(Context.getCurrentPlayer().getMule() != null &&
                                        t.getOwner() == Context.getCurrentPlayer()) {
                                    t.setMule(Context.getCurrentPlayer().getMule());
                                    System.out.println("Mule Placed");
                                }
                            }
                        });
                    }
                } else {
                    n.setOnMouseClicked(a -> {
                        if(a.getClickCount() == 2) {
                            System.out.println("Current Owner: " + t.getOwner());
                            if(Context.getCurrentPlayer().getMule() != null &&
                                    t.getOwner() == Context.getCurrentPlayer()) {
                                t.setMule(Context.getCurrentPlayer().getMule());
                                System.out.println("Mule Placed");
                            }
                        }
                        Tile t = (Tile)n;
                        if (t.getOwner() != null) {
                            messageBox.setText("This property is already owned by another player!");
                        }
                    });
                }
            }
        }
        public void setPlayers(ArrayList<Player> p) {
            ordering = new Turn();
            nextPlayer();
        }
        private void nextPlayer(){
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getNumberOfTiles() >= 2) {
                    selectionPhaseOver = true;
                } else {
                    selectionPhaseOver = false;
                }
            }
            if (selectionPhaseOver) {
                messageBox.setText("Selection Phase is over! Begging Game!");
            }
            currentPlayer = ordering.nextTurn();

            System.out.println("Ordering player: " + currentPlayer);
            if(currentPlayer == null) {
                System.out.println("NO PLAYERS IN GAME TEST CASE GENERATED!!!");
            }
            playerInfo.setText(currentPlayer.toString() + "| Number of tiles: " + currentPlayer.getTiles().size());
            playerInfo.setBackground(new Background(new BackgroundFill(currentPlayer.getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("Current Player: " + currentPlayer);
            //turn.add(currentPlayer);
            setTileOwner(currentPlayer);
        }

        private void buyTile(Player p, Tile t, Shadow s) {
            if (!selectionPhaseOver) {
                t.setEffect(s);
                p.addTile(t);
                t.setOwner(p);
            } else {
                if (p.getBalance() >= t.getCost()) {
                    t.setEffect(s);
                    p.setBalance((p.getBalance() - t.getCost()));
                    p.addTile(t);
                    t.setOwner(p);
                } else {
                    messageBox.setText("You can't afford this tile!");
                }
            }
        }
    }
    @FXML
    private GridPane tiles;
    @FXML
    TextArea messageBox;
    @FXML
    TextArea playerInfo;
    @FXML
    Button pass;
    private boolean selectionPhaseOver;
    private Player currentPlayer;
    //private PriorityQueue<Player> turn = new PriorityQueue<>();
    private ArrayList<Player> players = new ArrayList<>();
    private HashMap<Node, Tile> tileImages = new HashMap<>();
    private MapStuff map;
    Timer timer;
    @FXML
    public void initialize(){
        map = new MapStuff();
        timer = new Timer();
        timer.schedule(map, 0, 5000);
    }
    @FXML
    private void nextPlayer(){
        map.nextPlayer();
    }
    @FXML
    private Pane mapWindow;
    private Stage prevStage = null;

    @FXML
    private Pane background;
    @FXML
    private TextField pubmsg;
    @FXML
    private Pane townWindow;
    Random rng = new Random();

    public int getCurrentRound() {
        return 1;
    }

    //List of random events and their detailed implementation
    String RANDOM_EVENT1 = "1. YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS";
    String RANDOM_EVENT2 = "2. A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";
    String RANDOM_EVENT3 = "3. THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ 8*m.";
    String RANDOM_EVENT4 = "4. YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $2*m.";
    String RANDOM_EVENT5 = "5. FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $4*m.";
    String RANDOM_EVENT6 = "6. MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";
    String RANDOM_EVENT7 = "7. YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $6*m TO CLEAN IT UP.";
    protected int RANDOM_EVENT_CHANCE = 27;
    public void randomEvents() {
        int m; //Factor m
        if (getCurrentRound() <= 3) { // Round 1 to 3
            m = 25;
        } else if (getCurrentRound() <= 7) { // Round 4 to 7
            m = 50;
        } else if (getCurrentRound() <= 11) { // Round 8 to 11
            m = 75;
        } else { // Final Round 12
            m = 100;
        }
        System.out.println("M factor is " + m); //debugging + warning crap

        int event_selector = 1 + (int)(Math.random() * ((7 - 1) + 1));
        String event = "";
        switch (event_selector) { // need to implement aftermath of random event **TODO
            case 1:
                event = RANDOM_EVENT1;
                break;
            case 2:
                event = RANDOM_EVENT2;
                break;
            case 3:
                event = RANDOM_EVENT3;
                break;
            case 4:
                event = RANDOM_EVENT4;
                break;
            case 5:
                event = RANDOM_EVENT5;
                break;
            case 6:
                event = RANDOM_EVENT6;
                break;
            case 7:
                event = RANDOM_EVENT7;
                break;
            default:
                event = "No random event occured. For moment peace continues.";
                break;
        }


    } //END OF randomEvents()

} //END OF MapController class

