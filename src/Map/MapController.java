package Map;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import sample.*;
import sample.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sergey on 9/24/15.
 */
public class MapController {
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
    private ArrayDeque<Player> turn = new ArrayDeque<>();
    private ArrayList<Player> players = new ArrayList<>();
    private HashMap<Node, Tile> tileImages = new HashMap<>();
    @FXML
    public void initialize() {
        System.out.println("I am initialing!");
        startMap1();
        setMouseOver();
        setPlayers(Context.getPlayers());
    }

    private void startMap1() {
        Town t = new Town();

        tiles.add(t.representation, 4, 2);

        River r1 = new River();
        River r2 = new River();
        River r3 = new River();
        River r4 = new River();

        tileImages.put(r1.representation, r1);
        tileImages.put(r2.representation, r2);
        tileImages.put(r3.representation, r3);
        tileImages.put(r4.representation, r4);

        tiles.add(r1.representation, 4, 0);
        tiles.add(r2.representation, 4, 1);
        tiles.add(r3.representation, 4, 3);
        tiles.add(r4.representation, 4, 4);

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

        tileImages.put(m1.representation, m1);
        tileImages.put(m2.representation, m2);
        tileImages.put(m3.representation, m3);
        tileImages.put(m4.representation, m4);
        tileImages.put(m5.representation, m5);
        tileImages.put(m6.representation, m6);
        tileImages.put(m7.representation, m7);
        tileImages.put(m8.representation, m8);
        tileImages.put(m9.representation, m9);
        tileImages.put(m10.representation, m10);

        tiles.add(m1.representation, 2, 0);
        tiles.add(m2.representation, 1, 1);
        tiles.add(m3.representation, 0, 2);
        tiles.add(m4.representation, 1, 3);
        tiles.add(m5.representation, 2, 4);
        tiles.add(m6.representation, 6, 0);
        tiles.add(m7.representation, 8, 1);
        tiles.add(m8.representation, 8, 2);
        tiles.add(m9.representation, 6, 3);
        tiles.add(m10.representation, 8, 4);

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

        tileImages.put(t1.representation, t1);
        tileImages.put(t2.representation, t2);
        tileImages.put(t3.representation, t3);
        tileImages.put(t4.representation, t4);
        tileImages.put(t5.representation, t5);
        tileImages.put(t6.representation, t6);
        tileImages.put(t7.representation, t7);
        tileImages.put(t8.representation, t8);
        tileImages.put(t9.representation, t9);
        tileImages.put(t10.representation, t10);
        tileImages.put(t11.representation, t11);
        tileImages.put(t12.representation, t12);
        tileImages.put(t13.representation, t13);
        tileImages.put(t14.representation, t14);
        tileImages.put(t15.representation, t15);
        tileImages.put(t16.representation, t16);
        tileImages.put(t17.representation, t17);
        tileImages.put(t18.representation, t18);
        tileImages.put(t19.representation, t19);
        tileImages.put(t20.representation, t20);
        tileImages.put(t21.representation, t21);
        tileImages.put(t22.representation, t22);
        tileImages.put(t23.representation, t23);
        tileImages.put(t24.representation, t24);
        tileImages.put(t25.representation, t25);
        tileImages.put(t26.representation, t26);
        tileImages.put(t27.representation, t27);
        tileImages.put(t28.representation, t28);
        tileImages.put(t29.representation, t29);
        tileImages.put(t30.representation, t30);

        tiles.add(t1.representation, 0, 0);
        tiles.add(t2.representation, 0, 1);
        tiles.add(t3.representation, 0, 3);
        tiles.add(t4.representation, 0, 4);
        tiles.add(t5.representation, 1, 0);
        tiles.add(t6.representation, 1, 2);
        tiles.add(t7.representation, 1, 4);
        tiles.add(t8.representation, 2, 1);
        tiles.add(t9.representation, 2, 2);
        tiles.add(t10.representation, 2, 3);
        tiles.add(t11.representation, 3, 0);
        tiles.add(t12.representation, 3, 1);
        tiles.add(t13.representation, 3, 2);
        tiles.add(t14.representation, 3, 3);
        tiles.add(t15.representation, 3, 4);
        tiles.add(t16.representation, 5, 0);
        tiles.add(t17.representation, 5, 1);
        tiles.add(t18.representation, 5, 2);
        tiles.add(t19.representation, 5, 3);
        tiles.add(t20.representation, 5, 4);
        tiles.add(t21.representation, 6, 1);
        tiles.add(t22.representation, 6, 2);
        tiles.add(t23.representation, 6, 4);
        tiles.add(t24.representation, 7, 0);
        tiles.add(t25.representation, 7, 1);
        tiles.add(t26.representation, 7, 2);
        tiles.add(t27.representation, 7, 3);
        tiles.add(t28.representation, 7, 4);
        tiles.add(t29.representation, 8, 0);
        tiles.add(t30.representation, 8, 3);
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
                n.setOnMouseClicked(a -> {
                    if (p.getNumberOfTiles() < 2) {
                        n.setEffect(s);
                        p.setNumberOfTiles(p.getNumberOfTiles() + 1);
                    } else {
                        messageBox.setText("You may only get 2 free tiles during the selection phase! Push pass to continue.");
                    }
                });
            } else {
                n.setOnMouseClicked(a -> {
                    if (n.getEffect() != null) {
                        messageBox.setText("This property is already owned by another player!");
                    }
                });
            }
        }
    }
    public void setPlayers(ArrayList<Player> p) {
        players.addAll(p);
        turn.addAll(p);
        nextPlayer();
    }
    private Tile getTileFromRepresentation(Node v) {
        return tileImages.get(v);
    }
    @FXML
    private void nextPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getNumberOfTiles() == 2) {
                selectionPhaseOver = true;
            } else {
                selectionPhaseOver = false;
            }
        }
        if (selectionPhaseOver) {
            messageBox.setText("Selection Phase is over! Begging Game!");
        }
        currentPlayer = turn.poll();
        if(currentPlayer == null) {
            System.out.println("NO PLAYERS IN GAME TEST CASE GENERATED!!!");
            currentPlayer = testCase();
        }
        playerInfo.setText(currentPlayer.toString() + "| Number of tiles: " + currentPlayer.getTiles().size());
        playerInfo.setBackground(new Background(new BackgroundFill(currentPlayer.getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        System.out.println("Current Player: " + currentPlayer);
        turn.add(currentPlayer);
        setTileOwner(currentPlayer);
    }
    private Player testCase() {
        Player p = new Player("John", "Humanoid", Color.LIGHTGREEN);
        return p;
    }
}
