package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    private String nameLevel="startPage/startPage.fxml";
    public  static Stage primaryStage;
    public static Scene scene;
    public static Pane root=new Pane();

    @Override
    public void start(Stage prim){
        primaryStage=prim;

        primaryStage.setTitle("Vizor game");
        newLevel(nameLevel);

        scene=new Scene(root,960,694);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void newLevel(String name) {
        Pane background = null;
        try {
            background = FXMLLoader.load(Main.class.getResource(name));
        } catch (IOException e) {
            System.out.println("exepction load FXML");
        }
        root.getChildren().add(background);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
