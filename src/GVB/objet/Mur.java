package GVB.objet;

import iut.Game;
import iut.GameItem;

/**
 * Cette classe représente un objet de type mur
 */
public class Mur extends iut.BoxGameItem{
    private String nom;

    public Mur(Game g, int x, int y) {
        super(g, "mur", x, y);
    }

    @Override
    public void collideEffect(GameItem gameItem) {
    }

    @Override
    public String getItemType() {
        return null;
    }

    @Override
    public void evolve(long l) {
    }
}
