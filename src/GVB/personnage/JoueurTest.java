package GVB.personnage;

import GVB.Score;
import GVB.fakeGVB;
import GVB.fakeJoueur;
import GVB.objet.Balle;
import GVB.objet.Echelle;
import GVB.personnage.bot.Boss;
import GVB.personnage.bot.Voleur;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void collideEffect() {
        fakeGVB gvb = new fakeGVB();

        fakeJoueur joueur = new fakeJoueur(gvb,50,440);
        gvb.addItem(joueur);

        Score score = new Score(gvb);

        Echelle echelle = new Echelle(gvb,0,0);
        gvb.addItem(echelle);

        Balle balle = new Balle(gvb,100,100,0,180);
        gvb.addItem(balle);


        assertEquals(null,joueur.getEchelle());
        joueur.collideEffect(echelle);
        assertEquals(echelle,joueur.getEchelle());

        assertTrue(gvb.isInGame(joueur));
        joueur.collideEffect(balle);
        assertFalse(gvb.isInGame(joueur));

    }
}