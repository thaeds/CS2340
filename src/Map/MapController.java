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
import javafx.scene.image.ImageView;
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
    ArrayList<Tile> tileList = new ArrayList<>();
    private class MapStuff extends TimerTask {
        //private ArrayDeque<Player> turn = new ArrayDeque<>();
        Turn ordering;

        /**
         * Player's resources (Food/Energy/Ore) is calculated according to the map setting or town type
         * SOP is printed for user to view the current stat
         * Move onto next player when current is finished
         */
        public void run() {
            //randomEvents();
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
            t = new Town("town");
            tileList.add(t);
            t.setOnMouseClicked(a -> {
                Context.loadTown();
                Stage curStage = (Stage)mapWindow.getScene().getWindow();
                curStage.close();
            });
            tiles.add(t, 4, 2);

            River r1 = new River("r1");
            River r2 = new River("r2");
            River r3 = new River("r3");
            River r4 = new River("r4");


            tiles.add(r1, 4, 0);
            tiles.add(r2, 4, 1);
            tiles.add(r3, 4, 3);
            tiles.add(r4, 4, 4);

            tileList.add(r1);
            tileList.add(r2);
            tileList.add(r3);
            tileList.add(r4);

            Mountain m1 = new Mountain("m1");
            Mountain m2 = new Mountain("m2");
            Mountain m3 = new Mountain("m3");
            Mountain m4 = new Mountain("m4");
            Mountain m5 = new Mountain("m5");
            Mountain m6 = new Mountain("m6");
            Mountain m7 = new Mountain("m7");
            Mountain m8 = new Mountain("m8");
            Mountain m9 = new Mountain("m9");
            Mountain m10 = new Mountain("m10");

            tileList.add(m1);
            tileList.add(m2);
            tileList.add(m3);
            tileList.add(m4);
            tileList.add(m5);
            tileList.add(m6);
            tileList.add(m7);
            tileList.add(m8);
            tileList.add(m9);
            tileList.add(m10);

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

            Tile t1 = new Tile("t1");
            Tile t2 = new Tile("t2");
            Tile t3 = new Tile("t3");
            Tile t4 = new Tile("t4");
            Tile t5 = new Tile("t5");
            Tile t6 = new Tile("t6");
            Tile t7 = new Tile("t7");
            Tile t8 = new Tile("t8");
            Tile t9 = new Tile("t9");
            Tile t10 = new Tile("t10");
            Tile t11 = new Tile("t11");
            Tile t12 = new Tile("t12");
            Tile t13 = new Tile("t13");
            Tile t14 = new Tile("t14");
            Tile t15 = new Tile("t15");
            Tile t16 = new Tile("t16");
            Tile t17 = new Tile("t17");
            Tile t18 = new Tile("t18");
            Tile t19 = new Tile("t19");
            Tile t20 = new Tile("t20");
            Tile t21 = new Tile("t21");
            Tile t22 = new Tile("t22");
            Tile t23 = new Tile("t23");
            Tile t24 = new Tile("t24");
            Tile t25 = new Tile("t25");
            Tile t26 = new Tile("t26");
            Tile t27 = new Tile("t27");
            Tile t28 = new Tile("t28");
            Tile t29 = new Tile("t29");
            Tile t30 = new Tile("t30");

            tileList.add(t1);
            tileList.add(t2);
            tileList.add(t3);
            tileList.add(t4);
            tileList.add(t5);
            tileList.add(t6);
            tileList.add(t7);
            tileList.add(t8);
            tileList.add(t9);
            tileList.add(t10);
            tileList.add(t11);
            tileList.add(t12);
            tileList.add(t13);
            tileList.add(t14);
            tileList.add(t15);
            tileList.add(t16);
            tileList.add(t17);
            tileList.add(t18);
            tileList.add(t19);
            tileList.add(t20);
            tileList.add(t21);
            tileList.add(t22);
            tileList.add(t23);
            tileList.add(t24);
            tileList.add(t25);
            tileList.add(t26);
            tileList.add(t27);
            tileList.add(t28);
            tileList.add(t29);
            tileList.add(t30);

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
                    System.out.println("Current Owner: " + t.getOwner());
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
                            System.out.println("Owner: " + t.getOwner());
                            System.out.println("Current Player: " + Context.getCurrentPlayer() );
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
            boolean moreThanTwo = true;
            for (Player p: players) {
                if (p.getNumberOfTiles() < 2) {
                    moreThanTwo = false;
                }
            }
            selectionPhaseOver = moreThanTwo;
            if (selectionPhaseOver) {
                messageBox.setText("Selection Phase is over! Begging Game!");
            }
            currentPlayer = ordering.nextTurn();

            System.out.println("Ordering player: " + currentPlayer);
            if(currentPlayer == null) {
                System.out.println("NO PLAYERS IN GAME TEST CASE GENERATED!!!");
            }
            randomEvents();
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
        updateTileOwners();
    }
    public void updateTileOwners() {
        for(Player p : Context.getPlayers()) {
            for(Tile t : tileList) {
                if (p.getTiles().contains(t)) {
                    p.getTiles().remove(t);
                    p.addTile(t);
                    //System.out.println("Setting owner to: " + p);
                    t.setOwner(p);
                    t.setIsOwned(true);
                    //System.out.println("Here 4");
                    Shadow s = new Shadow();
                    s.setColor(p.getColor());
                    s.setBlurType(BlurType.GAUSSIAN);
                    s.setRadius(50);
                    s.setWidth(0);
                    s.setHeight(0);
                    t.setEffect(s);
                }
            }
        }
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


    // ************************************************************************************************ //
    Event randomEvent = new Event();
    String eventDetail;
    //
    public void randomEvents() {
        eventDetail = new String();
        eventDetail = "System: " + currentPlayer.getName() + " - ";
        // TEXTBOX FORMAT: System: PlayerName - EVENT.

        if ((1 + (int) (Math.random() * ((100 - 1) + 1))) > randomEvent.getChance()) { // (!) NO RANDOM EVENT OCCURS
            eventDetail += "NO RANDOM EVENT OCCURED";

        } else { // RANDOM EVENT OCCURS

            // SET FACTOR BASED ON ROUND && CHOOSE A RANDOM EVENT TO AFFECT PLAYER / DISPLAY TO SOP+TEXTBOX
            randomEvent.setFactor(getCurrentRound());
            int event_selector = (int) (Math.random() * 9); // RANGE OF [0,9]
            eventDetail += randomEvent.getDetail(event_selector);

            switch (event_selector + 1) { // CHANGE PLAYER PROPERTY BASED ON THE EVENT
                case 1: // PLAYER (+) FOOD (+3) (+) ENERGY (+2)
                    currentPlayer.setFood(currentPlayer.getFood() + 3);
                    currentPlayer.setEnergy(currentPlayer.getEnergy() + 2);
                    break;
                case 2: // PLAYER (+) ORE (+2)
                    currentPlayer.setOre(currentPlayer.getOre() + 2);
                    break;
                case 3: // PLAYER (+) BALANCE (8*m)
                    eventDetail += eventDetail + (8 * randomEvent.getFactor());
                    currentPlayer.setBalance(currentPlayer.getBalance() + 8 * randomEvent.getFactor());
                    break;
                case 4: // PLAYER (+) BALANCE (2*m)
                    eventDetail += (2 * randomEvent.getFactor());
                    currentPlayer.setBalance(currentPlayer.getBalance() + 2 * randomEvent.getFactor());
                    break;
                case 5: // PLAYER (-) BALANCE (4*m)
                    if (!currentPlayer.isLowest()) { // BAD EVENT DO NOT HAPPEN TO LOWEST SCORE
                        eventDetail +=  (4 * randomEvent.getFactor());
                        currentPlayer.setBalance(currentPlayer.getBalance() - 4 * randomEvent.getFactor());
                    }
                    break;
                case 6: // PLAYER (-) BALANCE (1/2)
                    if (!currentPlayer.isLowest()) { // BAD EVENT DO NOT HAPPEN TO LOWEST SCORE
                        currentPlayer.setFood(currentPlayer.getBalance() / 2);
                    } else {
                        eventDetail += "\nBUT GOD BRINGS MERCY ON THE NOOB SO NO BAD EVENT OCCURS";
                    }
                    break;
                case 7: // PLAYER (-) BALANCE (6*m)
                    if (!currentPlayer.isLowest()) { // BAD EVENT DO NOT HAPPEN TO LOWEST SCORE
                        eventDetail += (6 * randomEvent.getFactor()) + "TO CLEAN IT UP.";
                        currentPlayer.setBalance(currentPlayer.getBalance() - 6 * randomEvent.getFactor());
                    } else {
                        eventDetail += "\nBUT GOD BRINGS MERCY ON THE NOOB SO NO BAD EVENT OCCURS";
                    }
                    break;
                case 8: //PLAYER (-) FOOD (1/4)
                    if (!currentPlayer.isLowest()) { // BAD EVENT DO NOT HAPPEN TO LOWEST SCORE
                        currentPlayer.setFood( (int) (currentPlayer.getFood() * 0.25));
                    } else {
                        eventDetail += "\nBUT GOD BRINGS MERCY ON THE NOOB SO NO BAD EVENT OCCURS";
                    }
                    break;
                case 9:
                    currentPlayer.setEnergy(currentPlayer.getEnergy() + 15);
                    break;
                case 10:
                    currentPlayer.setFood(currentPlayer.getFood() + 8);
                    break;
                default:
                    eventDetail = "this should not happen and sorry for using a switch statement";
                    break;
            }
        } // END OF RANDOM EVENT AFFECT


        if ((1 + (int) (Math.random() * ((100 - 1) + 1))) > (randomEvent.getChance())) { // ROUND SPECIAL RANDOM EVENT
            eventDetail += "\n~ SPECIAL ~ ROUND EVENT!! RECEIVES "
                + (getCurrentRound() * 100) + " BALANCE! $$$$$$$";
            currentPlayer.setBalance(currentPlayer.getBalance() + (getCurrentRound()*100));
        } // END OF ROUND SPECIAL RANDOM EVENT

        // PRINT OUT RESULT OF RANDOM EVENT
        messageBox.setText(eventDetail);
        System.out.println(eventDetail);

    } // END OF randomEvent()
    // ************************************************************************************************ //

} //END OF MapController class

