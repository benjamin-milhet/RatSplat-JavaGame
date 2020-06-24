/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GVB;

import GVB.generateur.*;
import GVB.personnage.Joueur;
import iut.GameItem;
import iut.Vector;

import java.awt.*;
import javax.swing.JOptionPane;

/**
 * Main du jeu : grand vol de banque
 * @author les seigneurs du ganges
 * @version 2020
 */
public class GVB extends iut.Game {
    public static long debut = System.currentTimeMillis();
    private GenerateurButin generateurButin;
    private Joueur j;



    public GVB(){
        super(800,720,"GVB");//768
        GameItem.DRAW_HITBOX=false;
    }

    /**
     * @param args the command line arguments
     * Fonction principal (main)
     */
    public static void main(String[] args) {
        GVB jeu = new GVB();
        jeu.play();

    }
    @Override
    protected void createItems() {
        //creer le son
        son s = new son();
        s.test();
        //creer la map
        GenerateurMap g = new GenerateurMap(this);
        g.generer();
        this.addItem(g);
        //creer le joueur
        int y = this.getHeight()-100;
        j = new Joueur(this,getWidth()/2,y);
        this.addItem(j); //permet d'afficher le joueur
        //creer les butins
        this.generateurButin = new GenerateurButin(this);
        this.generateurButin.generer();
        this.addItem(this.generateurButin);
        //creer le boss
        GenerateurBoss l = new GenerateurBoss(this);
        l.generer();
        this.addItem(l);
        //Creer les voleurs
        GenerateurVoleur gv = new GenerateurVoleur(this);
        this.addItem(gv);
    }

    @Override
    protected void drawBackground(Graphics g) {
          g.setColor(Color.BLACK);
          g.fillRect(00, 0, getWidth(), getHeight());
    }

    @Override
    protected void lost() {
        JOptionPane.showMessageDialog(this, "Vous avez perdu");
        System.exit(0);
    }

    @Override
    protected void win() {
        JOptionPane.showMessageDialog(this, "Vous avez gagné");
        System.exit(0);
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
