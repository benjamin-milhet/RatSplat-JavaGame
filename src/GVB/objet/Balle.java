package GVB.objet;

import GVB.GVB;
import iut.Game;
import iut.GameItem;

public class Balle extends iut.BoxGameItem {
    private double vitesse;
    private double angle;
    private static int nombre=0;


    public Balle(Game g, int x, int y, double vitesse, double angle) {
        super(g, "balle", x, y);
        this.vitesse = vitesse;
        this.angle = angle;
        nombre++;
    }

    @Override
    public void collideEffect(GameItem gameItem) {

    }

    @Override
    public String getItemType(){
        return "balle";
    }

    @Override
    public void evolve(long l) {
         if (this.getLeft() <= 0) {
           this.getGame().remove(this);
           System.out.println("1");
        } else if (this.getRight() > this.getGame().getWidth()) {
           this.getGame().remove(this);
             System.out.println("2");


         }
        this.moveDA(l*vitesse, angle);


    }
}
