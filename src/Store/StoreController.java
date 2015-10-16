package Store;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    Button leaveStore;
    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        buyMule.setOnMouseClicked(a ->{
            if(Context.getCurrentPlayer().getBalance() > 100) {
                Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 100);
                Context.getCurrentPlayer().setNumMules(Context.getCurrentPlayer().getNumMules() + 1);
            }
        });
    }
}
