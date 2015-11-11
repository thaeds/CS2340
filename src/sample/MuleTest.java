import org.junit.Before;
import org.junit.Test;

import sample.Context;
import sample.Player;
import

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by Joseph on 11/9/2015.MuleTest
 */
public class MuleTest {

    @Before
    public void setUp() throws Exception {
        Player p1 = new Player("Kyrsten", "Flapper", yellow);
        Player p2 = new Player("Hyunook", "Buzzite", blue);
        Player p3 = new Player("Joseph", "Human", red);
    }

    @Test
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

    @Test
    public void testGetScore() {
        //beginner: 8 food, 4 energy, 0 ore
        assertEquals(0, p1.getNumberOfTiles()); //flapper: $1600
        assertEquals(0, p2.getNumberOfTiles()); //others: $1000
        assertEquals(0, p3.getNumberOfTiles()); //human: $600

        assertEquals(0, p2.getScore());
        assertEquals(0, p1.getScore());
        assertEquals(0, p3.getScore());

        p1.addTile(mountain); //$500 per tile owned
        assertEquals(500 + 1600 + 8 + 4, p1.getScore());

        p2.addTitle(river);
        asserEquals(500 + 1000 + 8 + 4, p2.getScore());

        p3.addTitle(title);
        assertEquals(500 + 600 + 8 + 4, p3.getScore());
    }

    @Test
    public void setNameTest() {
        p2.setName("Kyrsten");
        assertEquals(p1.getName(), "Kyrsten"); //true
    }
}