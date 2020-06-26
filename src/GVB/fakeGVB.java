package GVB;

import iut.GameItem;
import iut.Vector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class fakeGVB extends iut.Game {
    private ArrayList<GameItem> listeObjetTest;

    public fakeGVB(){
        super(800,720,"GVB");//768
        GameItem.DRAW_HITBOX=false;
        this.listeObjetTest = new ArrayList<>();

    }

    @Override
    protected void createItems() {

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
        return null;
    }


    //Impossible de tester sans lancer le jeu (a cause du framework) du coup on crééer une fausse lise juste pour test
    @Override
    public void addItem(GameItem o) {
        super.addItem(o);
        this.listeObjetTest.add(o);
    }

    @Override
    public boolean isInGame(GameItem o) {
        return this.listeObjetTest.contains(o);
    }

    @Override
    public void remove(GameItem o) {
        super.remove(o);
        this.listeObjetTest.remove(o);
    }

    public int getliseObjetSize(){
        return this.listeObjetTest.size();
    }
}
