import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.fullScreenExitKeyProperty().set(KeyCombination.NO_MATCH);

        stage.setFullScreen(true);
        UserSettings.addDomain("https://www.google.ca/search?q=");
        UserSettings.addDomain("https://www.bestbuy.ca/en-CA/Search/SearchResults.aspx?query=");
        UserSettings.addDomain("https://www.amazon.ca/s?k=");
        ControlPanel controlPanel = new ControlPanel(stage,this);
        Scene root = new Scene(controlPanel);
        stage.setScene(root);
        stage.show();
    }


    public void startSearch(Stage stage){
        BrowserWindow browserWindow = new BrowserWindow(UserSettings.getSearchString());
        stage.getScene().setRoot(browserWindow);

    }

}
