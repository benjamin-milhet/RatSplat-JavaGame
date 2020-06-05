package GVB.generateur;

import GVB.GVB;
import GVB.personnage.bot.Boss;
import iut.Game;
import iut.GameItem;

import java.awt.*;
import java.util.Random;

public class GenerateurBoss extends GameItem {
    private double vitesse;
    private double angle;
    private int posY;

    public GenerateurBoss(Game g) {
        super(g, "", -1, -1);
    }


    public GenerateurBoss(Boss B, int Y, int X, double a, double w) {
        super(B.getGame(), B.getItemType(), X, Y);
        Boss newB = new Boss(getGame(), X, Y, a, w);
        getGame().addItem(newB);

    }

    @Override
    public void draw(Graphics g) throws Exception {

    }


    @Override
    public boolean isCollide(GameItem gameItem) {
        return false;
    }

    @Override
    public void collideEffect(GameItem gameItem) {

    }

    @Override
    public String getItemType() {
        return "generateurBoss";
    }

    @Override
    public void evolve(long l) {

    }

    public void generer() {
        Random r1 = new Random();
        int t1 = r1.nextInt(2)+1;

        switch (t1) {
            case 1:
                this.angle = 0;
                break;
            case 2:
                this.angle = 180;
                break;
            default:
                this.angle = 0;
        }
        //Random r2 = new Random();
        int t2 = r1.nextInt(2);
        switch (t2) {
            case 0:
                this.posY = 490;
                break;
            case 1:
                this.posY = 310;
                break;
            case 2:
                this.posY = 130;
                break;
            default:
                this.posY = 490;

        }

        Boss BL = new Boss(getGame(), getGame().getWidth()/2, this.posY, this.angle, 0.1);
        getGame().addItem(BL);

    }
}
