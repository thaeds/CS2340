package Store;

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
    private void buyMule() {
        System.out.println("CLICKED MULE");
            if(Context.getCurrentPlayer().getBalance() > 100) {
                Context.getCurrentPlayer().setBalance(Context.getCurrentPlayer().getBalance() - 100);
                Context.getCurrentPlayer().setNumMules(Context.getCurrentPlayer().getNumMules() + 1);
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
