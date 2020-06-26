package GVB.personnage.bot;

import GVB.objet.Balle;
import org.junit.jupiter.api.Test;
import GVB.fakeGVB;
import static org.junit.jupiter.api.Assertions.*;

class VoleurTest {

    @Test
    void collideEffect() {
        fakeGVB gvb = new fakeGVB();

        Voleur voleur = new Voleur(gvb,100,100,0,180,"voleurGauche");
        gvb.addItem(voleur);

        Boss boss = new Boss(gvb,50,440,180,0.1,"bossGauche");
        gvb.addItem(boss);

        Balle balle = new Balle(gvb,100,100,0,180);
        gvb.addItem(balle);



        assertTrue(gvb.isInGame(voleur));
        voleur.collideEffect(boss);
        assertTrue(gvb.isInGame(voleur));
        voleur.collideEffect(balle);
        assertFalse(gvb.isInGame(voleur));
    }

    @Test
    void evolve() {
        fakeGVB gvb = new fakeGVB();

        Voleur voleur = new Voleur(gvb,-2,440,180,0.1,"voleurDroite");
        gvb.addItem(voleur);

        assertTrue(440 == voleur.getMiddleY()-50);
        voleur.evolve(100000);
        assertFalse(440 == voleur.getMiddleY()-50);


    }
}