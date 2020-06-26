package GVB.generateur;

import GVB.fakeGVB;
import GVB.personnage.bot.Boss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateurVoleurTest {

    @Test
    void evolve() {
        fakeGVB gvb = new fakeGVB();

        GenerateurVoleur generateurVoleur = new GenerateurVoleur(gvb);
        gvb.addItem(generateurVoleur);

        int i = gvb.getliseObjetSize();
        assertEquals(1,i);
        generateurVoleur.evolve(100000);
        assertEquals(9000,10000 - 1000*generateurVoleur.getCompteurVoleur());
        i = gvb.getliseObjetSize();
        assertEquals(2,i);
        generateurVoleur.evolve(100000);
        assertEquals(8000,10000 - 1000*generateurVoleur.getCompteurVoleur());
        i = gvb.getliseObjetSize();
        assertEquals(3,i);

    }


    @Test
    void generer() {
        fakeGVB gvb = new fakeGVB();

        GenerateurVoleur generateurVoleur = new GenerateurVoleur(gvb);
        gvb.addItem(generateurVoleur);

        int i = gvb.getliseObjetSize();
        assertEquals(1,i);

        generateurVoleur.generer();

         i = gvb.getliseObjetSize();
        assertEquals(2,i);

    }
}