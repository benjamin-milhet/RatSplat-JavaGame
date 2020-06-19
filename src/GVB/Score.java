/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GVB;

import iut.*;

import java.awt.*;

import static GVB.GVB.debut;

/**
 * Objet pour indiquer le score du joueur
 * @author aguidet
 */
public class Score extends iut.GameItem{

    private long nicolas;

    public Score(Game g) {
        super(g, "", 10, 10);
        this.nicolas = 5000;
    }

    public long getExecTimer() throws InterruptedException {
        long fin = System.currentTimeMillis();
        long score = (fin - debut)/1000;
        return score;
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
       return "Score";
    }
}
