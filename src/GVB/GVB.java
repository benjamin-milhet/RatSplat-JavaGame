/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GVB;

import GVB.generateur.GenerateurBoss;
import GVB.generateur.GenerateurButin;
import GVB.generateur.GenerateurMap;
import GVB.generateur.GenerateurVoleur;
import GVB.personnage.Joueur;
import GVB.personnage.bot.Voleur;
import iut.GameItem;
import iut.Vector;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 * Représente un petit jeu simple
 * @author aguidet
 * @version 2020
 */
public class GVB extends iut.Game {

    /**
     * @param args the command line arguments
     * Fonction principal (main)
     */
    public static void main(String[] args) {
        GVB jeu = new GVB();
        jeu.play();
    }

    public GVB(){
        super(800,720,"GVB");//768
        GameItem.DRAW_HITBOX=true; //false
    }
    
    private Joueur j;
    
    @Override
    protected void createItems() {
        int y = this.getHeight()-100;
        j = new Joueur(this,getWidth()/2,y);
        this.addItem(j); //permet d'afficher le joueur
        GenerateurMap g = new GenerateurMap(this);
        g.generer();
        this.addItem(g);
        GenerateurButin b = new GenerateurButin(this);
        b.generer();
        this.addItem(b);
        GenerateurBoss l = new GenerateurBoss(this);
        l.generer();
        this.addItem(l);
        Voleur v = new Voleur(this, 300, y);
        this.addItem(v);
        GenerateurVoleur gv = new GenerateurVoleur(this);
        this.addItem(gv);
        //Score s = new Score(this, 0);
        //this.addItem(s);



    }

    @Override
    protected void drawBackground(Graphics g) {
          g.setColor(Color.BLACK);
          g.fillRect(00, 0, getWidth(), getHeight());
    }

    @Override
    protected void lost() {
        JOptionPane.showMessageDialog(this, "Vous avez perdu");
    }

    @Override
    protected void win() {
        JOptionPane.showMessageDialog(this, "Vous avez gagné");
    }

    @Override
    protected boolean isPlayerWin() {
       return false;
    }

    @Override
    protected boolean isPlayerLost() {
       return false;
    }

    @Override
    public Vector getGravity() {
        return new Vector(); // no gravity in this game
    }
    
}
