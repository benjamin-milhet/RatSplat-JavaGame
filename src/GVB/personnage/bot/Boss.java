package GVB.personnage.bot;

import GVB.GVB;
import GVB.generateur.GenerateurBoss;
import GVB.objet.Balle;
import iut.Game;
import iut.GameItem;

import java.util.Random;

public class Boss extends iut.BoxGameItem {
    private double vitesse;
    private double angle;
    //private static int nombre=0;
    private boolean gauchedroite = true;
    private long TimeToShoot = 1000;


    public Boss(Game g, int x, int y, double angle, double vitesse) {
        super(g, "boss", x, y);
        this.vitesse = vitesse;
        this.angle = angle;

    }

    @Override
    public void collideEffect(GameItem gameItem) {
        if (gameItem.getItemType() == "balle"){
            this.getGame().remove(this);

        }

    }

    @Override
    public String getItemType() {
        return "boss";
    }

    private void bounce() {
        int posY = 0 ;
        int posX = this.getMiddleX();
        double A = 0;
        this.getGame().remove(this);
        switch (this.getMiddleY()-25){
            case (130):
                posY = 310;
                break;
            case (310):
                Random r1 = new Random();
                int t1 = r1.nextInt(2)+1;
                if (t1 == 1){
                    posY = 130;
                }
                else{
                    posY = 490;
                }
                break;
            case(490):
                Random r2 = new Random();
                int t2 = r2.nextInt(2)+1;
                if (t2 == 1){
                    posY = 670;
                }
                else{
                    posY = 310;
                }
                break;
            case (670):
                posY = 490;
                break;

        }
        A = (this.angle + 180)%360;

        if (this.gauchedroite) {

            if (this.getLeft() <= 0) {
                GenerateurBoss nGL = new GenerateurBoss(this, posY, posX+20, A, this.vitesse + 0.05);
            } else if (this.getRight() > this.getGame().getWidth()) {
                GenerateurBoss nGL = new GenerateurBoss(this, posY, posX-20, A, this.vitesse + 0.05);

            }
            this.gauchedroite = false;
        }


        

    }

    @Override
    public void evolve(long l) {
        this.TimeToShoot -= l;
        double A = 0;
        int x = 0;
         if (this.getLeft() <= 0) {
             bounce();
         }
         else if (this.getRight() > this.getGame().getWidth()) {
             bounce();
         }

         if (this.TimeToShoot <= 0){
             Random r = new Random();
             int t = r.nextInt(2)+1;
             switch (t){
                 case (1):
                     A = 180;
                     x = this.getMiddleX() - 40;
                     break;
                 case (2):
                     A = 0;
                     x = this.getMiddleX() + 40;
                     break;

             }
             Balle ba = new Balle(getGame(), x ,this.getMiddleY(),0.5, A);
             getGame().addItem(ba);
             this.TimeToShoot = 20000;
         }
        this.moveDA(l*this.vitesse, this.angle);

    }
}
