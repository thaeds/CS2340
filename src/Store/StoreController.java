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
    private void buyFoodMule() {
        System.out.println("CLICKED MULE");
            if(Context.getCurrentPlayer().getBalance() > 125) {
                Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 125);
                Context.getCurrentPlayer().setMule(new FoodMule());
        }
    }

    @FXML
    private void buyOreMule() {
        System.out.println("CLICKED MULE");
        if(Context.getCurrentPlayer().getBalance() > 175) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 175);
            Context.getCurrentPlayer().setMule(new OreMule());
        }
    }

    @FXML
    private void buyEnergyMule() {
        System.out.println("CLICKED MULE");
        if(Context.getCurrentPlayer().getBalance() > 150) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 150);
            Context.getCurrentPlayer().setMule(new EnergyMule());
        }
    }

    @FXML
    private void sellFood() {
        System.out.println("CLICKED sell food");
        if(Context.getCurrentPlayer().getFood() > 1) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() + 30);
            Context.getCurrentPlayer().setFood(Context.getCurrentPlayer().getFood() - 1);
        }
    }

    @FXML
    private void sellEnergy() {
        System.out.println("CLICKED sell energy");
        if(Context.getCurrentPlayer().getEnergy() > 1) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() + 25);
            Context.getCurrentPlayer().setEnergy(Context.getCurrentPlayer().getEnergy() - 1);
        }
    }

    @FXML
    private void sellOre() {
        System.out.println("CLICKED sell energy");
        if(Context.getCurrentPlayer().getOre() > 1) {
            Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() + 50);
            Context.getCurrentPlayer().setOre(Context.getCurrentPlayer().getOre() - 1);
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
