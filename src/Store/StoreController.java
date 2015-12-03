package Store;

import Map.EnergyMule;
import Map.FoodMule;
import Map.OreMule;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Context;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Sergey on 10/15/15.
 */
public class StoreController implements Initializable {
    @FXML
    Button buyMule;
    @FXML
    private Pane storeWindow;
    @FXML
    Button leaveStore;
    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * buys food for player
     */
    @FXML
    public void buyFood() {
        System.out.println("Bought Food");
        if(Context.getCurrentPlayer().getBalance() >= 30) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 30);
            Context.getCurrentPlayer().setFood(Context.getCurrentPlayer().getFood() + 1);
        }
    }

    /**
     * buys energy for player
     */
    @FXML
    private void buyEnergy() {
        System.out.println("Bought Energy");
        if(Context.getCurrentPlayer().getBalance() >= 25) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 25);
            Context.getCurrentPlayer().setEnergy(Context.getCurrentPlayer().getEnergy() + 1);
        }
    }

    /**
     * buys ore for player
     */
    @FXML
    private void buyOre() {
        System.out.println("Bought Ore");
        if(Context.getCurrentPlayer().getBalance() >= 75) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 75);
            Context.getCurrentPlayer().setOre(Context.getCurrentPlayer().getOre() + 1);
        }
    }

    /**
     * buys food mule for player
     */
    @FXML
    private void buyFoodMule() {
        System.out.println("Bought Food Mule");
            if(Context.getCurrentPlayer().getBalance() >= 125) {
                Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 125);
                Context.getCurrentPlayer().setMule(new FoodMule());
        }
    }

    /**
     * buys ore mule for player
     */
    @FXML
    private void buyOreMule() {
        System.out.println("Bought Ore Mule");
        if(Context.getCurrentPlayer().getBalance() >= 175) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 175);
            Context.getCurrentPlayer().setMule(new OreMule());
        }
    }

    /**
     * buys energy mule for player
     */
    @FXML
    public void buyEnergyMule() {
        System.out.println("Bought Energy Mule");
        if(Context.getCurrentPlayer().getBalance() >= 150) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 150);
            Context.getCurrentPlayer().setMule(new EnergyMule());
        }
    }

    /**
     * Sells player food
     */
    @FXML
    public void sellFood() {
        System.out.println("CLICKED sell food");
        if(Context.getCurrentPlayer().getFood() >= 1) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() + 30);
            Context.getCurrentPlayer().setFood(Context.getCurrentPlayer().getFood() - 1);
        }
    }

    /**
     * Sells player energy
     */
    @FXML
    private void sellEnergy() {
        System.out.println("CLICKED sell energy");
        if(Context.getCurrentPlayer().getEnergy() >= 1) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() + 25);
            Context.getCurrentPlayer().setEnergy(Context.getCurrentPlayer().getEnergy() - 1);
        }
    }

    /**
     * Sells player ore
     */
    @FXML
    private void sellOre() {
        System.out.println("CLICKED sell energy");
        if(Context.getCurrentPlayer().getOre() >= 1) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() + 50);
            Context.getCurrentPlayer().setOre(Context.getCurrentPlayer().getOre() - 1);
        }
    }

    /**
     * Sends player back to town game screen
     */
    @FXML
    private void leaveStore() {
        System.out.println("clicked on exit store");
        Context.loadMap();
        Stage curStage = (Stage)storeWindow.getScene().getWindow();
        curStage.close();
    }
}
