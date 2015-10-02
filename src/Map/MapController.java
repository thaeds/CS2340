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
        private ArrayDeque<Player> turn = new ArrayDeque<>();
        Turn ordering;
        public void run() {
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
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("M.U.L.E");
                FXMLLoader ldr = new FXMLLoader();
                Pane myPane = null;
                try {
                    myPane = ldr.load(getClass().getResource("town.fxml"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return;}
                Scene scene = new Scene(myPane);
                stage.setScene(scene);
                stage.setOnCloseRequest(b -> {
                    Platform.exit();
                    System.exit(0);
                });
                prevStage.close();
                stage.show();
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
                    Shadow s = new Shadow();
                    if (n.getEffect() != null && n.getEffect().getClass().equals(s.getClass())) {
                    }else {
                        n.setEffect(ca);
                    }
                });
                n.setOnMouseExited(a -> {
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
                    if(n.getClass().getName() == "Map.Town") {
                    } else {
                        n.setOnMouseClicked(a -> {
                            Tile t = (Tile) n;
                            buyTile(p, t, s);
                            nextPlayer();
                        });
                    }
                } else {
                    n.setOnMouseClicked(a -> {
                        Tile t = (Tile)n;
                        if (t.getOwner() != null) {
                            messageBox.setText("This property is already owned by another player!");
                        }
                    });
                }
            }
        }
        public void setPlayers(ArrayList<Player> p) {
            players.addAll(p);
            //ordering = new Turn(players);
            turn.addAll(p);
            nextPlayer();
        }
        private Tile getTileFromRepresentation(Node v) {
            return tileImages.get(v);
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
            currentPlayer = turn.poll();

            System.out.println("Ordering player: " + currentPlayer);
            if(currentPlayer == null) {
                System.out.println("NO PLAYERS IN GAME TEST CASE GENERATED!!!");
            }
            playerInfo.setText(currentPlayer.toString() + "| Number of tiles: " + currentPlayer.getTiles().size());
            playerInfo.setBackground(new Background(new BackgroundFill(currentPlayer.getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("Current Player: " + currentPlayer);
            turn.add(currentPlayer);
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
        private class Turn {
            private ArrayList<Player> order;
            int turnCount = 0;

            private Turn(ArrayList<Player> p) {
                order = new ArrayList<>();
                order.addAll(p);
            }

            public Player nextTurn() {
                //System.out.println("TURN: " + order.get(turnCount));
                if (turnCount >= order.size() - 1 && order.size()  > 0) {
                    System.out.println("HERE");
                    turnCount = 0;
                    Collections.sort(order);
                }
                turnCount++;
                return order.get(turnCount - 1);
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
    private void enterTown() {
        System.out.println("Entering Town");
        Pane myPane = null;
        FXMLLoader ldr = new FXMLLoader();
        try {
            // I have no idea why I can't get this to work
            myPane = ldr.load(getClass().getResource("town.fxml"));
        } catch (Exception e) {
            System.out.println("Exception loading town.fxml");
            return;
        }
        Scene scene = new Scene(myPane);
        prevStage = (Stage) mapWindow.getScene().getWindow();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(a -> {
            Platform.exit();
            System.exit(0);
        });
        prevStage.close();
        stage.show();
    }

    @FXML
    private Pane background;
    @FXML
    private TextField pubmsg;
    @FXML
    private Pane townWindow;
    Random rng = new Random();
    private void enterPub() {
        System.out.println("Entering Pub");
        int round = 1;
        double time = 10;
        int bonus = (int)(round * rng.nextDouble() * time);
        currentPlayer.setBalance(currentPlayer.getBalance() + bonus);
        pubmsg = new TextField();
        pubmsg.setText("You earned " + bonus + " dollars from gambling!");
        Pane myPane = null;
        FXMLLoader ldr = new FXMLLoader();
        try {
            // I have no idea why I can't get this to work
            myPane = ldr.load(getClass().getResource("pub.fxml"));
        } catch (Exception e) {
            System.out.println("Exception loading pub.fxml");
            return;
        }
        Image pub = new Image(getClass().getResource("pubinside.jpg").toExternalForm());
        ImagePattern img = new ImagePattern(pub);
        BackgroundFill bgFill = new BackgroundFill(img, new CornerRadii(0), new Insets(0,0,0,0));
        Background bg = new Background(bgFill);
        background.setBackground(bg);
//        outerWindow.setStyle("-fx-background-image: url('" + "pubinside.jpg" + "')");

        Scene scene = new Scene(myPane);
        prevStage = (Stage) townWindow.getScene().getWindow();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(a -> {
            Platform.exit();
            System.exit(0);
        });
        prevStage.close();
        stage.show();
    }

}