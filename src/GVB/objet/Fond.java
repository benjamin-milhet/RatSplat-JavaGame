package GVB.objet;

import iut.Game;
import iut.GameItem;

public class Fond extends GameItem {
    public Fond(Game g, double _x, double _y) {
        super(g, "fond", _x, _y);
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
        return "fond";
    }

    @Override
    public void evolve(long l) {

    }
}
