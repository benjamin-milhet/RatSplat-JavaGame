package GVB.generateur;

import GVB.personnage.bot.Boss;
import iut.Game;
import iut.GameItem;

import java.awt.*;
import java.util.Random;

/**
 * Cette classe permet de générer le boss du jeu une seul fois
 */
public class GenerateurBoss extends GameItem {
    private double vitesse;
    private double angle;
    private int posY;
    private String sens;

    public GenerateurBoss(Game g) {
        super(g, "", -1, -1);
        this.sens = "bossGauche";
    }

    /**
     * Ce deuxième constructeur s'occupe de recréé le boss lorsqu'il change d'étage
     * @param B le boss
     * @param Y sa position en Y
     * @param X sa position en X
     * @param a sa direction (droite ou gauche)
     * @param w et sa vitesse
     */
    public GenerateurBoss(Boss B, int Y, int X, double a, double w, String sens) {
        super(B.getGame(), B.getItemType(), X, Y);
        this.sens = sens;
        Boss newB = new Boss(getGame(), X, Y, a, w, sens);
        getGame().addItem(newB);

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
        return "generateurBoss";
    }

    @Override
    public void evolve(long l) {
    }

    /**
     * Cette méthode s'occupe de generer le boss
     */
    public void generer() {
        // On commence par choisir dans quelle sens  ira le boss au début (droite ou gauche)
        Random random = new Random();
        int t1 = random.nextInt(2)+1;

        switch (t1) {
            case 1:
                this.angle = 0;
                break;
            case 2:
                this.angle = 180;
                break;
            default:
                this.angle = 0;
        }
        //Puis on choisit son étage
        int t2 = random.nextInt(2);
        switch (t2) {
            case 0:
                this.posY = 440;
                break;
            case 1:
                this.posY = 260;
                break;
            case 2:
                this.posY = 80;
                break;
            default:
                this.posY = 440;
        }
        if(this.angle == 180.0){
            this.sens = "bossGauche";
        }
        else{
            this.sens = "bossDroite";
        }
        // Et on le génere dans le jeu
        Boss BL = new Boss(getGame(), getGame().getWidth()/2, this.posY, this.angle, 0.1, this.sens);
        getGame().addItem(BL);
    }
}
