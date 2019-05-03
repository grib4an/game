package main.level2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import main.Main;

import javax.swing.*;

public class ControllerLevelTree {

    private Timer timer;
    private int testNumber=1;
    private int second=0;
    public static int heal=1000;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView test;

    @FXML
    private ImageView zadanie;

    @FXML
    private ImageView nameZadanie;

    @FXML
    private ImageView andWhat;

    @FXML
    private ImageView oke;

    @FXML
    private ImageView yasno;

    @FXML
    private ImageView pleaceEnd;

    @FXML
    private ImageView answer;

    @FXML
    private TextField numberAnswer;

    @FXML
    private Text hp;

    @FXML
    void initialize() {
        messagShow(zadanie);
        messagShow(nameZadanie);
        myTimer();
        answer.setOnMouseClicked(event -> {

            if(testNumber==2){
                if(numberAnswer.getText().equals("1")){
                    heal+=400;
                    hp.setText("HP: "+heal+"%");
                    messagShow(pleaceEnd);
                    timer.stop();
                    Main.newLevel("level3/level3.fxml");
                }
                if(numberAnswer.getText().equals("2")){
                    heal-=300;
                    hp.setText("HP: "+heal+"%");
                    timer.stop();
                    Main.newLevel("level3/level3.fxml");
                }
                if(numberAnswer.getText().equals("3")){
                    Main.newLevel("endPage/endPage2.fxml");
                }

            }


            if(testNumber==1){
                if(numberAnswer.getText().equals("1")){
                    heal-=10;
                    hp.setText("HP: "+heal+"%");
                    messagShow(yasno);
                    nextTest();
                    testNumber++;
                }
                if(numberAnswer.getText().equals("2")){
                    messagShow(oke);
                    nextTest();
                    testNumber++;
                }

            }


        });

    }


    private void nextTest(){
        test.setViewport(new Rectangle2D(630,0,630,810));
    }


    private void myTimer(){
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                if(second%10==0)
                    messagShow(andWhat);
            }
        });
        timer.start();

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
