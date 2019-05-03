package main.level3.module;



import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

private ImageView imageView;
private MyPers pers;
private int damage=10;
private int speed=2;
private int fightTime=1;
private int heal=600;
public static ArrayList<Enemy> list=new ArrayList<>();

    public Enemy(ImageView image, MyPers pers,int speed){
        list.add(this);

        imageView=image;
        this.pers=pers;
        this.speed=speed;


        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                walk();
                if(fightTime%5==0)
                    fight();
                if(heal<=0){
                    imageView.setVisible(false);
                    stop();
                }
                fightTime++;
            }
        };
        timer.start();

    }


    public void fight() {
        imageView.setViewport(new Rectangle2D(300,0,110,400));
        Random random = new Random();
        int failure = random.nextInt(2) + 1;
        if (failure == 1) {
            int distanceOne = (int) Math.abs(pers.getImageView().getLayoutX() - imageView.getLayoutX());
            if (distanceOne <= 100)
                if (imageView.getLayoutY() + imageView.getFitHeight() >= pers.getImageView().getLayoutY())
                    pers.setHeal(pers.getHeal() - damage);

        }else System.out.println("промах");
    }

    public void walk(){
        int direction= (int) (imageView.getLayoutX()-pers.getImageView().getLayoutX());
        int distanceOne= (int) Math.abs(pers.getImageView().getLayoutX()-imageView.getLayoutX());

        if(distanceOne>=100) {
            if (pers.getImageView().getLayoutY() + pers.getImageView().getFitHeight() >= imageView.getLayoutY()) {
                if (direction <= 0)
                    imageView.setLayoutX(imageView.getLayoutX() + speed);
                else imageView.setLayoutX(imageView.getLayoutX() - speed);
            }
        }
    }


    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }


}
