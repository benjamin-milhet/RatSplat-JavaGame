package Menu;

import GVB.GVB;
import iut.Game;
import iut.GameItem;
import iut.Vector;

import java.awt.*;

public class ChoixMenu extends Game {
    private Choix choix;
    public ChoixMenu(int width, int height, String title) {
        super(width, height, title);
        this.play();
    }


    @Override
    protected void createItems() {

    }

    @Override
    protected void drawBackground(Graphics graphics) {

    }

    @Override
    protected void lost() {

    }

    @Override
    protected void win() {

    }

    @Override
    protected boolean isPlayerWin() {
        return false;
    }

    @Override
    protected boolean isPlayerLost() {
        return false;
    }

    @Override
    public Vector getGravity() {
        return null;
    }
}
