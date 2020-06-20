package GVB.objet;

import GVB.Score;
import GVB.generateur.GenerateurButin;
import iut.Game;
import iut.GameItem;

import java.awt.*;

/**
 * Cette classe représente un objet de type butin, il doit être défendue par le joueur contre les voleurs
 */
public class Butin extends iut.BoxGameItem {
    private GenerateurButin generateurButin;
    public Butin(Game g, int x, int y, GenerateurButin generateurButin) {
        super(g, "butin", x, y);
        this.generateurButin = generateurButin;
    }

    /**
     * Permet de supprimer le butin si un voleur l'attrape, S'il il n'y plus butin, le joueur a perdu
     * @param gameItem objet que peut rencontrer le butin
     */
    @Override
    public void collideEffect(GameItem gameItem) {
        Score score = new Score(getGame());
        if(gameItem.getItemType() == "voleur"){
            this.getGame().remove(this);
            this.generateurButin.enlever();
            if(this.generateurButin.getNbArgent() <=0 ){
                try {
                    score.getExecTimer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.getGame().die();
            }
        }
        if(gameItem.getItemType() == "Joueur"){
            //this.getGame().remove(this);
            //--nombre;
        }
    }

    /*@Override
    public void draw(Graphics g) throws Exception {
        String s = "Vie restante : " + this.generateurButin.getNbArgent();
        g.setColor(Color.YELLOW);
        Font font = new Font("Bookman Old Style", 1, 25);
        g.setFont(font);
        g.drawString(s, 500, 20);
    }*/

    @Override
    public String getItemType() {
        return "butin";
    }

    @Override
    public void evolve(long l) {
    }
}
