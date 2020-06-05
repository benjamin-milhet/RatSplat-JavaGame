package GVB.objet;

import GVB.GVB;
import iut.Game;
import iut.GameItem;

public class Butin extends iut.BoxGameItem {
    private static int nombre;
    public Butin(Game g, int x, int y) {
        super(g, "butin", x, y);
        ++nombre;
    }

    @Override
    public void collideEffect(GameItem gameItem) {
        if(gameItem.getItemType() == "Voleur"){
            this.getGame().remove(this);
            --nombre;
        }
        if(gameItem.getItemType() == "Joueur"){
            //this.getGame().remove(this);
            //--nombre;
        }
    }

    @Override
    public String getItemType() {
        return "butin";
    }

    @Override
    public void evolve(long l) {
        if (nombre<=0){
            //this.getGame().die();
        }

    }
}
