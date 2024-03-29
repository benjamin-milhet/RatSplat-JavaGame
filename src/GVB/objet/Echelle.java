package GVB.objet;

import iut.Game;
import iut.GameItem;

/**
 * Cette classe représente un objet de type échelle
 * @author Benjamin Milhet
 */
public class Echelle extends iut.BoxGameItem{
    public Echelle(Game g, int x, int y) {
        super(g, "echelle", x, y);
    }

    @Override
    public void collideEffect(GameItem gameItem) {
    }

    @Override
    public String getItemType() {
        return "echelle";
    }

    @Override
    public void evolve(long l) {
    }
}
