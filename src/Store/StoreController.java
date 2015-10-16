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

    @FXML
    private void buyFood() {
        if(Context.getCurrentPlayer().getBalance() >= 30) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 30);
            Context.getCurrentPlayer().setFood(Context.getCurrentPlayer().getFood() + 1);
            System.out.println("Bought Food, Currently you have " + Context.getCurrentPlayer().getFood());
        }
    }
    @FXML
    private void buyEnergy() {
        if(Context.getCurrentPlayer().getBalance() >= 25) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 25);
            Context.getCurrentPlayer().setEnergy(Context.getCurrentPlayer().getEnergy() + 1);
            System.out.println("Bought Energy, Currently you have " + Context.getCurrentPlayer().getEnergy());
        }
    }
    @FXML
    private void buyOre() {
        if(Context.getCurrentPlayer().getBalance() >= 50) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 50);
            Context.getCurrentPlayer().setOre(Context.getCurrentPlayer().getOre() + 1);
            System.out.println("Bought Ore, Currently you have " + Context.getCurrentPlayer().getOre());
        }
    }
    @FXML
    private void buyFoodMule() {
            if(Context.getCurrentPlayer().getBalance() >= 125) {
                Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 125);
                Context.getCurrentPlayer().setMule(new FoodMule());
                System.out.println("Bought Food Mule");
        }
    }

    @FXML
    private void buyOreMule() {
        if(Context.getCurrentPlayer().getBalance() >= 175) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 175);
            Context.getCurrentPlayer().setMule(new OreMule());
            System.out.println("Bought Ore Mule");
        }
    }

    @FXML
    private void buyEnergyMule() {
        if(Context.getCurrentPlayer().getBalance() >= 150) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 150);
            Context.getCurrentPlayer().setMule(new EnergyMule());
            System.out.println("Bought Energy Mule");
        }
    }

    @FXML
    private void sellFood() {
        System.out.println("CLICKED sell food");
        if(Context.getCurrentPlayer().getFood() > 0) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() + 30);
            Context.getCurrentPlayer().setFood(Context.getCurrentPlayer().getFood() - 1);
            System.out.println("Sold Food, Currently you have " + Context.getCurrentPlayer().getFood());
        }
    }

    @FXML
    private void sellEnergy() {
        if(Context.getCurrentPlayer().getEnergy() > 0) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() + 25);
            Context.getCurrentPlayer().setEnergy(Context.getCurrentPlayer().getEnergy() - 1);
            System.out.println("Sold Energy, Currently you have " + Context.getCurrentPlayer().getEnergy());
        }
    }

    @FXML
    private void sellOre() {
        if(Context.getCurrentPlayer().getOre() > 0) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() + 50);
            Context.getCurrentPlayer().setOre(Context.getCurrentPlayer().getOre() - 1);
            System.out.println("Sold Ore, Currently you have " + Context.getCurrentPlayer().getOre());
        }
    }

    @FXML
    private void leaveStore() {
        System.out.println("clicked on exit pub");
        Context.loadMap();
        Stage curStage = (Stage)storeWindow.getScene().getWindow();
        curStage.close();
    }
}
