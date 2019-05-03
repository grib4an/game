package main.startPage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import main.Main;

public class ControllerStartPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView startButton;

    @FXML
    private ImageView exitButton;

    @FXML
    void initialize() {
       startButton.setOnMousePressed(event->{
           smalButton(startButton);
       });
       startButton.setOnMouseReleased(event -> {
           Main.newLevel("level1/level1.fxml");
       });


       exitButton.setOnMousePressed(event -> {
           smalButton(exitButton);
       });
       exitButton.setOnMouseReleased(event->{
           System.exit(0);
       });
    }

    private void smalButton(ImageView img){
        img.setX(img.getX()+img.getFitWidth()/4);
        img.setY(img.getY()+img.getFitHeight()/4);
        img.setFitHeight(img.getFitHeight()/2);
        img.setFitWidth(img.getFitWidth()/2);
    }

}
