package sample;

import Map.Tile;
import Pub.Pub;
import Store.StoreController;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Joseph on 11/9/2015.MuleTest
 */
public class MuleTest {


//    Tile river = new Tile("river");
//    Tile mountain = new Tile("mountain");
//    Tile tile = new Tile("tile");

    Player p1;
    Player p2;
    Player p3;
    Player p4;
    Player p5;

    ArrayList<Player> players = new ArrayList<>();

    StoreController store;

    Pub pub;

    Controller controller;
    @Before
    public void setUp() {
        Color blue = new Color(0,0,0,0);

        p1 = new Player("Kyrsten", "Flapper", blue);
        p2 = new Player("Hyunook", "Buzzite", blue);
        p3 = new Player("Joseph", "Gollumer", blue);
        p4 = new Player("Sergey", "Human", blue);
        p5 = new Player("Alex", "Spheroid", blue);

        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);

        store = new StoreController();

        pub = new Pub();

        controller = new Controller();
    }

    @Test //Sergey
    public void saveTest() throws Exception {
        p4.setBalance(2340);
        Context.setPlayers(players);
        Context.setCurrentRound(5);
        Context.setCurrentPlayer(p4);
        Context.writeGameSaveState();
        Context.clear();
        Context.readGameSaveStateTest();
        Player cur = Context.getCurrentPlayer();
        ArrayList<Player> newPlayers = Context.getPlayers();
        assertEquals("Current player is wrong", p4.getName(), cur.getName());
        assertEquals("Player balance is wrong", 2340, cur.getBalance());
        for(Player play : newPlayers) {
            assertTrue("Missing PLayer", players.contains(play));
        }
        assertEquals("Current round is wrong", 5, Context.getCurrentRound());
    }

    @Test //Hyunook
    public void testNextTurn() throws Exception {
        Queue<Player> playerList = new LinkedList();
        assertTrue(playerList.peek() == null);
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        assertEquals(playerList.peek(), p1);
        assertTrue(playerList.peek() != null);
        Player current = playerList.poll();
        assertEquals(current, p1);
    }


    @Test //Kyrsten
    public void storeTest() {
        Context.setPlayers(players);
        Context.setCurrentPlayer(p1);
        p1.setBalance(150);
        store.buyEnergyMule();
        assertEquals("Balance is not zero", 0, p1.getBalance());
        assertTrue("Player should own a mule",p1.getMule() != null);
        p1.setFood(0);
        store.buyFood();
        assertEquals("Player should be unable to buy food", 0, p1.getFood());
        p1.setBalance(60);
        store.buyFood();
        store.buyFood();
        assertEquals("Player should have 2 units of food", 2, p1.getFood());
    }

    @Test //Alex
    public void testPub() {
        Context.setCurrentRound(10);
        Context.setRemainingTime(28);
        Context.setCurrentPlayer(p5);
        p5.setBalance(100);
        int prevBalance = p5.getBalance();
        int expectedBalance = prevBalance + 1950;
        //Using test method to avoid random numbers in real method
        double random = .25;
        pub.gambleTest(Context.getCurrentPlayer(), random);
        assertEquals("Pub winnings incorrect.", expectedBalance, p5.getBalance());
        p5.setBalance(100);
        Context.setCurrentRound(5);
        Context.setRemainingTime(17);
        random = .63;
        prevBalance = p5.getBalance();
        expectedBalance = prevBalance + 3213;
        System.out.println("Winnings: " + pub.gambleTest(Context.getCurrentPlayer(), random));
        assertEquals("Pub winnings incorrect.", expectedBalance, p5.getBalance());
    }

    @Test //Joseph
    public void controllerTest() {
        controller.setName("");
        assertTrue("Name can't be empty", !controller.verifyName());
        controller.addPlayer(p3);
        controller.setName("Joseph");
        assertTrue("Can't have duplicate name", !controller.verifyName());
    }

    //Could not test other methods becouse they depend on the game running and real time user input.
    //We are not familiar with how to do this within JUnits so were forced to test basic methods.
}