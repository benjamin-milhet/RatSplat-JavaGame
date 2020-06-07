package GVB.generateur;

import GVB.GVB;
import GVB.objet.Echelle;
import GVB.objet.Mur;
import iut.Game;
import iut.GameItem;

import java.awt.*;
import java.util.Random;

/**
 * Cette classe permet de générer les différents étages de la map une seul fois au début de la partie
 */
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

    /**
     * Cette méthode génere les 4étage de la map et aisni que les échelles afin de changer d'étages
     */
    public void generer(){
        int posX = 0;
        int posY = 540;
        int i = 0;
        int j = 0;
        int t1 = 40;
        //On commence par choisir le nombre d'étage, ici 4
        while (j<4) {
            Random r = new Random();
            int t = r.nextInt(15);
            //Puis on place les briques pour un étage en y laissant un trou
            while (t == t1){
                t = r.nextInt(15);
            }

            while (i < 16) {
                // Afin d'y placer l'échelle
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
            i = 0;
            posX = 0;
            posY -= 180;
            j++;
        }


    }
}
