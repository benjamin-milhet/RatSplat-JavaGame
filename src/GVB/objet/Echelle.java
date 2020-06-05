package GVB.objet;

import GVB.GVB;
import iut.Game;
import iut.GameItem;

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
