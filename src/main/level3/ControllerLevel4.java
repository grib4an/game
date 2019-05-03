package main.level3;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import main.Main;
import main.level3.module.Enemy;
import main.level3.module.MyPers;
import main.level2.ControllerLevelTree;

public class ControllerLevel4 {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text hp;

    @FXML
    private ImageView fight;

    @FXML
    private ImageView firstEnemy;

    @FXML
    private ImageView secondEnemy;

    @FXML
    private ImageView my;

    @FXML
    void initialize() {
        MyPers myPers=new MyPers(my);
        myPers.setHeal(ControllerLevelTree.heal);

        Enemy enemyOne=new Enemy(firstEnemy,myPers,1);
        Enemy enemyTwo=new Enemy(secondEnemy,myPers,2);




        messagShow(fight);
        listener(myPers);

        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(myPers.getHeal()<=0)
                    Main.newLevel("endPage/endPage2.fxml");
                if(enemyOne.getHeal()<=0 && enemyTwo.getHeal()<=0)
                    Main.newLevel("endPage/endPage1.fxml");
                hp.setText("HP: "+myPers.getHeal()+"%");

            }
        };
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
                        System.out.println("EXEPTION in LEVEL3 method messagShow");
                    }
                    img.setVisible(false);
                }
            });

            thread.start();
        }

    }


    private void listener(MyPers pers){

                Main.primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCode()==KeyCode.LEFT) {
                            pers.run(-1);
                            pers.getImageView().setViewport(new Rectangle2D(150,400,150,400));
                        }
                        if(event.getCode()==KeyCode.RIGHT) {
                            pers.run(1);
                            pers.getImageView().setViewport(new Rectangle2D(0,0,150,400));
                        }
                        if(event.getCode()==KeyCode.UP)
                            pers.fly();
                        if(event.getCode()==KeyCode.SPACE) {
                            pers.fight();
                            pers.getImageView().setViewport(new Rectangle2D(300,0,120,400));
                        }
                    }
                });

                Main.primaryStage.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCode()==KeyCode.SPACE)
                            pers.getImageView().setViewport(new Rectangle2D(150,0,130,400));
                    }
                });

            }
}

