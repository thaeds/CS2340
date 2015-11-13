package sample;

//import Map.MapController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

class Controller implements Initializable {
    @FXML private ChoiceBox difficulty;
    @FXML private ChoiceBox map;
    @FXML private ChoiceBox players;
    @FXML private Pane window;
    @FXML private GridPane outerWindow;
    @FXML private ImageView title;
    @FXML private Button nextButton;
    @FXML private Text textMap;
    @FXML private Text textPlayers;
    @FXML private Text textDifficulty;
    @FXML private TextField name;
    @FXML private ChoiceBox race;
    @FXML private ColorPicker color;
    @FXML private Text textName;
    @FXML private Text textRace;
    @FXML private Text textColor;
    @FXML private Button continueButton;
    @FXML private Text finished;
    @FXML private Text playerIndicator;

    private ArrayList<Player> playerList = new ArrayList<>();
    private int numberOfPlayers;
    private int count = 1;
    private int playerNum = 1;
    private String playerName;
    private Stage prevStage;

    public void setPrevStage(Stage stage){
        this.prevStage = stage;
    }

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        window.getChildren().remove(name);
        window.getChildren().remove(race);
        window.getChildren().remove(color);
        window.getChildren().remove(textName);
        window.getChildren().remove(textRace);
        window.getChildren().remove(textColor);
        window.getChildren().remove(continueButton);
        window.getChildren().remove(finished);
        window.getChildren().remove(playerIndicator);
        players.setValue(1);

        Image mule = new Image(getClass().getResource("mule.jpg").toExternalForm());
        Image muleLogo = new Image(getClass().getResource("muleLogo.png").toExternalForm());
        ImagePattern img = new ImagePattern(mule);
        BackgroundFill bgFill = new BackgroundFill(img, new CornerRadii(0), new Insets(0,0,0,0));
        Background bg = new Background(bgFill);
        window.setBackground(bg);
        outerWindow.setStyle("-fx-background-image: url('" + "mule.jpg" + "')");
        title.setImage(muleLogo);
    }
    @FXML public void nextScreen() {
        numberOfPlayers = players.getSelectionModel().getSelectedIndex() + 1;
        window.getChildren().remove(difficulty);
        window.getChildren().remove(map);
        window.getChildren().remove(players);
        window.getChildren().remove(textDifficulty);
        window.getChildren().remove(textMap);
        window.getChildren().remove(textPlayers);
        window.getChildren().remove(nextButton);
        displayPlayerConfig();
    }
    private void displayPlayerConfig() {
        window.getChildren().add(name);
        window.getChildren().add(race);
        window.getChildren().add(color);
        window.getChildren().add(textColor);
        window.getChildren().add(textRace);
        window.getChildren().add(textName);
        window.getChildren().add(playerIndicator);
        race.setItems(FXCollections.observableArrayList("Packer", "Spheroid", "Humanoid", "Leggite", "Bonzoid", "Gollumer"));
        race.setValue("Packer");
        window.getChildren().add(continueButton);
    }
    private void purgePlayerConfig() {
        name.clear();
        window.getChildren().remove(color);
        color.setValue(Color.WHITE);
        race.setValue("Packer");
        playerIndicator.setText("Player " + (playerNum));
        window.getChildren().add(color);

    }
    @FXML public void nextPlayer() throws Exception{
        for (Player p: playerList) {
            if(p.getName().equals(name.getText())) {
                name.setText("Please Enter a unique name");
            }
        }
        if(name.getText().trim().equals("")) {
            name.setText("Please enter a name!");
        }
        else if (!name.getText().trim().equals("") && !name.getText().trim().equals("Please enter a name!")) {
            Player p = new Player(name.getText(), race.getSelectionModel().getSelectedItem().toString(), color.getValue());
            System.out.println(p);
            playerList.add(p);
            playerNum++;
            if (count < numberOfPlayers) {
                purgePlayerConfig();
                count++;
            } else {
                startGame();
            }
        }
    }
    public boolean verifyName() {
        for (Player p: playerList) {
//            if(p.getName().equals(playerName)) {
//                return false;
//            }
            return !(p.getName().equals(playerName));
        }

        return !playerName.trim().equals("");
    }
    private void startGame() throws Exception {
        Context.setPlayers(playerList);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("M.U.L.E");
        Pane myPane = null;
        FXMLLoader ldr = new FXMLLoader();
        myPane = ldr.load(getClass().getResource("../Map/map.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        Context.setMapStage(stage);
        stage.setOnCloseRequest(a -> {
            Platform.exit();
            System.exit(0);
        });
        prevStage.close();
        stage.show();
    }
    public void setName(String n) {
        playerName = n;
    }
    public void addPlayer(Player p) {
        playerList.add(p);
    }
    @FXML
    public void loadSave() {
        Context.readGameSaveState();
    }
}
