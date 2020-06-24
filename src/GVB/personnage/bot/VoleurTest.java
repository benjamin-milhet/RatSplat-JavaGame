package GVB.personnage.bot;

import GVB.GVB;
import GVB.objet.Balle;
import iut.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoleurTest {
    private GVB game;
    private Voleur voleur;

    public VoleurTest(){
        game = new GVB();
        voleur = new Voleur(game,50,50,180,0,"voleurDroite");
    }

    @Test
    void collideEffect() {
        game.addItem(voleur);
        assertTrue(game.isInGame(voleur));
        Balle balle = new Balle(game,100,100,0,180);
        game.addItem(balle);
        assertEquals(game.isInGame(voleur),false);
    }
}