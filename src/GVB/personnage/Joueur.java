/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GVB.personnage;

import GVB.GVB;
import GVB.objet.Balle;
import iut.*;

import java.awt.event.*;

public class Joueur extends iut.BoxGameItem implements KeyListener{
    private GameItem echelle;
    private boolean gauchedroite = true;
    /**
     * Initialise le joueur
     * @param g le jeu 
     * @param x la position de départ
     * @param y la position de départ
     */
    public Joueur(Game g, int x, int y) {
        super(g, "joueur", x, y);

    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (this.getLeft() > 0) {
                    if (this.gauchedroite) {
                        this.moveXY(-5, 0);
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (this.getRight() < this.getGame().getWidth()) {
                    if (this.gauchedroite) {
                        this.moveXY(+5, 0);
                    }
                }
                break;
            case KeyEvent.VK_UP:
                if (this.getTop()>=0) {
                    if (this.getRight() <= this.echelle.getRight()) {
                        if (this.getLeft() >= this.echelle.getLeft()) {
                            if (this.getBottom() > this.echelle.getTop()) {
                                this.gauchedroite = false;
                                this.moveXY(0, -5);
                            }
                        }

                    }
                    if (this.getBottom() <= this.echelle.getTop()) {
                        this.gauchedroite = true;

                    }
                }

                break;
            case KeyEvent.VK_DOWN:
                if (this.getRight() <= this.echelle.getRight()) {
                    if (this.getLeft() >= this.echelle.getLeft()) {
                        if (this.getBottom() < this.echelle.getBottom()) {
                            this.gauchedroite = false;
                            this.moveXY(0, +5);
                        }

                    }
                }
                if (this.getBottom() >= this.echelle.getBottom()) {
                    this.gauchedroite = true;
                }

                break;


            case KeyEvent.VK_A:
                Balle ba = new Balle(getGame(),this.getMiddleX()-41,this.getMiddleY(),0.5,180);
                getGame().addItem(ba);
                break;

            case KeyEvent.VK_D:
                Balle bd = new Balle(getGame(),this.getMiddleX()+30,this.getMiddleY(),0.5,0);
                getGame().addItem(bd);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void collideEffect(GameItem gameItem) {
        if (gameItem.getItemType() == "echelle"){
            this.echelle = gameItem;

        }

        if (gameItem.getItemType() == "balle"){
            this.getGame().remove(this);
        }

        if (gameItem.getItemType() == "Voleur"){

        }

    }

    @Override
    public String getItemType() {
        return "Joueur";
    }


    @Override
    public void evolve(long l) {

    }
}
