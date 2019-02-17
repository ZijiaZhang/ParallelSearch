import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindow extends HBox {

    public BrowserWindow(){
        List<String> domains =  UserSettings.getSearchDomains();
        int number = domains.size();
        for(String url: domains) {
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            webView.setPrefWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / number);
            webView.setPrefHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            webEngine.load(url);
            this.getChildren().add(webView);
        }
    }

    public BrowserWindow(String searchItem){
        List<String> domains =  UserSettings.getSearchDomains();
        int number = domains.size();
        for(String url: domains) {
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            webView.setPrefWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / number);
            webView.setPrefHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            webEngine.load(url+searchItem);
            webView.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            Desktop.getDesktop().browse(new URI(webEngine.getLocation()));
                            System.exit(0);
                        }
                    }catch (Exception e){
                        //
                    }
                }
            });
            this.getChildren().add(webView);
        }
    }

}
