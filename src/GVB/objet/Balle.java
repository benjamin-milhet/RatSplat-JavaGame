package GVB.objet;

import iut.Game;
import iut.GameItem;

/**
 * Classe qui représente les balles de pistolet tiré par le boss du jeu
 */
public class Balle extends iut.BoxGameItem {
    private double vitesse;
    private double angle;
    private static int nombre=0;

    /**
     *
     * @param g type de la balle
     * @param x position d'apparition en x
     * @param y position d'apparition en y
     * @param vitesse de la balle
     * @param angle direction de la balle (droite ou gauche)
     */
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

    /**
     * Permet de supprimer la balle si elle sort de la carte
     * @param l
     */
    @Override
    public void evolve(long l) {
         if (this.getLeft() <= 0) {
           this.getGame().remove(this);
        } else if (this.getRight() > this.getGame().getWidth()) {
           this.getGame().remove(this);
         }
        this.moveDA(l*vitesse, angle);
    }
}
