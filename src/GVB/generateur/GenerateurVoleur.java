package GVB.generateur;

import GVB.personnage.bot.Voleur;
import iut.Game;
import iut.GameItem;

import java.awt.*;
import java.util.Random;

public class GenerateurVoleur extends iut.GameItem{
    private long timeToCreate = 2000;
    //private ArrayList<Integer> etage;
    //private Integer[] etage;
    private int t;
    protected int nbVoleur = 0;

    public GenerateurVoleur(Game g) {
        super(g, "", -1, -1);
        //ArrayList<Integer> etage = new ArrayList<>();
        //Integer[] etage = {80, 260, 440, 620};
        /*etage.add(80);
        etage.add(260);
        etage.add(440);
        etage.add(620);*/
    }
    @Override
    public void draw(Graphics g) throws Exception {

    }

    @Override
    public boolean isCollide(GameItem gameItem) {
        return false;
    }

    @Override
    public void collideEffect(GameItem gameItem) {

    }

    @Override
    public String getItemType() {
        return "GenerateurVoleur";
    }

    @Override
    public void evolve(long l) {
        timeToCreate -= l;
        Random r = new Random();
        t = r.nextInt(4);
        if (timeToCreate <= 0){
            if(nbVoleur < 4){
                if(t == 0){
                    Voleur vo = new Voleur(getGame(), -40, 80);
                    getGame().addItem(vo);
                    timeToCreate =500;
                    System.out.println(t);
                    nbVoleur += 1;
                }
                if(t == 1){
                    Voleur vo = new Voleur(getGame(), -40, 260);
                    getGame().addItem(vo);
                    timeToCreate =500;
                    System.out.println(t);
                    nbVoleur += 1;
                }
                if(t == 2){
                    Voleur vo = new Voleur(getGame(), -40, 440);
                    getGame().addItem(vo);
                    timeToCreate =500;
                    System.out.println(t);
                    nbVoleur += 1;
                }
                if(t == 3){
                    Voleur vo = new Voleur(getGame(), -40, 620);
                    getGame().addItem(vo);
                    timeToCreate =500;
                    System.out.println(t);
                    nbVoleur += 1;
                }
            }
            }

            }

    }



