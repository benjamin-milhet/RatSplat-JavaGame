package GVB.personnage.bot;

import iut.Game;
import iut.GameItem;

public class Voleur extends iut.BoxGameItem{

    private boolean touched = false;
    private double vitesse = 0.5;

    public Voleur(Game g, int x, int y) {
        super(g, "voleur", x, y);
    }

    public void changeCote(){

    }

    @Override
    public void collideEffect(GameItem o) {
        if(o.getItemType() == "butin"){

        }
        if(o.getItemType() == "Joueur"){
            //getGame().remove(this);
        }

    }

    @Override
    public String getItemType() {
        return "Voleur";
    }

    @Override
    public void evolve(long l) {

        if(this.getRight() > this.getGame().getWidth()){
            //vitesse = -vitesse;
        }
        if(this.getLeft() < -40){
            this.getGame().remove(this);
            Voleur vg = new Voleur(this.getGame(), 800, 80);
            getGame().addItem(vg);
        }
        if(this.getRight() > this.getGame().getWidth()+40){
            this.getGame().remove(this);
            Voleur vd = new Voleur(this.getGame(), -40, 80);
            getGame().addItem(vd);

        }
        
        this.moveXY(vitesse*7, 0);

    }
}
