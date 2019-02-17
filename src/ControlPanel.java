import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ControlPanel extends VBox {
    public ControlPanel(Stage stage, Main main){

        TextField textField = new TextField();
        textField.setAccessibleHelp("SearchItem");
        this.getChildren().add(textField);
        Button button = new Button();
        button.setText("Search");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                UserSettings.setSearchString(textField.getText());
                main.startSearch(stage);
            }
        });
        this.getChildren().add(button);
    }
}
