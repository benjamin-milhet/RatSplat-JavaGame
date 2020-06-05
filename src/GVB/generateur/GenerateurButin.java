package GVB.generateur;

import GVB.GVB;
import GVB.objet.Butin;
import iut.Game;
import iut.GameItem;

import java.awt.*;
import java.util.Random;

public class GenerateurButin extends iut.GameItem{
    private int nbArgent;


    public GenerateurButin(Game g) {
        super(g, "", -1, -1);
    }

    @Override
    public void draw(Graphics g) throws Exception {

    }

    @Override
    public boolean isCollide(GameItem o) {
        return false;
    }

    @Override
    public void collideEffect(GameItem o) {

    }

    @Override
    public void evolve(long dt) {


    }

    @Override
    public String getItemType() {
        return "GenerateurButin";
    }

    public void generer(){
        int x = 0;
        int y = 700;
        int i = 0;
        int j = 0;
        boolean test = true;
        while (j<4) {
            Random r = new Random();
            while (i < 16) {
                x = r.nextInt(779);
                if(test) {
                    //System.out.println("test");
                    Butin a = new Butin(getGame(), x, y);
                    getGame().addItem(a);
                    test = false;
                }

                i++;


            }
            y -= 180;
            test = true;
            i = 0;
            j++;
        }


    }

}

