package GVB.objet;

import GVB.generateur.GenerateurButin;
import GVB.personnage.bot.Voleur;
import org.junit.jupiter.api.Test;
import GVB.fakeGVB;

import static org.junit.jupiter.api.Assertions.*;

class ButinTest {

    @Test
    void collideEffect() {
        fakeGVB gvb = new fakeGVB();

        GenerateurButin generateurButin = new GenerateurButin(gvb);
        gvb.addItem(generateurButin);
        generateurButin.generer();

        Butin butin = new Butin(gvb,0,0,generateurButin);
        gvb.addItem(butin);

        Voleur voleur = new Voleur(gvb,0,0,0,0,"voleurDroite");
        gvb.addItem(voleur);

        assertTrue(gvb.isInGame(butin));
        assertEquals(4,generateurButin.getNbArgent());
        butin.collideEffect(voleur);
        assertFalse(gvb.isInGame(butin));
        assertEquals(3,generateurButin.getNbArgent());




    }
}