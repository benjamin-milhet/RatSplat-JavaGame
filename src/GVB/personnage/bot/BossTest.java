package GVB.personnage.bot;

import GVB.GVB;
import GVB.fakeGVB;
import GVB.objet.Balle;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    @Test
    void evolve() {
        GVB gvb = new GVB();
        Boss boss = new Boss(gvb,50,440,180,0.1,"bossGauche");
        gvb.addItem(boss);
        assertEquals(1000,boss.getTimeToShoot());
        assertTrue(boss.getMiddleY()-50 == 440);

        boss.evolve(100000);
        if (boss.getSens().equals("bossGauche")){
            assertEquals(boss.getAngle(),180);
        }
        else if (boss.getSens().equals("bossDroite")){
            assertEquals(boss.getAngle(),0);

        }
        assertFalse(boss.getMiddleY()-50 == 440);
        assertEquals(20000,boss.getTimeToShoot());
    }

    @Test
    void collideEffect() {
        fakeGVB gvb = new fakeGVB();
        Boss boss = new Boss(gvb,50,440,180,0.1,"bossGauche");
        gvb.addItem(boss);

        Balle balle = new Balle(gvb,100,100,0,180);
        gvb.addItem(balle);

        Voleur voleur = new Voleur(gvb,100,100,0,180,"voleurGauche");
        gvb.addItem(voleur);

        assertTrue(gvb.isInGame(boss));
        boss.collideEffect(voleur);
        assertTrue(gvb.isInGame(boss));
        boss.collideEffect(balle);
        assertFalse(gvb.isInGame(boss));
    }
}