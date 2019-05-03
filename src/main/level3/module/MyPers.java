package main.level3.module;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

import java.util.Random;

public class MyPers {

    private ImageView imageView;
    private int secondFly=0;
    private int attractionValue=2;
    private int heal=1000;
    private int speed=10;
    private int damage=20;

    public MyPers(ImageView imageView){
        this.imageView=imageView;

        AnimationTimer flyTimer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                attraction();
                System.out.println("my life="+heal);
            }
        };
        flyTimer.start();


    }

    public void run(int direction){
        imageView.setLayoutX(imageView.getLayoutX()+(speed*direction));
    }

    public void fight(){

        for(int i=0;i<Enemy.list.size();i++){
            Enemy enemy= Enemy.list.get(i);
            Random random=new Random();
            int damage=this.damage;
            int distanceOne= (int) Math.abs(enemy.getImageView().getLayoutX()-imageView.getLayoutX());
            int strongDamage=random.nextInt(10)+1;

            if(strongDamage==5)
                damage=this.damage*5;



            if(distanceOne<=100)
                if (imageView.getLayoutY() + imageView.getFitHeight() >= enemy.getImageView().getLayoutY())
                    enemy.setHeal(enemy.getHeal() - damage);


        }


    }

    private void attraction(){
        if(imageView.getLayoutY()<=337)
            imageView.setLayoutY(imageView.getLayoutY()+attractionValue);
    }

    public void fly(){
        if(imageView.getLayoutY()>=135)
            imageView.setLayoutY(imageView.getLayoutY()-6);

    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
