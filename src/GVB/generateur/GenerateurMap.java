package GVB.generateur;

import GVB.GVB;
import GVB.objet.Echelle;
import GVB.objet.Mur;
import iut.Game;
import iut.GameItem;

import java.awt.*;
import java.util.Random;

public class GenerateurMap extends GameItem {
    //private long time = 2000;

    public GenerateurMap(Game g) {
        super(g, "", -1, -1);
    }

    @Override
    public void draw(Graphics g) throws Exception {

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
        return "GenerateurMap";
    }

    @Override
    public void evolve(long l) {
    }

    public void generer(){
        int posX = 0;
        int posY = 540;
        //int x = 0;
        //int y = 700;
        int i = 0;
        int j = 0;
        int t1 = 40;
        //boolean test = true;
        while (j<4) {
            Random r = new Random();
            int t = r.nextInt(15);
            while (t == t1){
                t = r.nextInt(15);
            }

            while (i < 16) {
                //x = r.nextInt(779);
                /*if(test) {
                    System.out.println("test");
                    Butin a = new Butin(getGame(), x, y);
                    getGame().addItem(a);
                    test = false;
                }*/

                if (i == t) {
                    t1 = t;
                    Echelle e = new Echelle(getGame(), posX, posY);
                    getGame().addItem(e);
                }

                else {
                    Mur m = new Mur(getGame(), posX, posY);
                    getGame().addItem(m);


                }

                posX += 50;
                i++;


            }
            //y -= 180;
            //test = true;
            i = 0;
            posX = 0;
            posY -= 180;
            j++;
        }


    }
}
