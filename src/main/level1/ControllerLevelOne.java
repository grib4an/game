package main.level1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import main.Main;

public class ControllerLevelOne {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView teleport;

    @FXML
    private ImageView picture;

    @FXML
    private ImageView door;

    @FXML
    private ImageView window;

    @FXML
    private ImageView neighbor;

    @FXML
    private ImageView bed;

    @FXML
    private ImageView nipple;

    @FXML
    private ImageView doorMessage;

    @FXML
    private ImageView pictureMessage;

    @FXML
    private ImageView windowMessage;

    @FXML
    private ImageView neighborMessage;

    @FXML
    private ImageView bedMessage;

    @FXML
    private ImageView bingo;

    @FXML
    private ImageView preLevel;

    @FXML
    void initialize() {

        messagShow(preLevel);

        picture.setOnMouseClicked(event->{
            messagShow(pictureMessage);
        });

        door.setOnMouseClicked(event->{
            messagShow(doorMessage);
        });

        window.setOnMouseClicked(event->{
            messagShow(windowMessage);
        });

        bed.setOnMouseClicked(event->{
            messagShow(bedMessage);
        });

        neighbor.setOnMouseClicked(event->{
            messagShow(neighborMessage);
        });


        nipple.setOnMouseClicked(event -> {
            messagShow(bingo);
            picture.setVisible(false);
            nipple.setVisible(false);
        });

        teleport.setOnMouseClicked(event -> {
            if(!picture.isVisible()) {
                System.out.println("переход на след левел");
                Main.newLevel("level2/level2.fxml");
            }
        });

    }

    private void messagShow(ImageView img){
        if(!img.isVisible()){
           img.setVisible(true);

           Thread thread=new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       Thread.sleep(3000);
                   } catch (InterruptedException e) {
                       System.out.println("FUCK SLEEP");
                   }
                   img.setVisible(false);
               }
           });

           thread.start();
        }

    }

}



