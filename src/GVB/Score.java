/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GVB;

import iut.*;

import java.awt.*;


/**
 * Objet pour indiquer le score du joueur
 * @author aguidet
 */
public class Score extends iut.GameItem{

    public Score(Game g, int val) {
        super(g, String.valueOf(val), 10, 10);        
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
